package com.xu.netty.day01.net02;

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
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();
        try {
            ChannelFuture f = b.group(group).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new ClientHandler());
                }
            }).connect("localhost", 7999);

            f.addListener((ChannelFutureListener) future -> {
                if (!future.isSuccess()) {
                    System.out.println("链接失败");
                } else {
                    channel = future.channel();
                }
            });

            f.sync();

            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }

    public void send(String msg) {
        channel.writeAndFlush(Unpooled.copiedBuffer(msg.getBytes()));
        if ("byte".equals(msg)) {
            closeConnect();
        }
    }

    public void closeConnect() {
        channel.closeFuture();
    }
}

class ClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello".getBytes()));
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String str = ((ByteBuf) msg).toString(CharsetUtil.UTF_8);
        ClientFrame.getInstance().updateTextArea(str);
    }
}

