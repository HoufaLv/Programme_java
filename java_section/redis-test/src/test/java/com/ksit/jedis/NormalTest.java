package com.ksit.jedis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

public class NormalTest {

    Jedis jedis = null;

    @Before
    public void init(){
        //要使用jedis 来连接 远程服务器的redis,需要在redis的conf 文件中将 bind 改变
        jedis = new Jedis("192.168.153.130", 6379);
    }

    /**
     * 测试能否连接到远程的redis
     */
    @Test
    public void jedisPing(){
        System.out.println(jedis.ping());

    }

    @After
    public void release(){
        jedis.close();
    }


    @Test
    public void redisSetTestCase(){
        jedis.set("name:1","tom");
        System.out.println(jedis.get("name:1"));
    }

    @Test
    public void redisLpushTestCase(){
        jedis.lpush("city:1","beijing","shanghai","guangzhou","shenzhen");

        for (String s : jedis.lrange("city:1", 0L, -1L)) {
            System.out.println(s);
        }
    }

    @Test
    public void redisZaddTestCase(){
        jedis.zadd("student:1",50,"tom");
        Double zscore = jedis.zscore("student:1", "tom");
        System.out.println(zscore);
    }
}

