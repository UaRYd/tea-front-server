package cn.tedu.tea.front.server.content.service;

import cn.tedu.tea.front.server.common.pojo.vo.PageData;
import cn.tedu.tea.front.server.content.pojo.vo.ArticleListItemVO;
import org.springframework.transaction.annotation.Transactional;

/**
 * 处理文章数据的业务接口
 *
 * @author java@tedu.cn
 * @version 1.0
 */
@Transactional
public interface IArticleService {

    /**
     * 根据文章类别查询文章列表，将使用默认的每页记录数
     *
     * @param categoryId 文章类别的ID
     * @param pageNum    页码
     * @return 文章列表
     */
    PageData<ArticleListItemVO> listByCategoryId(Long categoryId, Integer pageNum);

    /**
     * 根据文章类别查询文章列表
     *
     * @param categoryId 文章类别的ID
     * @param pageNum    页码
     * @param pageSize   每页记录数
     * @return 文章列表
     */
    PageData<ArticleListItemVO> listByCategoryId(Long categoryId, Integer pageNum, Integer pageSize);

}
