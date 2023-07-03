package cn.tedu.tea.front.server.content.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 实体类：内容-标签
 *
 * @author java@tedu.cn
 * @version 1.0
 */
@Data
@TableName("content_tag")
public class Tag implements Serializable {

    /**
     * 数据ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 标签名称
     */
    private String name;
    /**
     * 父级ID，为0的是标签分类，不为0的是标签
     */
    private Long parentId;
    /**
     * 是否启用，1=启用，0=未启用
     */
    private Integer enable;
    /**
     * 排序序号
     */
    private Integer sort;
    /**
     * 数据创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;
    /**
     * 数据最后修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;

}
