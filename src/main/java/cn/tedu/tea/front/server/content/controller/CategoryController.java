package cn.tedu.tea.front.server.content.controller;

import cn.tedu.tea.front.server.common.web.JsonResult;
import cn.tedu.tea.front.server.content.pojo.vo.CategoryListItemVO;
import cn.tedu.tea.front.server.content.service.ICategoryService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 处理类别相关请求的控制器类
 *
 * @author java@tedu.cn
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/content/categories")
@Validated
@Api(tags = "1.1. 内容管理-类别管理")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    public CategoryController() {
        log.debug("创建控制器类对象：CategoryController");
    }

    @GetMapping("")
    @ApiOperation("查询类别数据列表")
    @ApiOperationSupport(order = 420)
    public JsonResult list() {
        log.debug("开始处理【查询类别数据列表】的请求，参数：无");
        List<CategoryListItemVO> categoryListItemVOList = categoryService.list();
        return JsonResult.ok(categoryListItemVOList);
    }

}
