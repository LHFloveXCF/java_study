package com.xu.netty.day01.net04;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * java_study
 */
public class TankEncoder extends MessageToByteEncoder<Tank> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Tank msg, ByteBuf out) throws Exception {
        out.writeInt(msg.x);
        out.writeInt(msg.y);
    }
}
