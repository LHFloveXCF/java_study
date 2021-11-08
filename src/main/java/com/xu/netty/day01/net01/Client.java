package com.xu.netty.day01.net01;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

/**
 * java_study
 */
public class Client {
    private Channel channel = null;

    public void connect() {
        EventLoopGroup group = new NioEventLoopGroup(1);
        Bootstrap b = new Bootstrap();
        b.group(group).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();
                pipeline.addLast(new MyClientChannelInBoundHandler());
            }
        });


        try {
            ChannelFuture future = b.connect("localhost", 7999);
            future.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    if (!future.isSuccess()) {
                        System.out.println("connect fail");
                    } else {
                        channel = future.channel();
                    }
                }
            });
            future.sync();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }

    public void sendMsg(String msg) {
        channel.writeAndFlush(Unpooled.copiedBuffer(msg.getBytes()));
    }
}


class MyClientChannelInBoundHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // System.out.println("read " + ctx);
        ByteBuf buf = (ByteBuf) msg;
        String string = buf.toString(CharsetUtil.UTF_8);
        // System.out.println(string);
        ClientFrame frame = ClientFrame.getFrame();
        // System.out.println(frame.hashCode());
        frame.updateMsg(string);
    }
}
