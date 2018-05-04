package springJedisTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.JedisCluster;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-redis-cluster.xml")
public class JedisSpringCluster {

    @Autowired
    JedisCluster jedisCluster;

    @Test
    public void jedisClusterSetTestCase(){
        jedisCluster.set("name:1001","jack");
    }

    @Test
    public void jedisClusterGetTestCase(){
        String name = jedisCluster.get("name:1001");
        System.out.println("name = " + name);
    }
}
