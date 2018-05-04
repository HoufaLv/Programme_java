package springJedisTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-redis-data-cluster.xml")
public class JedisSpringDateCluster {

    private RedisTemplate redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
    }

    @Test
    public void setStringTestCase() {
        //redisTemplate.opsForValue().set("name:1001","tom");
    }

    @Test
    public void getStringTestCase() {
        String name = (String) redisTemplate.opsForValue().get("name:1");
        System.out.println("name = " + name);
    }

    @Test
    public void batchInsertTestCase() {

        long begin = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
            redisTemplate.opsForValue().set("address:" + i, "address:" + i);
        }

        long end = System.currentTimeMillis();


    }

    @Test
    public void batchInsertTestCaseNumber() {

        long begin = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            redisTemplate.opsForValue().set("id:" + i, ""+i);
        }

        long end = System.currentTimeMillis();

        long time = end - begin;
        System.out.println("time" + time/1000);

    }
}
