package net.liangyihui.manager.kypt.bos.controller;


import net.liangyihui.digitalmarketing.response.CommonResponse;
import net.liangyihui.manager.kypt.bos.entity.SmsTemplate;
import net.liangyihui.manager.kypt.bos.service.ISmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sms")
public class SmsController {

    @Autowired
    private ISmsService smsService;

    @RequestMapping(value = "template/list")
    public CommonResponse<List<SmsTemplate>> templateList(){
        List<SmsTemplate> smsTemplates = smsService.listTemplate();
        return CommonResponse.succ(smsTemplates);
    }

}
