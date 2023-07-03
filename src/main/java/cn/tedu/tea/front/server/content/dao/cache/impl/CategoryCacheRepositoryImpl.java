package cn.tedu.tea.front.server.content.dao.cache.impl;

import cn.tedu.tea.front.server.common.consts.CacheConsts;
import cn.tedu.tea.front.server.content.dao.cache.ICategoryCacheRepository;
import cn.tedu.tea.front.server.content.pojo.vo.CategoryListItemVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 处理类别数据的缓存的存储库实现类
 *
 * @author java@tedu.cn
 * @version 1.0
 */
@Slf4j
@Repository
public class CategoryCacheRepositoryImpl implements ICategoryCacheRepository, CacheConsts {

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @Override
    public void save(List<CategoryListItemVO> categoryListItemVOList) {
        log.debug("开始处理【向缓存中写入类别列表】的数据访问，参数：{}", categoryListItemVOList);
        ListOperations<String, Serializable> opsForList = redisTemplate.opsForList();
        for (CategoryListItemVO categoryListItemVO : categoryListItemVOList) {
            opsForList.rightPush(KEY_CATEGORY_LIST, categoryListItemVO);
        }
    }

    @Override
    public List<CategoryListItemVO> list() {
        log.debug("开始处理【从缓存中读取类别列表】的数据访问，无参数");
        ListOperations<String, Serializable> opsForList = redisTemplate.opsForList();
        List<Serializable> range = opsForList.range(KEY_CATEGORY_LIST, 0, -1);
        List<CategoryListItemVO> categoryListItemVOList = new ArrayList<>();
        for (Serializable serializable : range) {
            categoryListItemVOList.add((CategoryListItemVO) serializable);
        }
        return categoryListItemVOList;
    }

    @Override
    public boolean deleteList() {
        log.debug("开始处理【删除缓存中的类别类型】的数据访问，无参数");
        return redisTemplate.delete(KEY_CATEGORY_LIST);
    }
}
