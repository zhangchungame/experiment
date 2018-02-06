<#include "head.ftl">
<div class="container">
    <div class="page-header">
        <h1>班级信息</h1>
    </div>
    <div class="row">
        <form method="post" action="/teacher/createClass" id="form1">
            <input type="hidden" name="id" value="${maClassInfo.id!}">
            <div class="form-group">
                <label for="exampleInputEmail1">年级</label>
                <input type="text" id="grade" name="grade" class="form-control" placeholder="请输入年级" value="${maClassInfo.grade!}">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">班级名</label>
                <input type="text" id="className" name="className" class="form-control" placeholder="请输入班级名" value="${maClassInfo.className!}">
            </div>
            <button type="button" id="baocun" class="btn btn-default">保存</button>
        </form>
    </div>
</div>
<script>
    $("#baocun").click(function () {
        if($("#grade").val()!="" &&$("#className")!=""){
            $("#form1").submit();
        }else{
            alert("参数为空");
        }
    });
</script>
<#include "foot.ftl">