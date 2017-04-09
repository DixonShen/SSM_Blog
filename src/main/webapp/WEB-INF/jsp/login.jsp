<%--
  Created by IntelliJ IDEA.
  User: Z003R98D
  Date: 4/6/2017
  Time: 3:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 以上两行是java代码的引用 --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
    <title>系统后台登录注册</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script type="text/javascript" src="../../static/js/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="../../static/js/login.js"></script>
    <link href="../../static/css/login2.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h1>后台登录注册模板</h1>

<div class="login" style="margin-top:50px;">

    <div class="header">
        <div class="switch" id="switch">
            <a class="switch_btn_focus" id="switch_qlogin" href="javascript:void(0);" tabindex="7">快速登录</a>
            <a class="switch_btn" id="switch_login" href="javascript:void(0);" tabindex="8">快速注册</a>
            <div class="switch_bottom" id="switch_bottom" style="position: absolute; width: 64px; left: 0px;">

            </div>
        </div>
    </div>


    <div class="web_qr_login" id="web_qr_login" style="display: block; height: 235px;">

        <!--登录-->
        <div class="web_login" id="web_login">


            <div class="login-box">


                <div class="login_form">
                    <form action="<%=request.getContextPath()%>/userAction/login" name="loginform"
                          accept-charset="utf-8" id="login_form" class="loginForm" method="post">
                        <input type="hidden" name="did" value="0"/>
                        <input type="hidden" name="to" value="log"/>
                        <div class="uinArea" id="uinArea">
                            <label class="input-tips" for="u">帐号：</label>
                            <div class="inputOuter" id="uArea">

                                <input type="text" id="u" name="loginId" class="inputstyle"/>
                            </div>
                        </div>
                        <div class="pwdArea" id="pwdArea">
                            <label class="input-tips" for="p">密码：</label>
                            <div class="inputOuter" id="pArea">

                                <input type="password" id="p" name="pwd" class="inputstyle"/>
                            </div>
                        </div>

                        <div style="padding-left:50px;margin-top:20px;"><input type="submit" value="登 录" style="width:150px;" class="button_blue"/></div>
                    </form>
                </div>

            </div>

        </div>
        <!--登录end-->
    </div>

    <!--注册-->
    <div class="qlogin" id="qlogin" style="display: none; ">

        <div class="web_login">
            <form name="form2" id="regUser" accept-charset="utf-8"  action="<%=request.getContextPath()%>/userAction/reg"
                  method="post">
            <input type="hidden" name="to" value="reg"/>
            <input type="hidden" name="did" value="0"/>
            <ul class="reg_form" id="reg-ul">
                <div id="userCue" class="cue">快速注册请注意格式</div>
                <li>

                    <label for="user"  class="input-tips2">用户名：</label>
                    <div class="inputOuter2">
                        <input type="text" id="user" name="loginId" maxlength="16" class="inputstyle2"/>
                    </div>

                </li>

                <li>

                    <label for="user"  class="input-tips2">姓名：</label>
                    <div class="inputOuter2">
                        <input type="text" id="name" name="name" maxlength="16" class="inputstyle2"/>
                    </div>

                </li>

                <li>
                    <label for="passwd" class="input-tips2">密码：</label>
                    <div class="inputOuter2">
                        <input type="password" id="passwd"  name="pwd" maxlength="16" class="inputstyle2"/>
                    </div>

                </li>
                <li>
                    <label for="passwd2" class="input-tips2">确认密码：</label>
                    <div class="inputOuter2">
                        <input type="password" id="passwd2" name="" maxlength="18" class="inputstyle2" />
                    </div>

                </li>

                <li>

                    <label for="cellNumber"  class="input-tips2">手机号：</label>
                    <div class="inputOuter2">
                        <input type="text" id="cellNumber" name="cellNumber" maxlength="16" class="inputstyle2"/>
                    </div>

                </li>

                <li>

                    <label for="sex"  class="input-tips2">性别：</label>
                    <div class="inputOuter2">
                        <input type="text" id="sex" name="sex" maxlength="16" class="inputstyle2"/>
                    </div>

                </li>

                <li>
                    <label for="age" class="input-tips2">年龄：</label>
                    <div class="inputOuter2">

                        <input type="text" id="age" name="age" maxlength="18" class="inputstyle2"/>
                    </div>

                </li>

                <li>
                    <div class="inputArea">
                        <input type="button" id="reg"  style="margin-top:10px;margin-left:85px;" class="button_blue"
                               value="注册"/>
                    </div>

                </li>
                <div class="cl"></div>
            </ul>
            </form>


        </div>


    </div>
    <!--注册end-->
</div>
<div class="advice">*推荐使用ie8或以上版本ie浏览器或Chrome内核浏览器访问本站</div>

</body>
</html>
