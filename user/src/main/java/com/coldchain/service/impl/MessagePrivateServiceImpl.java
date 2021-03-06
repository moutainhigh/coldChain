package com.coldchain.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coldchain.dao.MessagePrivateMapper;
import com.coldchain.entity.MessagePrivate;
import com.coldchain.entity.UserMessage;
import com.coldchain.service.MessagePrivateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author dyr
 * @since 2019-08-27
 */
@Service
public class MessagePrivateServiceImpl extends ServiceImpl<MessagePrivateMapper, MessagePrivate> implements MessagePrivateService {

    @Autowired
    private MessagePrivateMapper messagePrivateMapper;

    @Override
    public IPage<MessagePrivate> userMessagePage(Page<MessagePrivate> page, Integer userId) {
        UserMessage userMessage = new UserMessage();
        userMessage.setUserId(userId);
        userMessage.setDeleted(0);
        return messagePrivateMapper.selectUserMessagePage(page, userMessage);
    }
}
