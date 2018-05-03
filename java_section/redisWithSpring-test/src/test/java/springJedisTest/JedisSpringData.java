package springJedisTest;

import com.ksit.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-data-redis.xml")
public class JedisSpringData {

    // TODO: 2018/5/3 0003 使用set注入,将key和value 都序列化,方便查看

    private RedisTemplate redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.redisTemplate.setKeySerializer(new StringRedisSerializer());

        //当需要对stirng 类型进行序列化的时候,使用如下的构造参数
        //this.redisTemplate.setValueSerializer(new StringRedisSerializer());

        //当需要对实体类进行序列化的时候,使用如下的构造参数
        this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<User>(User.class));
    }


    @Test
    public void stringTestCase() {
        redisTemplate.opsForValue().set("name", "jack");
    }

    @Test
    public void stringGetTestCase(){
        String name = (String) redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }

    @Test
    public void objectTestCase(){
        User user = new User(1, "tom", "shanghai");
        redisTemplate.opsForValue().set("user:1",user);
        User user1 = (User) redisTemplate.opsForValue().get("user:1");

        System.out.println(user1);
    }
}
