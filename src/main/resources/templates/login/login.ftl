<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>bootstrap案例</title>
    <!--用百度的静态资源库的cdn安装bootstrap环境-->
    <!-- Bootstrap 核心 CSS 文件 -->
    <link href="/plug/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!--font-awesome 核心我CSS 文件-->
    <link href="//cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">

    <!-- 在bootstrap.min.js 之前引入 -->
    <script src="/js/jquery-3.3.1.min.js"></script>
    <!-- Bootstrap 核心 JavaScript 文件 -->
    <script src="/plug/bootstrap/js/bootstrap.min.js"></script>
    <style type="text/css">
        body{background: url(/image/beijing.jpeg) no-repeat;background-size:cover;font-size: 16px;}
        .form{background: rgba(55,122,242,1);width:400px;margin:200px auto;}
        #login_form{display: block;}
        #register_form{display: none;}
        .fa{display: inline-block;top: 27px;left: 6px;position: relative;color: #ccc;}
        input[type="text"],input[type="password"]{padding-left:26px;}
        .checkbox{padding-left:21px;}
        .tab{background: rgb(117,120,125);cursor:pointer;text-align: center;
            padding-left:0;width}
        .tab h2{cursor:pointer;}
        .choose{background: rgb(214,97,162);}
    </style>
</head>
<body>
<!--
    基础知识：
    网格系统:通过行和列布局
    行必须放在container内
    手机用col-xs-*
    平板用col-sm-*
    笔记本或普通台式电脑用col-md-*
    大型设备台式电脑用col-lg-*
    为了兼容多个设备，可以用多个col-*-*来控制；
-->
<div class="container">
    <div class="form row">
        <div class="col-md-12" style="padding: 0;" type="tabStudent">
            <div class="col-md-6 tab choose" >
                <h2 >学生</h2>
            </div>
            <div class="col-md-6 tab " type="tabTeacher">
                <h2 >老师</h2>
            </div>
        </div>
        <div class="col-md-12" id="studentDiv">
            <form class="form-horizontal col-sm-offset-3 col-md-offset-3" action="/login/student" method="post" id="studentLogin">
                <div class="col-sm-9 col-md-9">
                    <div class="form-group">
                        <i class="fa fa-user fa-lg"></i>
                        <input class="form-control required" type="text" placeholder="学号" id="studentAccount" name="studentNo" />
                    </div>
                    <div class="form-group">
                        <i class="fa fa-lock fa-lg"></i>
                        <input class="form-control required" type="password" placeholder="密码" id="studentPassword" name="password" />
                    </div>
                    <div class="form-group">
                        <label class="checkbox">
                            <#--<input type="checkbox" name="remember" value="1"/> Remember me-->
                        </label>
                        <hr />
                        <p style="color: red;" id="studentMsg"></p>
                    </div>
                    <div class="form-group">
                        <input type="button" class="btn btn-success pull-right" id="studentSubmit" value="登录"/>
                    </div>
                </div>
            </form>
        </div>

        <div class="col-md-12" id="teacherDiv" style="display: none;">
            <form class="form-horizontal col-sm-offset-3 col-md-offset-3" action="/login/teacher" method="post" id="teacherLogin">
                <div class="col-sm-9 col-md-9">
                    <div class="form-group">
                        <i class="fa fa-user fa-lg"></i>
                        <input class="form-control required" type="text" placeholder="帐号" id="teacherAccount" name="account" />
                    </div>
                    <div class="form-group">
                        <i class="fa fa-lock fa-lg"></i>
                        <input class="form-control required" type="password" placeholder="密码" id="teacherPassword" name="password" />
                    </div>
                    <div class="form-group">
                        <label class="checkbox">
                        <#--<input type="checkbox" name="remember" value="1"/> Remember me-->
                        </label>
                        <hr />
                        <p style="color: red;" id="teacherMsg"></p>
                    </div>
                    <div class="form-group">
                        <input type="button" class="btn btn-success pull-right" id="teacherSubmit" value="登录"/>
                    </div>
                </div>
            </form>
        </div>
    </div>

</div>
<script>
    $("#teacherSubmit").click(function () {
        $("#teacherMsg").html("");
       if($("#teacherAccount").val()!=""&&$("#teacherPassword").val()!=""){
           $("#teacherLogin").submit();
       }else{
            $("#teacherMsg").html("帐号密码不能为空");
       }
    });

    $("#studentSubmit").click(function () {
        $("#studentMsg").html("");
        if($("#studentAccount").val()!=""&&$("#studentPassword").val()!=""){
            $("#studentLogin").submit();
        }else{
            $("#studentMsg").html("学号密码不能为空");
        }
    });
    $(".tab").click(function () {
        $(".tab").removeClass("choose");
        $(this).addClass("choose");
        if($(this).attr("type")=="tabTeacher"){
            $("#teacherDiv").show();
            $("#studentDiv").hide();
        }else{
            $("#teacherDiv").hide();
            $("#studentDiv").show();
        }
    });
</script>
</body>
</html>