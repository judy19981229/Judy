import org.junit.Test;
import redis.clients.jedis.Jedis;

public class JedisTest {

    @Test
    public void connect(){
        //参数：String host，int post
        Jedis jedis=new Jedis("1.117.94.228",6379);
        //参数：String password
        jedis.auth("huangdi123");
        jedis.set("k2","v2");
    }
}
