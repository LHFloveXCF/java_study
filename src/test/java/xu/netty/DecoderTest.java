package xu.netty;

import com.xu.netty.day01.net04.Tank;
import com.xu.netty.day01.net04.TankDecoder;
import com.xu.netty.day01.net04.TankEncoder;
import io.netty.channel.embedded.EmbeddedChannel;
import org.junit.Test;

/**
 * java_study
 */
public class DecoderTest {
    @Test
    public void test1() {
        EmbeddedChannel channel = new EmbeddedChannel(new TankEncoder(), new TankDecoder());
        channel.writeInbound(new Tank(1, 3));
        channel.finish();

        Object o = channel.readInbound();
        Tank tank = (Tank) o;
        System.out.println(tank.toString());
    }
}
