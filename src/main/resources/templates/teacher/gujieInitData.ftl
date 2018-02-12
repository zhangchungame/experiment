<#include "head.ftl">
<div class="container">
    <div class="page-header">
        <h1>班级信息</h1>
    </div>
    <div class="row">
        <form method="post" action="/teacher/gujie/initData" id="form1">
            <input type="hidden" name="id" value="${maClassInfo.id!}">
            <div class="form-group">
                <label for="exampleInputEmail1">密度ρ0 (g/cm3)</label>
                <input type="text" id="midu" name="midu" class="form-control" placeholder="请输入密度" value="${maClassInfo.midu!}">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">含水率w0(%)</label>
                <input type="text" id="hanshuiliang" name="hanshuiliang" class="form-control" placeholder="请输入含水率" value="${maClassInfo.hanshuiliang!}">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">初始高度h0(mm)</label>
                <input type="text" id="chushigaodu" name="chushigaodu" class="form-control" placeholder="请输入初始高度" value="${maClassInfo.chushigaodu!}">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">土粒比重Gs</label>
                <input type="text" id="tulibizhong" name="tulibizhong" class="form-control" placeholder="请输入土粒比重" value="${maClassInfo.tulibizhong!}">
            </div>
            <button type="button" id="baocun" class="btn btn-default">保存</button>
        </form>
    </div>
</div>
<script>
    $("#baocun").click(function () {
        if($("#midu").val()!=""
                &&$("#hanshuiliang")!=""
                &&$("#chushigaodu")!=""
                &&$("#tulibizhong")!=""){
            $("#form1").submit();
        }else{
            alert("参数为空");
        }
    });
</script>
<#include "foot.ftl">