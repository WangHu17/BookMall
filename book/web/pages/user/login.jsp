<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sign Up Login</title>
    <%
        String basePath = request.getScheme()
                + "://"
                + request.getServerName()
                + ":"
                + request.getServerPort()
                + request.getContextPath()
                + "/";
    %>
    <base href="<%=basePath%>">
    <link rel="shortcut icon" type="image/x-icon" href="static/imgs/favicon.png" />
    <script src="static/js/jquery-3.5.1.min.js"></script>
    <link rel="stylesheet" href="static/css/login.css">
    <script src="static/js/login_view.js"></script>
    <script src="static/js/login_verify.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
    <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/icon?family=Material+Icons'>
</head>

<body>

<div class="cotn_principal">
    <div class="cont_centrar">
        <div class="cont_login">
            <div class="cont_info_log_sign_up">
                <!--登录初页-->
                <div class="col_md_login">
                    <div class="cont_ba_opcitiy">
                        <h2>LOGIN</h2>
                        <p>Lorem ipsum dolor sit amet, consectetur.</p>
                        <button class="btn_login" onclick="cambiar_login()">LOGIN</button>
                    </div>
                </div>
                <!--注册初页-->
                <div class="col_md_sign_up">
                    <div class="cont_ba_opcitiy">
                        <h2>SIGN UP</h2>
                        <p>Lorem ipsum dolor sit amet, consectetur.</p>
                        <button class="btn_sign_up" onclick="cambiar_sign_up()">SIGN UP</button>
                    </div>
                </div>
            </div>
            <div class="cont_back_info">
                <div class="cont_img_back_grey"><img src="static/imgs/login_bg.jpg" alt=""/></div>
            </div>
            <div class="cont_forms">
                <div class="cont_img_back_"><img src="static/imgs/login_bg.jpg" alt=""/></div>
                <!--登录框-->
                <div class="cont_form_login">
                    <!--返回按钮-->
                    <a href="javascript:;" onclick="ocultar_login_sign_up()">
                        <i class="material-icons">&#xE5C4;</i>
                    </a>
                    <%--错误提示信息--%>
                    <span id="loginResponseBox" class="errorMsg">
                        <%--<%=request.getAttribute("msg")==null?"请输入用户名和密码":request.getAttribute("msg")%>--%>
                        <%--${ empty requestScope.msg ? "请输入用户名和密码":requestScope.msg }--%>
                    </span>
                    <h2>LOGIN</h2>
                    <div id="loginForm">
                        <input type="text" placeholder="UserName" name="username"/>
                        <input type="password" placeholder="Password" name="password"/>
                        <input type="button" class="btn_login" value="LOGIN"/>
                    </div>
                </div>
                <!--注册框-->
                <div class="cont_form_sign_up">
                    <!--返回按钮-->
                    <a href="javascript:;" onclick="ocultar_login_sign_up()">
                        <i class="material-icons">&#xE5C4;</i>
                    </a>
                    <%--错误提示信息--%>
                    <span id="registerResponseBox" class="errorMsg">
                        <%--<%=request.getAttribute("msg1")==null?"请填写信息":request.getAttribute("msg1")%>--%>
                        <%--${ empty requestScope.msg1 ? "请填写信息":requestScope.msg1 }--%>
                    </span>
                    <h2>SIGN UP</h2>
                    <form id="registerForm">
                        <input type="text" placeholder="UserName" name="username"/>
                        <img src="static/imgs/right.png" alt="">
                        <input type="password" placeholder="Password" name="password"/>
                        <img src="static/imgs/right.png" alt="">
                        <input type="password" placeholder="Confirm Password" name="confpass"/>
                        <img src="static/imgs/right.png" alt="">
                        <input type="text" placeholder="Email" name="email"/>
                        <img src="static/imgs/right.png" alt="">
                        <input type="text" placeholder="Verification Code" name="verificode">
                        <img id="code_img" src="kaptcha.jpg">
                        <input type="button" class="btn_sign_up" value="SIGN UP"/>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    //验证码图片点击刷新
    $("#code_img").click(function () {
        this.src = "${basePath}kaptcha.jpg?d=" + new Date();
    });
</script>
</body>
</html>