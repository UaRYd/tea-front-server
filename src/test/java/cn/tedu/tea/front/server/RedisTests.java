package cn.tedu.tea.front.server;

import cn.tedu.tea.front.server.content.pojo.entity.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class RedisTests {

    // Redis是一款基于内存的、使用K-V结构存储数据的NoSQL非关系型数据库

    @Autowired
    RedisTemplate<String, Serializable> redisTemplate;

    @Test
    void setValue() {
        ValueOperations<String, Serializable> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("tag1", 123);
    }

    @Test
    void getValue() {
        ValueOperations<String, Serializable> valueOperations = redisTemplate.opsForValue();
        Serializable tag1Value = valueOperations.get("tag1");
        System.out.println(tag1Value);
    }

    @Test
    void setObjectValue() {
        Tag tag = new Tag();
        tag.setName("高政");
        tag.setId(123L);

        ValueOperations<String, Serializable> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("tag2", tag);
    }

    @Test
    void getObjectValue() {
        ValueOperations<String, Serializable> valueOperations = redisTemplate.opsForValue();
        Serializable serializable = valueOperations.get("tag1");
        System.out.println(serializable.getClass().getName());
        System.out.println(serializable);

        Tag tag = (Tag) serializable;
        System.out.println(tag);
    }

    @Test
    void delete() {
        String key = "tag1";
        Boolean deleteResult = redisTemplate.delete(key);
        System.out.println(deleteResult);
    }

    @Test
    void deleteBatch() {
        Set<String> keys = new HashSet<>();
        keys.add("username1");
        keys.add("username2");
        keys.add("username3");
        keys.add("username4");
        keys.add("username5");

        Long deleteCount = redisTemplate.delete(keys);
        System.out.println("deleteCount = " + deleteCount);
    }

    @Test
    void keys() {
        String pattern = "*";
        Set<String> keys = redisTemplate.keys(pattern);
        for (String key : keys) {
            System.out.println(key);
        }
    }

    @Test
    void xxx() {
        ListOperations<String, Serializable> listOperations = redisTemplate.opsForList();
        String key = "name-list";
        List<Serializable> value = new ArrayList<>();

        value.add("name1");
        value.add("name2");
        value.add("name3");
        value.add("name4");
        value.add("name5");
        value.add("name6");
        value.add("name7");
        value.add("name8");

        listOperations.rightPushAll(key, value);
    }
}
