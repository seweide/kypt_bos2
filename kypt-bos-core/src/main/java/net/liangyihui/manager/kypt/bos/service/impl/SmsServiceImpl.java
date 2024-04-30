package net.liangyihui.manager.kypt.bos.service.impl;

import net.liangyihui.manager.kypt.bos.entity.SmsTemplate;
import net.liangyihui.manager.kypt.bos.mapper.SmsTemplateMapper;
import net.liangyihui.manager.kypt.bos.service.ISmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmsServiceImpl implements ISmsService {
    @Override
    public List<SmsTemplate> listTemplate() {
        return smsTemplateMapper.selectList(null);
    }

    @Autowired
    private SmsTemplateMapper smsTemplateMapper;
}
