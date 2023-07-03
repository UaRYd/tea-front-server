package cn.tedu.tea.front.server.content.dao.persist.mapper;

import cn.tedu.tea.front.server.content.pojo.entity.Article;
import cn.tedu.tea.front.server.content.pojo.vo.ArticleListItemVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 处理文章数据的Mapper接口
 *
 * @author java@tedu.cn
 * @version 1.0
 */
@Repository
public interface ArticleMapper extends BaseMapper<Article> {

    /**
     * 根据文章类别（categoryId）查询其文章列表
     *
     * @param categoryId 文章类别的ID（categoryId）
     * @return 文章列表
     */
    List<ArticleListItemVO> listByCategoryId(Long categoryId);

}