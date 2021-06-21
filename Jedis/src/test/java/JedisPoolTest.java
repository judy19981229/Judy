import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisPoolTest {

    @Test
    public void connect(){
        //创建JedisPool对象，从JedisPool中获取Jedis
        JedisPool pool=null;
        //创建Jedis对象
        Jedis jedis=null;

        try {
            pool=JedisUtil.open("1.117.94.228",6379);
            jedis= pool.getResource();
            System.out.println(jedis.get("k2"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(jedis!=null){
                jedis.close();
            }
        }
    }
}
