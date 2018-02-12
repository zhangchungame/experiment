<#include "head.ftl">
<div class="container">
    <div class="page-header">
        <h1>学生信息批量添加</h1>
    </div>
    <div class="row">
        <form method="post" class="form-horizontal">
            <div class="form-group">
                <label class="col-sm-2 control-label">班级名</label>
                <div class="col-sm-10">
                    <select class="form-control" id="classId">
                        <option value="">请选择</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">姓名</label>
                <div class="col-sm-10">
                    <input type="text" id="name" name="name" class="form-control" placeholder="请输入姓名"
                           value="">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">学号</label>
                <div class="col-sm-10">
                    <input type="text" id="studentNo" name="studentNo" class="form-control" placeholder="请输入学号"
                           value="">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">密码</label>
                <div class="col-sm-10">
                    <input type="text" id="password" name="password" class="form-control" placeholder="请输入密码"
                           value="1234567890">
                </div>
            </div>
            <button type="button" id="tianjia" class="btn btn-default">添加</button>
        </form>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <td>班级</td>
                    <td>姓名</td>
                    <td>学号</td>
                    <td>密码</td>
                    <td>操作</td>
                </tr>
                </thead>
                <tbody id="tbody">
                </tbody>
            </table>
        </div>
        <div class="row">
            <div class="col-sm-4"></div>
            <div class="col-sm-4">
                <button class="btn btn-default" type="button" id="tijiao">提交</button>
                <a class="btn btn-default" href="/teacher/studentList">取消</a>
            </div>
            <div class="col-sm-4"></div>
        </div>
    </div>
</div>
<script>
    var classInfoList =${maClassList};
    var classInfoObjs = {};
    for (var i = 0; i < classInfoList.length; i++) {
        classInfo = classInfoList[i];
        classInfoObjs[classInfo.id] = {grad:classInfo.grad,className:classInfo.className,classId:classInfo.id};
        var html = "<option value=\"" + classInfo.id + "\">" + classInfoObjs[classInfo.id].grad+"-"+ classInfoObjs[classInfo.id].className+ "</option>";
        $("#classId").append(html);
    }

    var tableData = {};
    $("#tianjia").click(function () {
        var studentNo = $("#studentNo").val();
        var password = $("#password").val();
        var name = $("#name").val();
        var classId = $("#classId").val();
        if (studentNo == "" || password == "" || name == "" || classId == "") {
            alert("参数为空");
            return;
        }
        if (tableData[studentNo] == null) {
            tableData[studentNo] = {
                studentNo: studentNo,
                password: password,
                name: name,
                classId: classId,
                grad:classInfoObjs[classInfo.id].grad,
                className:classInfoObjs[classInfo.id].className,
            }
            var html = "\n" +
                    "                    <tr>" +
                    "                        <td>" + classInfoObjs[classId].grad+"-"+classInfoObjs[classId].className + "</td>\n" +
                    "                        <td>" + name + "</td>\n" +
                    "                        <td>" + studentNo + "</td>\n" +
                    "                        <td>" + password + "</td>\n" +
                    "                        <td><button class=\"btn btn-default del\" studentNo=\"" + studentNo + "\">删除</button> </td></tr>";
            $("#tbody").append(html);
        } else {
            alert("该学号已存在");
        }
    });

    $("#tbody").on("click", ".del", function () {
        tableData[$(this).attr("studentNo")] = null;
        $(this).parent().parent().remove();
    })

    $("#tijiao").click(function () {
        var tijiao=$(this);
        tijiao.attr("disabled",true);
        var postData = [];
        for (key in tableData) {
            postData.push(tableData[key]);
        }
        $.ajax({
            type: "post",
            url:"/teacher/batchCreateStudent",
            contentType:"application/json;charset=utf-8",
            data: JSON.stringify(postData),
            success:function (data) {
                if(data.code==200){
                    alert("创建成功");
                    window.location.href="/teacher/studentList"
                }else{
                    alert(data.msg);
                }
                tijiao.removeAttr("disabled");
            }
        })
    });
</script>
<#include "foot.ftl">