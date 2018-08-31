package com.xuwenxing.bbtv.controller;

import com.xuwenxing.bbtv.domain.system.User;
import com.xuwenxing.bbtv.service.UserService;
import com.xuwenxing.bbtv.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xuwx on 2018/8/6.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String Login(){
        return "login";
    }

    @RequestMapping("checkUsername")
    @ResponseBody
    public boolean checkUsername(String username) {
        boolean result = userService.checkUsername(username);
        return result;
    }

    @RequestMapping("userLogin")
    @ResponseBody
    public AjaxResult userLogin(String username, String password) {
        AjaxResult ajaxResult = new AjaxResult();
       User user = userService.userLogin(username, password);
        if(user==null){
            ajaxResult.setMessage("登录失败");
            ajaxResult.setSuccess(false);
        }else {
            ajaxResult.setMessage("登录成功");
        }
        return ajaxResult;
    }
}
