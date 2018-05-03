package com.ksit.jedis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class PoolTest {

    GenericObjectPoolConfig config = null;
    JedisPool jedisPool = null;
    Jedis jedis = null;

    @Before
    public void init(){
        config = new GenericObjectPoolConfig();
        config.setMaxTotal(10);
        config.setMinIdle(5);

        jedisPool = new JedisPool(config,"192.168.153.130",6379);

        jedis = jedisPool.getResource();
    }

    @Test
    public void jedisPoolTestCase(){
        jedis.set("name","jack");
        System.out.println(jedis.get("name"));

    }

    @After
    public void realease(){
        jedisPool.destroy();
    }

}
