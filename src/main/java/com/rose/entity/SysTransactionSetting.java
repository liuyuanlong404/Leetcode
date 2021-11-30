package com.rose.entity;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 系统机械师交易设置表
 * </p>
 *
 * @author Rose
 * @since 2021-08-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysTransactionSetting {

    @ApiModelProperty(value = "自增主键")
    private Integer id;

    @ApiModelProperty("健康码开关 1=开启 2=关闭")
    private Integer healthSwitch;

    @ApiModelProperty(value = "付款等待时间(min)")
    private Integer payWaitTime;

    @ApiModelProperty(value = "接单等待时间(min)")
    private Integer receiveWaitTime;

    @ApiModelProperty(value = "接单距离(KM)")
    private Integer receiveDistance;

    @ApiModelProperty(value = "故障维修上门费")
    private BigDecimal faultServiceCost;

    @ApiModelProperty(value = "机械师订单保险费(元)")
    private BigDecimal machinistOrderInsurance;

    @ApiModelProperty(value = "20吨以下保养费(元)")
    private BigDecimal maintainGradeOne;

    @ApiModelProperty(value = "20-40吨保养费(元)")
    private BigDecimal maintainGradeTwo;

    @ApiModelProperty(value = "40吨以上保养费(元)")
    private BigDecimal maintainGradeThree;

    @ApiModelProperty(value = "平台抽成比例(%)")
    private BigDecimal platformScale;

    @ApiModelProperty(value = "省级合伙人抽成(%)")
    private BigDecimal provincePartnerScale;

    @ApiModelProperty(value = "城市合伙人抽成(%)")
    private BigDecimal cityPartnerScale;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updatedTime;

    @ApiModelProperty(value = "修改人名称")
    private String updatedBy;

}
