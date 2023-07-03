package cn.tedu.tea.front.server.content.service;

import cn.tedu.tea.front.server.content.pojo.vo.CategoryListItemVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 处理类别业务的接口
 *
 * @author java@tedu.cn
 * @version 1.0
 */
@Transactional
public interface ICategoryService {

    /**
     * 查询类别数据列表
     *
     * @return 类别数据列表
     */
    List<CategoryListItemVO> list();

    void rebuildListCache();

}
