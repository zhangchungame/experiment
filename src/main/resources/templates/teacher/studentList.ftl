<#include "head.ftl">
<link href="/plug/bootstrap-paginator/css/bootstrap-combined.min.css" rel="stylesheet">
<div class="container">
    <div class="page-header">
        <h1>班级列表</h1>
    </div>
    <div class="row">
        <div class="col-md-10">
        </div>
        <div class="col-md-2">
            <a class="btn btn-primary" type="button" href="/teacher/batchCreateStudent">新增</a>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <td>年级</td>
                    <td>班级名</td>
                    <td>姓名</td>
                    <td>学号</td>
                    <td>密码</td>
                    <td>操作</td>
                </tr>
                </thead>
                <tbody>
                <#list pageInfo.list as item>
                <tr>
                    <td>${item.grad}</td>
                    <td>${item.className}</td>
                    <td>${item.name}</td>
                    <td>${item.studentNo}</td>
                    <td>${item.password}</td>
                    <td>
                        <a class="btn btn-primary" href="/teacher/createStudent?id=${item.id}">编辑</a>
                        <button class="btn btn-primary delStudent" type="button" studentId="${item.id}">删除</button>
                    </td>
                </tr>
                </#list>

                </tbody>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div id="example"></div>
        </div>
    </div>
</div>
<script src="/plug/bootstrap-paginator/js/bootstrap-paginator.min.js"></script>
<script src="/js/common.js"></script>
<script type='text/javascript'>
    var options = {
        currentPage: ${pageInfo.currentPage},
    totalPages: <#if pageInfo.totalPage==0>   1 <#else>  ${pageInfo.totalPage}</#if>,
        onPageClicked: function(e,originalEvent,type,page){
            jumpUrl(page);
            return;
        },
        itemContainerClass: function (type, page, current) {
            return (page === current) ? "active" : "pointer-cursor";
        }
    }

    $('#example').bootstrapPaginator(options);

    $(".delStudent").click(function () {
        var studentId=$(this).attr("studentId")
        var thisObj=$(this);
        $.ajax({
            type: "DELETE",
            url: "/teacher/createStudent?id="+studentId,
            success: function(data){
                if(data.code==200){
                    thisObj.parent().parent().remove();
                }else{
                    alert(data.msg);
                }
            }

        });
    })
</script>
<#include "foot.ftl">