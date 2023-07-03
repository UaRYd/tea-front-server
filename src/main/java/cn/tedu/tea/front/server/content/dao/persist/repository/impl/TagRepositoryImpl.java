package cn.tedu.tea.front.server.content.dao.persist.repository.impl;

import cn.tedu.tea.front.server.common.pojo.vo.PageData;
import cn.tedu.tea.front.server.common.util.PageInfoToPageDataConverter;
import cn.tedu.tea.front.server.content.dao.persist.mapper.TagMapper;
import cn.tedu.tea.front.server.content.dao.persist.repository.ITagRepository;
import cn.tedu.tea.front.server.content.pojo.vo.TagListItemVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 处理标签数据的存储库实现类
 *
 * @author java@tedu.cn
 * @version 1.0
 */
@Slf4j
@Repository
public class TagRepositoryImpl implements ITagRepository {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public PageData<TagListItemVO> list(Integer pageNum, Integer pageSize) {
        log.debug("开始执行【查询标签列表】，页码：{}，每页记录数：{}", pageNum, pageSize);
        PageHelper.startPage(pageNum, pageSize);
        List<TagListItemVO> list = tagMapper.list();
        PageInfo<TagListItemVO> pageInfo = new PageInfo<>(list);
        PageData<TagListItemVO> pageData = PageInfoToPageDataConverter.convert(pageInfo);
        return pageData;
    }

}