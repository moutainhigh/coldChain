package com.coldchain.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coldchain.dao.NtsNoticeMapper;
import com.coldchain.entity.NtsNotice;
import com.coldchain.service.NtsNoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NtsNoticeServiceImpl extends ServiceImpl<NtsNoticeMapper,NtsNotice> implements NtsNoticeService {
}
