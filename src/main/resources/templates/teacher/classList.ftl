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
            <a class="btn btn-primary" type="button" href="/teacher/createClass">新增</a>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <td>班级名</td>
                        <td>年级</td>
                        <td>操作</td>
                    </tr>
                </thead>
                <tbody>
                <#list pageInfo.list as item>
                <tr>
                    <td>${item.className}</td>
                    <td>${item.grade}</td>
                    <td>
                        <button class="btn btn-primary" type="button" classId="${item.id}">删除</button>
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
</script>
<#include "foot.ftl">