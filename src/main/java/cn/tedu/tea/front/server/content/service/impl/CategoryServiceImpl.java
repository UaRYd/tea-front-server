package cn.tedu.tea.front.server.content.service.impl;

import cn.tedu.tea.front.server.content.dao.cache.ICategoryCacheRepository;
import cn.tedu.tea.front.server.content.dao.persist.repository.ICategoryRepository;
import cn.tedu.tea.front.server.content.pojo.vo.CategoryListItemVO;
import cn.tedu.tea.front.server.content.service.ICategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 处理类别的业务实现类
 *
 * @author java@tedu.cn
 * @version 1.0
 */
@Slf4j
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Autowired
    private ICategoryCacheRepository categoryCacheRepository;

    public CategoryServiceImpl() {
        log.debug("创建业务类对象：CategoryServiceImpl");
    }

    @Override
    public List<CategoryListItemVO> list() {
        log.debug("开始处理【查询类别数据列表】的业务，参数：无");
        List<CategoryListItemVO> categoryListItemVOList = categoryRepository.list();
        return categoryListItemVOList;
    }

    @Override
    public void rebuildListCache() {
        log.debug("开始处理【重建缓存中的类别列表】的业务，参数：无");
        categoryCacheRepository.deleteList();
        List<CategoryListItemVO> list = categoryRepository.list();
        categoryCacheRepository.save(list);
    }
}