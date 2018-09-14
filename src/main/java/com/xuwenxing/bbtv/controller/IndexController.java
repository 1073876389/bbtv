package com.xuwenxing.bbtv.controller;

import com.xuwenxing.bbtv.domain.system.User;
import com.xuwenxing.bbtv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    /**
     * @PreAuthorize这个注解，value="hasRole('ADMIN')")是Spring-EL expression，
     * 当表达式值为true，标识这个方法可以被调用。如果表达式值是false，标识此方法无权限访问
     * @param model
     * @return
     */
    @RequestMapping("/welcome")
    @PreAuthorize("hasRole('ADMIN')") // Spring Security默认的角色前缀是”ROLE_”,使用hasRole方法时已经默认加上了
    public String welcome(Model model){
        User user = userService.get(2L);
        model.addAttribute("name",user.getUsername());
        model.addAttribute("userType",user.getUserType());
        return "welcome";
    }



    @RequestMapping("/demo")
    public String showEchartsDemo(Map<String,Object>map){
        return "echartDemo";
    }

    @RequestMapping("/json")
    public String showJsonData(Map<String,Object>map){
        return "static/json/life-expectancy.json";
    }


}
