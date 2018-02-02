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
                        <iframe src="http://open.iqiyi.com/developer/player_js/coopPlayerIndex.html?vid=73e3ac5fc53c842a1e3f9631f1e3fa90&tvId=1442071809&accessToken=2.f22860a2479ad60d8da7697274de9346&appKey=3955c3425820435e86d0f4cdfe56f5e7&appId=1368&height=100%&width=100%"
                                frameborder="0" allowfullscreen="true" width="100%" height="600"></iframe>
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
            <table class="table table-bordered">
                <tr>
                    <th>P（kPa）</th>
                    <th>变形量（mm）</th>
                    <th>操作</th>
                </tr>
                <tr>
                    <td><input type="text" id="addKPA"></td>
                    <td><input type="text" id="addMM"></td>
                    <td><button type="button" class="btn btn-default">添加</button> </td>
                </tr>
            </table>
        </div>
        <div class="col-md-6">

        </div>
    </div>
</div>
<#include "foot.ftl">