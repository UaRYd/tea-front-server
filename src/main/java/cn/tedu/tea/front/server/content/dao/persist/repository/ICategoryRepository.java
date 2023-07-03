package cn.tedu.tea.front.server.content.dao.persist.repository;

import cn.tedu.tea.front.server.content.pojo.vo.CategoryListItemVO;

import java.util.List;

/**
 * 处理类别数据的存储库接口
 *
 * @author java@tedu.cn
 * @version 1.0
 */
public interface ICategoryRepository {

    /**
     * 查询类别数据列表
     *
     * @return 类别数据列表
     */
    List<CategoryListItemVO> list();

    void rebuildListCache();
}
