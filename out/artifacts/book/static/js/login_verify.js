$(function () {

    //【登录验证】

    //登录名验证
    $("#loginForm>input[name='username']").blur(function () {
        var username = this.value;
        var reg = /^\w{2,12}$/;
        if (!reg.test(username)) {
            $("#loginResponseBox").css('display', "block");
            $("#loginResponseBox").text("用户名格式错误");
        }
    });

    $("input.btn_login").click(function () {
        //外观设置
        document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_login";
        document.querySelector('.cont_form_login').style.display = "block";
        document.querySelector('.cont_form_sign_up').style.opacity = "0";
        setTimeout(function () {
            document.querySelector('.cont_form_login').style.opacity = "1";
        }, 400);
        setTimeout(function () {
            document.querySelector('.cont_form_sign_up').style.display = "none";
        }, 200);

        //1、用户名验证
        var username = $(".cont_form_login > div > input[name='username']").val();
        var reg = /^\w{2,12}$/;
        if (!reg.test(username)) {
            $("#loginResponseBox").css('display', "block");
            $("#loginResponseBox").text("用户名格式错误");
            return false;
        }

        //2、密码验证
        var password = $(".cont_form_login > div > input[name='password']").val();
        if (!reg.test(password)) {
            $("#loginResponseBox").css('display', "block");
            $("#loginResponseBox").text("密码格式错误");
            return false;
        }

        //登录
        $.getJSON("http://localhost:8080/book/userServlet", "action=ajaxLogin&username=" + username + "&password=" + password, function (data) {
            $("#loginResponseBox").css('display', "block");
            $("#loginResponseBox").text(data.response);
            if (data.response == "登陆成功") {
                location.href = "http://localhost:8080/book/index.jsp";
            }
        });
    });

    //【注册验证】

    //1、用户名验证
    $(".cont_form_sign_up input[name='username']").blur(function () {
        var name = this.value;
        //格式验证
        var reg = /^\w{2,12}$/;
        if (!reg.test(name)) {
            $(".cont_form_sign_up>form>img:nth-of-type(1)").css('display', "none");
            $("#registerResponseBox").css('display', "block");
            $("#registerResponseBox").text("用户名格式错误");
        }
        //是否已存在
        $.getJSON("http://localhost:8080/book/userServlet", "action=ajaxUsernameExist&username=" + name, function (data) {
            if (data.existUsername) {
                $(".cont_form_sign_up>form>img:nth-of-type(1)").css('display', "none");
                $("#registerResponseBox").css('display', "block");
                $("#registerResponseBox").text("用户名已存在");
                return false;
            } else {
                $(".cont_form_sign_up>form>img:nth-of-type(1)").css('display', "block");
                $("#registerResponseBox").css('display', "none");
            }
        });
    });

    //2、密码验证
    var password;
    $(".cont_form_sign_up input[name='password']").blur(function () {
        //格式验证
        password = this.value;
        var reg1 = /^\w{4,12}$/;
        if (!reg1.test(password)) {
            $(".cont_form_sign_up>form>img:nth-of-type(2)").css('display', "none");
            $("#registerResponseBox").css('display', "block");
            $("#registerResponseBox").text("密码格式错误");
        } else {
            $(".cont_form_sign_up>form>img:nth-of-type(2)").css('display', "block");
            $("#registerResponseBox").css('display', "none");
        }
    });

    //3、确认密码验证
    $(".cont_form_sign_up input[name='confpass']").blur(function () {
        //是否一致验证
        var confpass = this.value;
        if (confpass != password) {
            $(".cont_form_sign_up>form>img:nth-of-type(3)").css('display', "none");
            $("#registerResponseBox").css('display', "block");
            $("#registerResponseBox").text("确认密码不一致");
        } else {
            $(".cont_form_sign_up>form>img:nth-of-type(3)").css('display', "block");
            $("#registerResponseBox").css('display', "none");
        }
    });

    //4、邮箱验证
    $(".cont_form_sign_up input[name='email']").blur(function () {
        //格式验证
        var email = this.value;
        var reg2 = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
        if (!reg2.test(email)) {
            $(".cont_form_sign_up>form>img:nth-of-type(4)").css('display', "none");
            $("#registerResponseBox").css('display', "block");
            $("#registerResponseBox").text("邮箱格式错误");
        } else {
            $(".cont_form_sign_up>form>img:nth-of-type(4)").css('display', "block");
            $("#registerResponseBox").css('display', "none");
        }
    });

    //5、提交注册按钮
    $("input.btn_sign_up").click(function () {
        //外观设置
        document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_sign_up";
        document.querySelector('.cont_form_sign_up').style.display = "block";
        document.querySelector('.cont_form_login').style.opacity = "0";
        setTimeout(function () {
            document.querySelector('.cont_form_sign_up').style.opacity = "1";
        }, 100);
        setTimeout(function () {
            document.querySelector('.cont_form_login').style.display = "none";
        }, 400);

        //1、用户名验证
        var name = $(".cont_form_sign_up > form > input[name='username']").val();
        var reg = /^\w{2,12}$/;
        if (!reg.test(name)) {
            $(".cont_form_sign_up>form>img:nth-of-type(1)").css('display', "none");
            $("#registerResponseBox").css('display', "block");
            $("#registerResponseBox").text("用户名格式错误");
            return false;
        }

        //2、密码验证
        var password = $(".cont_form_sign_up > form > input[name='password']").val();
        var reg1 = /^\w{4,12}$/;
        if (!reg1.test(password)) {
            $(".cont_form_sign_up>form>img:nth-of-type(2)").css('display', "none");
            $("#registerResponseBox").css('display', "block");
            $("#registerResponseBox").text("密码格式错误");
            return false;
        }

        //3、确认密码验证
        var confpass = $(".cont_form_sign_up > form > input[name='confpass']").val();
        if (confpass != password) {
            $("#registerResponseBox").css('display', "block");
            $("#registerResponseBox").text("确认密码不一致");
            return false;
        }

        //4、邮箱验证
        var email = $(".cont_form_sign_up > form > input[name='email']").val();
        var reg2 = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
        if (!reg2.test(email)) {
            $("#registerResponseBox").css('display', "block");
            $("#registerResponseBox").text("邮箱格式错误");
            return false;
        }

        //5、验证码验证
        var verificode = $(".cont_form_sign_up > form > input[name='verificode']").val();
        if (verificode == "") {
            $("#registerResponseBox").css('display', "block");
            $("#registerResponseBox").text("请输入验证码");
            return false;
        }

        $("#registerResponseBox").css('display', "none");

        //提交注册
        $.getJSON("http://localhost:8080/book/userServlet", "action=ajaxRegister&username=" + name + "&password=" + password + "&email=" + email + "&verificode=" + verificode, function (data) {
            $("#registerResponseBox").css('display', "block");
            $("#registerResponseBox").text(data.response);
            if (data.response == "验证码错误") {
                $("#code_img").click();
            }
        });
    });

    //回车功能
    $(document).keyup(function () {
        var enter1 = $(".cont_form_login").css("display");
        if(event.keyCode == 13 && enter1 == "block"){
            $(".btn_login").click();
        }
        var enter2 = $(".cont_form_sign_up").css("display");
        if(event.keyCode == 13 && enter2 == "block"){
            $(".btn_sign_up").click();
        }
    });

});
