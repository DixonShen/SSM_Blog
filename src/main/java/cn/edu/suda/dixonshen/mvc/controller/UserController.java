package cn.edu.suda.dixonshen.mvc.controller;

import cn.edu.suda.dixonshen.domain.ResponseObj;
import cn.edu.suda.dixonshen.domain.User;
import cn.edu.suda.dixonshen.serviceImpl.UserServiceImpl;
import cn.edu.suda.dixonshen.utils.GsonUtils;
import cn.edu.suda.dixonshen.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户请求相关控制器
 * Created by Z003R98D on 4/6/2017.
 */

@Controller
@RequestMapping(value = "/userAction")
public class UserController {

    @Autowired
    private UserServiceImpl userService;
    private ResponseObj responseObj;

    /**
     * 为什么返回值是一个ModelAndView，ModelAndView代表一个web页面<br/>
     * setViewName是设置一个jsp页面的名称
     * @param req
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public ModelAndView reg(HttpServletRequest req, User user) throws Exception{
        ModelAndView mav = new ModelAndView();      // 创建一个jsp对象
        mav.setViewName("home");    // 设置jsp文件名
        if (null == user) {
            mav.addObject("message", "用户信息不能为空！");  // 加入提示信息，再jsp中直接使用${对象名称}就能获取
            return mav;     // 返回页面
        }
        if (StringUtils.isEmpty(user.getName()) || StringUtils.isEmpty(user.getPwd())) {
            mav.addObject("message", "用户名或密码不能为空！");
            return mav;
        }
        if (null != userService.findOneById(user.getLoginId())) {
            mav.addObject("message", "用户已存在");
        }
        try {
            userService.add(user);
        } catch (Exception e) {
            e.printStackTrace();
            mav.addObject("message", "用户其他信息错误");
            return mav;
        }
        mav.addObject("code", 110);
        mav.addObject("message", "恭喜，注册成功！");
        return mav;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8"})
    @ResponseBody
    public ModelAndView login(HttpServletRequest req, User user) {
        ModelAndView mav = new ModelAndView("home");
        String result;
        if (null == user) {
            responseObj = new ResponseObj<User>();
            responseObj.setCode(ResponseObj.EMPTY);
            responseObj.setMsg("登录信息不能为空");
            result = GsonUtils.gson.toJson(responseObj);    // 转换的json数据
            mav.addObject("result", result);
            return mav;
        }
        if (StringUtils.isEmpty(user.getLoginId()) || StringUtils.isEmpty(user.getPwd())) {
            responseObj= new ResponseObj<User>();
            responseObj.setCode(ResponseObj.FAILED);
            responseObj.setMsg("用户名或密码不能为空");
            result = GsonUtils.gson.toJson(responseObj);
            mav.addObject("result", result);
            return mav;
        }
        // 查找用户
        User user1 = userService.findOneById(user.getLoginId());
        if (null == user1) {
            responseObj = new ResponseObj<User>();
            responseObj.setCode(ResponseObj.EMPTY);
            responseObj.setMsg("未找到该用户");
            result = GsonUtils.gson.toJson(responseObj);
        } else {
            if (user.getPwd().equals(user1.getPwd())) {
                responseObj = new ResponseObj<User>();
                responseObj.setCode(ResponseObj.OK);
                responseObj.setMsg(ResponseObj.OK_STR);
                result = GsonUtils.gson.toJson(responseObj);
            } else {
                responseObj = new ResponseObj<User>();
                responseObj.setCode(ResponseObj.FAILED);
                responseObj.setMsg("用户密码错误");
                result = GsonUtils.gson.toJson(responseObj);
            }
        }
        mav.addObject("result", result);
        return mav;
    }
}
