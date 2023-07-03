package cn.tedu.tea.front.server.content.service.impl;

import cn.tedu.tea.front.server.common.pojo.vo.PageData;
import cn.tedu.tea.front.server.content.dao.persist.repository.IArticleRepository;
import cn.tedu.tea.front.server.content.pojo.vo.ArticleListItemVO;
import cn.tedu.tea.front.server.content.service.IArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 处理文章数据的业务实现类
 *
 * @author java@tedu.cn
 * @version 1.0
 */
@Slf4j
@Service
public class ArticleServiceImpl implements IArticleService {

    @Value("${tea-store.dao.default-query-page-size}")
    private Integer defaultQueryPageSize;
    @Autowired
    private IArticleRepository articleRepository;

    public ArticleServiceImpl() {
        log.debug("创建业务类对象：ArticleServiceImpl");
    }

    @Override
    public PageData<ArticleListItemVO> listByCategoryId(Long categoryId, Integer pageNum) {
        log.debug("开始处理【根据文章类别查询文章列表】的业务，文章类别：{}, 页码：{}", categoryId, pageNum);
        PageData<ArticleListItemVO> pageData = articleRepository.listByCategoryId(categoryId, pageNum, defaultQueryPageSize);
        return pageData;
    }

    @Override
    public PageData<ArticleListItemVO> listByCategoryId(Long categoryId, Integer pageNum, Integer pageSize) {
        log.debug("开始处理【根据文章类别查询文章列表】的业务，文章类别：{}, 页码：{}，每页记录数：{}", categoryId, pageNum, pageSize);
        PageData<ArticleListItemVO> pageData = articleRepository.listByCategoryId(categoryId, pageNum, pageSize);
        return pageData;
    }

}