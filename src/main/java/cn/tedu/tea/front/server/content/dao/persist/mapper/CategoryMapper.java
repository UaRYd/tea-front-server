package cn.tedu.tea.front.server.content.dao.persist.mapper;

import cn.tedu.tea.front.server.content.pojo.entity.Category;
import cn.tedu.tea.front.server.content.pojo.vo.CategoryListItemVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 处理类别数据的Mapper接口
 *
 * @author java@tedu.cn
 * @version 1.0
 */
@Repository
public interface CategoryMapper extends BaseMapper<Category> {

    /**
     * 查询类别数据列表
     *
     * @return 类别数据列表
     */
    List<CategoryListItemVO> list();

}
