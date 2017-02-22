package time.pojo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Created by listening on 2016/10/21.
 */
public class TimeEncoder2 extends MessageToByteEncoder<Time> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Time msg, ByteBuf out) throws Exception {
        out.writeInt((int) msg.getValue());
    }
}
