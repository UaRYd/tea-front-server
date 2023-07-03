package cn.tedu.tea.front.server.content.dao.persist.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@SpringBootTest
@Sql(scripts = {"classpath:/sql/truncate_table.sql", "classpath:/sql/insert_data.sql"})
@Sql(scripts = {"classpath:/sql/truncate_table.sql", "classpath:/sql/insert_data.sql"},
        executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class ArticleRepositoryTests {

    @Autowired
    IArticleRepository repository;

    @Test
    void listByCategoryId() {
        Long categoryId = 1L;
        Integer pageNum = 1;
        Integer pageSize = 5;
        List<?> list = repository.listByCategoryId(categoryId, pageNum, pageSize).getList();
        System.out.println("根据列表数据完成，列表长度：" + list.size());
        for (Object item : list) {
            System.out.println("列表项：" + item);
        }
    }

}