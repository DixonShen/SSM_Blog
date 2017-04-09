package cn.edu.suda.dixonshen.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Z003R98D on 4/6/2017.
 */

@Controller
@RequestMapping(value = "/")
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "login";
    }

    /**
     * 登录页面
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    /**
     * 注册页面
     * @return
     */
    @RequestMapping(value = "/register.do", method = RequestMethod.GET)
    public String register(){
        return "login";
    }
}
