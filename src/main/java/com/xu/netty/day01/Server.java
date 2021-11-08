package com.xu.netty.day01;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * java_study
 */
public class Server {

    public static ChannelGroup clients = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    public static void main(String[] args) {
        // 酒店大管家：负责将客人迎入酒店
        EventLoopGroup boss = new NioEventLoopGroup();
        // 酒店工作人员：负责为大管家迎入的客人服务
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        // 类似于酒店
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(boss, workerGroup).channel(NioServerSocketChannel.class)
                .childHandler(new ServerInBoundHandler());
        try {
            // 注册一个监听端口，同步等待
            ChannelFuture future = bootstrap.bind(7999).sync();
            System.out.println("server started!");
            // 定义一个看门的，时刻观察酒店是否关门，一关门就处理相关内容
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            boss.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}

class ServerInBoundHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("client connect suc" + ctx);
        Server.clients.add(ctx.channel());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // System.out.println("read suc");
        // ByteBuf buf = (ByteBuf) msg;
        // System.out.println(buf.toString(CharsetUtil.UTF_8));
        // ctx.writeAndFlush(Unpooled.copiedBuffer("hello client".getBytes()));

        Server.clients.writeAndFlush(msg);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("exception cause" + cause);
    }
}
