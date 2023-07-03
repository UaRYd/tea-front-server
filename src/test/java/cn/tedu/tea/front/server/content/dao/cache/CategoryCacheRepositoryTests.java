package cn.tedu.tea.front.server.content.dao.cache;

import cn.tedu.tea.front.server.content.dao.persist.repository.ICategoryRepository;
import cn.tedu.tea.front.server.content.pojo.vo.CategoryListItemVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CategoryCacheRepositoryTests {

    @Autowired
    ICategoryRepository dbRepository;
    @Autowired
    ICategoryCacheRepository cacheRepository;

    @Test
    void save() {
        List<CategoryListItemVO> list = dbRepository.list();
        cacheRepository.save(list);
    }

    @Test
    void deleteList() {
        boolean deleteResult = cacheRepository.deleteList();
        System.out.println("删除缓存中的数据，结果：" + deleteResult);
    }

    @Test
    void list() {
        List<?> list = cacheRepository.list();
        System.out.println("从缓存中读取列表，列表项的数量：" + list.size());
        for (Object item : list) {
            System.out.println(item);
        }
    }

}
