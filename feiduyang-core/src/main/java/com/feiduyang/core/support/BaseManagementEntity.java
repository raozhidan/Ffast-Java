package com.feiduyang.core.support;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * @description: 实体基类
 * @copyright:
 * @createTime: 2017年9月12日下午5:27:50
 * @author：dzy
 * @version：1.0
 */
public class BaseManagementEntity<T extends Model> extends Model<T> implements Serializable, CommonBaseEntity {

    @TableField(exist = false)
    private static final long serialVersionUID = -34115333603863619L;
    /**
     * 主键Id
     */
    @TableId(value = "id", type = IdType.AUTO)
    protected Long id;
    /**
     * 创建人
     */
    @TableField("create_by")
    private Long createBy;
    /**
     * 最后修改人
     */
    @TableField("update_by")
    private Long updateBy;

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
