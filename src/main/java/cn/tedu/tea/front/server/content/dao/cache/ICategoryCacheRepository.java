package cn.tedu.tea.front.server.content.dao.cache;

import cn.tedu.tea.front.server.content.pojo.vo.CategoryListItemVO;

import java.util.List;

/**
 * 处理类别数据的缓存的存储库接口
 *
 * @author java@tedu.cn
 * @version 1.0
 */
public interface ICategoryCacheRepository {

    /**
     * 向缓存中写入类别列表
     *
     * @param categoryListItemVOList 类别列表
     */
    void save(List<CategoryListItemVO> categoryListItemVOList);

    /**
     * 从缓存中读取类别列表
     *
     * @return 类别列表
     */
    List<CategoryListItemVO> list();

    boolean deleteList();

}