package com.xuwenxing.bbtv.controller;

import com.xuwenxing.bbtv.domain.system.User;
import com.xuwenxing.bbtv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * Created by xuwx on 2018/7/31.
 */
@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    /**
     * 访问webapp 下jsp的index页面
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(Map<String,Object>map){
        map.put("name","xuwx1999");
        return "index";
    }

    @RequestMapping("/hello")
    public String hello(Map<String,Object>map){
        map.put("name","xuwx");
        return "hello";
    }

    @RequestMapping("/user")
    public String user(Map<String,Object>map){
      //  map.put("name","xuwx");
        return "showUser";
    }
    @RequestMapping("/oneUser")
    public String oneUser(Map<String,Object>map){
        User user = userService.get(2L);
        map.put("user",user);
        return "showOneUser";
    }

    @RequestMapping("/allUser")
    public String allUser(Map<String,Object>map){
        List<User> list = userService.findList();
        map.put("users",list);
        return "showAllUser";
    }

    @RequestMapping("/welcome")
    public String welcome(Model model){
        User user = userService.get(2L);
        model.addAttribute("name",user.getUsername());
        model.addAttribute("userType",user.getUserType());
        return "welcome";
    }
}
