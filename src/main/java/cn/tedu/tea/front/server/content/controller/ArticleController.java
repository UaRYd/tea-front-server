package cn.tedu.tea.front.server.content.controller;

import cn.tedu.tea.front.server.common.pojo.vo.PageData;
import cn.tedu.tea.front.server.common.web.JsonResult;
import cn.tedu.tea.front.server.content.pojo.vo.ArticleListItemVO;
import cn.tedu.tea.front.server.content.service.IArticleService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 处理文章相关请求的控制器类
 *
 * @author java@tedu.cn
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/content/articles")
@Validated
@Api(tags = "1.3. 内容管理-文章管理")
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    public ArticleController() {
        log.debug("创建控制器类对象：ArticleController");
    }

    @GetMapping("/list-by-category")
    @ApiOperation("根据文章类别查询文章列表")
    @ApiOperationSupport(order = 421)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "categoryId", value = "文章类别ID", required = true, paramType = "query", dataType = "long"),
            @ApiImplicitParam(name = "page", value = "页码", defaultValue = "1", paramType = "query", dataType = "long")
    })
    public JsonResult listByCategoryId(@Range(message = "请提交有效的文章类别ID值！") Long categoryId,
                                       @Range(min = 1, message = "请提交有效的页码值！") Integer page) {
        log.debug("开始处理【根据文章类别查询文章列表】的请求，父级文章：{}，页码：{}", categoryId, page);
        Integer pageNum = page == null ? 1 : page;
        PageData<ArticleListItemVO> pageData = articleService.listByCategoryId(categoryId, pageNum);
        return JsonResult.ok(pageData);
    }

}
