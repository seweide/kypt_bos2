package net.liangyihui.manager.kypt.bos.controller;

import net.liangyihui.digitalmarketing.response.CommonResponse;
import net.liangyihui.manager.kypt.bos.api.request.CaptchaRequest;
import net.liangyihui.manager.kypt.bos.api.request.ChangePasswordRequest;
import net.liangyihui.manager.kypt.bos.api.request.ForgetPasswordRequest;
import net.liangyihui.manager.kypt.bos.api.request.LoginRequest;
import net.liangyihui.manager.kypt.bos.api.response.AdminUserInfo;
import net.liangyihui.manager.kypt.bos.bo.UserInfo;
import net.liangyihui.manager.kypt.bos.config.UserHolder;
import net.liangyihui.manager.kypt.bos.service.IUserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liu_y
 */
@RestController
@RequestMapping("login")
public class UserLoginController {

    private final IUserService userService;

    public UserLoginController(IUserService userService) {
        this.userService = userService;
    }
//
//    @RequestMapping(value = "", method = RequestMethod.POST)
//    @ResponseBody
//    public CommonResponse<String> login(@Validated @RequestBody LoginRequest request) {
//        return CommonResponse.succ(userService.login(request));
//    }
//
//    @RequestMapping(value = "user-info", method = RequestMethod.GET)
//    @ResponseBody
//    public CommonResponse<AdminUserInfo> userInfo() {
//        UserInfo userInfo = UserHolder.getUserInfo();
//        return CommonResponse.succ(userService.userInfo(userInfo));
//    }
//
//    @RequestMapping(value = "change-password",method = RequestMethod.POST)
//    @ResponseBody
//    public CommonResponse<String> changePassword(@RequestBody ChangePasswordRequest request){
//        UserInfo userInfo=UserHolder.getUserInfo();
//        return CommonResponse.succ(userService.changePassword(request,userInfo));
//    }
//
//    @RequestMapping(value = "send-captcha",method = RequestMethod.POST)
//    @ResponseBody
//    public CommonResponse<Boolean> sendCaptcha(@RequestBody CaptchaRequest request){
//        return CommonResponse.succ(userService.sendCaptcha(request.getMobile()));
//    }
//
//    @RequestMapping(value = "forget-password",method = RequestMethod.POST)
//    @ResponseBody
//    public CommonResponse<Boolean> forgetPassword(@RequestBody ForgetPasswordRequest request){
//        return CommonResponse.succ(userService.forgetPassword(request));
//    }

}
