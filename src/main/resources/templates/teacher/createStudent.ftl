<#include "head.ftl">
<div class="container">
    <div class="page-header">
        <h1>班级信息</h1>
    </div>
    <div class="row">
        <form method="post" action="/teacher/createStudent" id="form1">
            <input type="hidden" name="id" value="${maStudent.id!}">
            <div class="form-group">
                <label for="exampleInputEmail1">年级</label>
                <input type="text" id="grad" name="grad" class="form-control" placeholder="请输入年级" value="${maStudent.grad!}" disabled>
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">班级名</label>
                <input type="text" id="className" name="className" class="form-control" placeholder="请输入班级名" value="${maStudent.className!}" disabled>
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">姓名</label>
                <input type="text" id="name" name="name" class="form-control" placeholder="请输入姓名" value="${maStudent.name!}" >
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">学号</label>
                <input type="text" id="studentNo" name="studentNo" class="form-control" placeholder="请输入学号" value="${maStudent.studentNo!}" disabled>
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">密码</label>
                <input type="text" id="password" name="password" class="form-control" placeholder="请输入密码" value="${maStudent.password!}">
            </div>
            <button type="button" id="baocun" class="btn btn-default">保存</button>
        </form>
    </div>
</div>
<script>
    $("#baocun").click(function () {
        if($("#name").val()!=""
                &&$("#password").val()!=""
        ){
            $("#form1").submit();
        }else{
            alert("参数为空");
        }
    });
</script>
<#include "foot.ftl">