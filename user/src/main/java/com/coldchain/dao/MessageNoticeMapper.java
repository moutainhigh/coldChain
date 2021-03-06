package com.coldchain.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.coldchain.entity.MessageNotice;
import com.coldchain.entity.UserMessage;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dyr
 * @since 2019-08-26
 */
public interface MessageNoticeMapper extends BaseMapper<MessageNotice> {

    IPage<MessageNotice> selectUserMessagePage(Page<MessageNotice> page, UserMessage userMessage);
}
