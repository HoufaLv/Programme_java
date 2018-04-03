package com.ksit.dao;

import com.ksit.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 使用Transactional 来使用注解来开启事务
 */
@Repository
public class MessageDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public int insert(Message message) {
        String sql = "insert into message (message) values(?) ";
        return jdbcTemplate.update(sql, message.getMessage());
    }

    public Message selectById(Integer id) {
        String sql = "select * from  message where id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Message.class), id);
    }

    public Long selectCount() {
        String sql = "select count(*) from message";
        return jdbcTemplate.queryForObject(sql, new SingleColumnRowMapper<>(Long.class));
    }

    public List<Message> selectAll() {
        String sql = "select * from message";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Message.class));
    }

    public List<Map<String, Object>> selectAllToMap() {
        String sql = "select * from message";
        return jdbcTemplate.query(sql, new ColumnMapRowMapper());
    }

    public void update(Message message) {
        String sql = "update message set message = :message where id = :id";

        Map<String, Object> params = new HashMap<>();
        params.put("id", message.getId());
        params.put("message", message.getMessage());

        namedParameterJdbcTemplate.update(sql, params);
    }

    /**
     * 批量添加
     *
     * @param messageList 要添加的messageList
     */
    public void batchSave(List<Message> messageList) {
        String sql = "insert into message (message) values (?)";

        // 穿过来的的 messageList 里面是一个一个的Message 对象,对象里面封装了需要的数据,但是有的数据需要,有的数据不需要,将需要的数据拿出来,封装到一个List 中去
        // 最终分装好的List中保存的就是insert 语句所有需要的数据(?,?) 这种,这就是循环的作用
        List<Object[]> params = new ArrayList<>();
        for (Message m :
                messageList) {
            //将messageList 中的数据添加到一个Object 数组中
            Object[] objects = new Object[1];
            objects[0] = m.getMessage();

            params.add(objects);
        }

        jdbcTemplate.batchUpdate(sql, params);

    }
}
