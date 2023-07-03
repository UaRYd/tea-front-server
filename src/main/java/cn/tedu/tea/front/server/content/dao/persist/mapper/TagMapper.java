package cn.tedu.tea.front.server.content.dao.persist.mapper;

import cn.tedu.tea.front.server.content.pojo.entity.Tag;
import cn.tedu.tea.front.server.content.pojo.vo.TagListItemVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 处理标签数据的Mapper接口
 *
 * @author java@tedu.cn
 * @version 1.0
 */
@Repository
public interface TagMapper extends BaseMapper<Tag> {

    /**
     * 查询标签列表
     *
     * @return 标签列表
     */
    List<TagListItemVO> list();

}