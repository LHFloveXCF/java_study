package com.xu.netty.day01;

import com.xu.netty.day01.net.ClientFrame;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * java_study
 */
public class ClientChannelInboundHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx);
        // ByteBuf buf = Unpooled.copiedBuffer("hello server".getBytes());
        // ctx.writeAndFlush(buf);

        // byte[] bytes = ClientFrame.getFrame().getTf().getText().getBytes();
        // ctx.writeAndFlush(Unpooled.copiedBuffer(bytes));
    }



    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("read " + ctx);
        ByteBuf buf = (ByteBuf) msg;
        // // System.out.println("client receive " + buf.toString(CharsetUtil.UTF_8));
        //
        String string = buf.toString(CharsetUtil.UTF_8);
        System.out.println(string);
        ClientFrame frame = ClientFrame.getFrame();
        System.out.println(frame.hashCode());
        frame.updateMsg(string);
    }


}
