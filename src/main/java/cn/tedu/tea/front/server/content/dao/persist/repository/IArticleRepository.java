package cn.tedu.tea.front.server.content.dao.persist.repository;

import cn.tedu.tea.front.server.common.pojo.vo.PageData;
import cn.tedu.tea.front.server.content.pojo.vo.ArticleListItemVO;

/**
 * 处理文章数据的存储库接口
 *
 * @author java@tedu.cn
 * @version 1.0
 */
public interface IArticleRepository {

    /**
     * 根据文章类别查询其文章列表
     *
     * @param categoryId 文章类别的ID
     * @param pageNum    页码
     * @param pageSize   每页记录数
     * @return 文章列表
     */
    PageData<ArticleListItemVO> listByCategoryId(Long categoryId, Integer pageNum, Integer pageSize);

}
