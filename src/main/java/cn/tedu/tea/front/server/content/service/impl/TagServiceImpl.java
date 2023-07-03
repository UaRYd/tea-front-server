package cn.tedu.tea.front.server.content.service.impl;

import cn.tedu.tea.front.server.common.pojo.vo.PageData;
import cn.tedu.tea.front.server.content.dao.persist.repository.ITagRepository;
import cn.tedu.tea.front.server.content.pojo.vo.TagListItemVO;
import cn.tedu.tea.front.server.content.service.ITagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 处理标签数据的业务实现类
 *
 * @author java@tedu.cn
 * @version 1.0
 */
@Slf4j
@Service
public class TagServiceImpl implements ITagService {

    @Value("${tea-store.dao.default-query-page-size}")
    private Integer defaultQueryPageSize;
    @Autowired
    private ITagRepository tagRepository;

    public TagServiceImpl() {
        log.info("创建业务对象：TagServiceImpl");
    }

    @Override
    public PageData<TagListItemVO> list(Integer pageNum) {
        log.debug("开始处理【查询标签列表】的业务，页码：{}", pageNum);
        PageData<TagListItemVO> pageData = tagRepository.list(pageNum, defaultQueryPageSize);
        return pageData;
    }

    @Override
    public PageData<TagListItemVO> list(Integer pageNum, Integer pageSize) {
        log.debug("开始处理【查询标签列表】的业务，页码：{}，每页记录数：{}", pageNum, pageSize);
        PageData<TagListItemVO> pageData = tagRepository.list(pageNum, pageSize);
        return pageData;
    }

}