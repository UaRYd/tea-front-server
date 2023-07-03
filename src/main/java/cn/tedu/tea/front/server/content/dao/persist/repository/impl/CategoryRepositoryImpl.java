package cn.tedu.tea.front.server.content.dao.persist.repository.impl;

import cn.tedu.tea.front.server.content.dao.persist.mapper.CategoryMapper;
import cn.tedu.tea.front.server.content.dao.persist.repository.ICategoryRepository;
import cn.tedu.tea.front.server.content.pojo.vo.CategoryListItemVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 处理类别数据的存储库实现类
 *
 * @author java@tedu.cn
 * @version 1.0
 */
@Slf4j
@Repository
public class CategoryRepositoryImpl implements ICategoryRepository {

    @Autowired
    private CategoryMapper categoryMapper;

    public CategoryRepositoryImpl() {
        log.info("创建存储库对象：CategoryRepositoryImpl");
    }

    @Override
    public List<CategoryListItemVO> list() {
        log.debug("开始执行【查询类别列表】的数据访问，参数：无");
        return categoryMapper.list();
    }

    @Override
    public void rebuildListCache() {

    }
}
