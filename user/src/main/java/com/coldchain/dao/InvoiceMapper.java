package com.coldchain.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.coldchain.entity.Invoice;
import com.coldchain.vo.InvoiceExcel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 发票信息表 Mapper 接口
 * </p>
 *
 * @author dyr
 * @since 2019-11-22
 */
public interface InvoiceMapper extends BaseMapper<Invoice> {

    //查询发票导出数据
    List<InvoiceExcel> selectInvoiceExportData(@Param(Constants.WRAPPER) QueryWrapper<Invoice> wrapper);
}
