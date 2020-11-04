package com.coldchain.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 传感器新增参数
 *
 * @author chenqingshan
 * @since 2020-10-17 11:39:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CpSenSorDto {

     private String unit;//单位，传感器类型为1（值类型时必填，其它可选）
     private String sensorName; //传感器名称，必填参数
     private Integer sensorType; //传感器类型，取值范围 1-8，1数值型，2开关型可操作，5开关型不可操作，3定位型，4图片型，6档位型，7视频，8字符串 必填参数
     private Integer ordernum; //显示顺序 可选
     private Integer decimal; //小数位传感器类型为1（值类型时必填，其它可选）
}
