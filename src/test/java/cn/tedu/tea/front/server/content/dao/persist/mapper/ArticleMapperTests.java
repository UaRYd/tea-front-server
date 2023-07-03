package cn.tedu.tea.front.server.content.dao.persist.mapper;

import cn.tedu.tea.front.server.content.pojo.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@SpringBootTest
@Sql(scripts = {"classpath:/sql/truncate_table.sql", "classpath:/sql/insert_data.sql"})
@Sql(scripts = {"classpath:/sql/truncate_table.sql", "classpath:/sql/insert_data.sql"},
        executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class ArticleMapperTests {

    @Autowired
    ArticleMapper mapper;

    @Test
    void listByCategoryId() {
        Long categoryId = 1L;
        List<?> list = mapper.listByCategoryId(categoryId);
        System.out.println("根据列表数据完成，列表长度：" + list.size());
        for (Object item : list) {
            System.out.println("列表项：" + item);
        }
    }

}