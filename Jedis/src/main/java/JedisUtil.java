import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtil {
    //定义连接池对象
    private static JedisPool pool=null;
    //创建连接池
    public static JedisPool open(String host,int port){
        if(pool==null){
            //使用JedisPool
            JedisPoolConfig config=new JedisPoolConfig();
            //设置最大的线程数，一个线程就是一个Jedis
            config.setMaxTotal(20);
            //设置最大空闲数，保留足够连接，快速获取Jedis对象
            config.setMaxIdle(5);
            //提前检查Jedis对象，为true获取的Jedis一定是可用的
            config.setTestOnBorrow(true);
            //创建Jedis连接池，Redis没有密码使用
            //pool=new JedisPool(config,host,port);
            //有密码使用 timeout：超时时间
            pool=new JedisPool(config,host,port,6*1000,"huangdi123");

        }
        return pool;
    }
    //关闭连接池
    public static void close(){
        if(pool!=null){
            pool.close();
        }
    }
}
