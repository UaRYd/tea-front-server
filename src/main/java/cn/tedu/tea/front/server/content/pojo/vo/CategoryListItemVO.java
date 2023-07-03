package cn.tedu.tea.front.server.content.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 列表项VO类：内容-类别
 *
 * @author java@tedu.cn
 * @version 1.0
 */
@Data
public class CategoryListItemVO implements Serializable {

    /**
     * 数据ID
     */
    private Long id;
    /**
     * 类别名称
     */
    private String name;

}
