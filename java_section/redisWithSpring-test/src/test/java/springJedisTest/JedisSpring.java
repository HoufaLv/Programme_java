package springJedisTest;

import com.google.gson.Gson;
import com.ksit.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-redis.xml")
public class JedisSpring {

    // TODO: 2018/5/3 0003 搞一个连接池出来用用,这个连接池已经在配置文件中配好了,直接注入就可以了
    // TODO: 2018/5/3 0003 尝试将对象存储到redis中去
    @Autowired
    JedisPool jedisPool;

    Jedis jedis = null;

    @Before
    public void init(){
        jedis = jedisPool.getResource();
    }

    @After
    public void release(){
        jedis.close();
    }

    @Test
    public void stringValueTest(){
        jedis.set("name","tom");
        String name = jedis.get("name");

        System.out.println("name = " + name);
    }

    @Test
    public void objectTest(){
        User user = new User();
        user.setId(1);
        user.setAddress("北京");
        user.setName("jack");

        String gson = new Gson().toJson(user);
        jedis.set("user:1",gson);

        String gson1 = jedis.get("user:1");
        User user1 = new Gson().fromJson(gson1,User.class);
        System.out.println(user1);

    }
}
