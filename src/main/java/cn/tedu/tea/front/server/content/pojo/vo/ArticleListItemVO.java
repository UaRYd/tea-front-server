package cn.tedu.tea.front.server.content.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 列表项VO类：内容-文章
 *
 * @author java@tedu.cn
 * @version 1.0
 */
@Data
public class ArticleListItemVO implements Serializable {

    /**
     * 数据ID
     */
    private Long id;
    /**
     * 作者名字
     */
    private String authorName;
    /**
     * 类别ID
     */
    private Long categoryId;
    /**
     * 类别名称
     */
    private String categoryName;
    /**
     * 标题
     */
    private String title;
    /**
     * 摘要
     */
    private String brief;
    /**
     * 标签列表，实际存入JSON数据
     */
    private String tags;
    /**
     * 封面图
     */
    private String coverUrl;
    /**
     * 顶数量
     */
    private Integer upCount;
    /**
     * 踩数量
     */
    private Integer downCount;
    /**
     * 浏览量
     */
    private Integer clickCount;
    /**
     * 评论量
     */
    private Integer commentCount;

}
