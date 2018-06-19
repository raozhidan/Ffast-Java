package com.feiduyang.web.entity.management;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.feiduyang.core.support.BaseManagementEntity;

import java.math.BigDecimal;

/**
 * @description: 渠道信息
 * @copyright: ${copyright} (c)2018
 * @createTime: 2018-06-19 18:00:01
 * @author: zhidan.rao
 * @version: 1.0
 */
@TableName(value = "t_channel_info", resultMap = "BaseResultMap")
public class ChannelInfo extends BaseManagementEntity<ChannelInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 渠道名称
     */
    @TableField("channel_name")
    private String channelName;
    /**
     * 渠道编号
     */
    @TableField("channel_no")
    private String channelNo;
    /**
     * 渠道费率（百分单位）
     */
    @TableField("channe_rate")
    private BigDecimal channeRate;

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public BigDecimal getChanneRate() {
        return channeRate;
    }

    public void setChanneRate(BigDecimal channeRate) {
        this.channeRate = channeRate;
    }


}
