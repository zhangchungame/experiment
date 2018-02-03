<#include "head.ftl">
<div class="container">
    <ol class="breadcrumb">
        <li>固结实验</li>
        <li>实验数据录入</li>
    </ol>
    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion"
                           href="#collapseTwo">
                            这里放视频或图片，点击可折叠
                        </a>
                    </h4>
                </div>
                <div id="collapseTwo" class="panel-collapse collapse in">
                    <div class="panel-body">
                        <video src="/image/gujie_video.mp4" controls="controls">
                            您的浏览器不支持 video 标签。
                        </video>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <div class="row">
        <div class="col-md-12" style="border-bottom: 2px solid black;margin-top: 10px;margin-bottom: 10px"></div>
    </div>
    <div class="row">
        <div class="col-md-6">
            <table class="table table-bordered" >
                <thead>
                <tr>
                    <th>P（kPa）</th>
                    <th>变形量（mm）</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="tableBody">
                    <tr>
                        <td>1</td>
                        <td>1</td>
                        <td><button type="button" class="btn btn-default del" >删除</button></td>
                    </tr>
                </tbody>
                <tfoot>

                    <tr>
                        <td><input type="text" id="addKPA"></td>
                        <td><input type="text" id="addMM"></td>
                        <td>
                            <button type="button" class="btn btn-default" id="add">添加</button>
                        </td>
                    </tr>
                </tfoot>
            </table>
        </div>
        <div class="col-md-6">
            <button type="button" class="btn btn-default" id="tijiao">提交</button>
        </div>
    </div>
</div>
<script>
    $("#add").click(function () {
        var kpa = $("#addKPA").val();
        var mm = $("#addMM").val();
        if (isRealNum(kpa) && isRealNum(mm)) {
            var html="<tr>\n" +
                    "                        <td>"+kpa+"</td>\n" +
                    "                        <td>"+mm+"</td>\n" +
                    "                        <td><button type=\"button\" class=\"btn btn-default del\" >删除</button></td>\n" +
                    "                    </tr>";
            $("#tableBody").append(html);
            $("#addKPA").val("");
            $("#addMM").val("");
        } else {
            alert("请输入数字");
        }
    })
    $("#tableBody").on("click",".del",function () {
        $(this).parent().parent().remove();
    })
    $("#tijiao").click(function () {
        $("#tableBody").find("tr").each(function () {
            $(this).find("td").each(function (i) {
                if(i<2){
                    console.log(i,$(this).text());
                }
            });
        })
        window.location.reload();
    });
</script>
<#include "foot.ftl">