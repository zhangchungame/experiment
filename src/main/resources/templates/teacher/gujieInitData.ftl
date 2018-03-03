<#include "head.ftl">
<div class="container">
    <div class="page-header">
        <h1>班级信息</h1>
    </div>
    <div class="row">
        <form method="post" action="/teacher/gujie/initData" id="form1">
            <input type="hidden" name="classId" id="classId" value="${maGujieInitData.classId!}">
            <div class="form-group">
                <label for="exampleInputEmail1">密度ρ0 (g/cm3)</label>
                <input type="text" id="midu" name="midu" class="form-control" placeholder="请输入密度" value="${maGujieInitData.midu!}">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">含水率w0(%)</label>
                <input type="text" id="hanshuiliang" name="hanshuiliang" class="form-control" placeholder="请输入含水率" value="${maGujieInitData.hanshuiliang!}">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">初始高度h0(mm)</label>
                <input type="text" id="chushigaodu" name="chushigaodu" class="form-control" placeholder="请输入初始高度" value="${maGujieInitData.chushigaodu!}">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">土粒比重Gs</label>
                <input type="text" id="tulibizhong" name="tulibizhong" class="form-control" placeholder="请输入土粒比重" value="${maGujieInitData.tulibizhong!}">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">a1-2</label>
                <input type="text" id="a12" name="a12" class="form-control" placeholder="请输入a1-2" value="${maGujieInitData.a12!}">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">Cc</label>
                <input type="text" id="cc" name="cc" class="form-control" placeholder="请输入Cc" value="${maGujieInitData.cc!}">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">λ</label>
                <input type="text" id="lambda" name="lambda" class="form-control" placeholder="请输入λ" value="${maGujieInitData.lambda!}">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">κ</label>
                <input type="text" id="k" name="k" class="form-control" placeholder="请输入κ" value="${maGujieInitData.k!}">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">e偏差（%）</label>
                <input type="text" id="pce" name="pce" class="form-control" placeholder="请输入e偏差" value="${maGujieInitData.pce!}">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">压缩系数ai偏差（%）</label>
                <input type="text" id="pcyasuoxishu" name="pcyasuoxishu" class="form-control" placeholder="请输入压缩系数ai偏差" value="${maGujieInitData.pcyasuoxishu!}">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">压缩模量Es偏差（%）</label>
                <input type="text" id="pcyasuomoliang" name="pcyasuomoliang" class="form-control" placeholder="请输入压缩模量Es偏差" value="${maGujieInitData.pcyasuomoliang!}">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">a1-2偏差（%）</label>
                <input type="text" id="pca12" name="pca12" class="form-control" placeholder="请输入a1-2偏差" value="${maGujieInitData.pca12!}">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">Cc偏差（%）</label>
                <input type="text" id="pccc" name="pccc" class="form-control" placeholder="请输入Cc偏差" value="${maGujieInitData.pccc!}">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">λ偏差（%）</label>
                <input type="text" id="pclambda" name="pclambda" class="form-control" placeholder="请输入λ偏差" value="${maGujieInitData.pclambda!}">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">k偏差（%）</label>
                <input type="text" id="pck" name="pck" class="form-control" placeholder="请输入k偏差" value="${maGujieInitData.pck!}">
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
                &&$("#tulibizhong")!=""
                &&$("#a12")!=""
                &&$("#cc")!=""
                &&$("#lambda")!=""
                &&$("#k")!=""
                &&$("#pce")!=""
                &&$("#pcyasuoxishu")!=""
                &&$("#pcyasuomoliang")!=""
                &&$("#pca12")!=""
                &&$("#pccc")!=""
                &&$("#pclambda")!=""
                &&$("#pck")!=""
        ){
            var postData={
                midu:$("#midu").val(),
                hanshuiliang:$("#hanshuiliang").val(),
                chushigaodu:$("#chushigaodu").val(),
                tulibizhong:$("#tulibizhong").val(),
                a12:$("#a12").val(),
                cc:$("#cc").val(),
                lambda:$("#lambda").val(),
                k:$("#k").val(),
                pce:$("#pce").val(),
                pcyasuoxishu:$("#pcyasuoxishu").val(),
                pcyasuomoliang:$("#pcyasuomoliang").val(),
                pca12:$("#pca12").val(),
                pccc:$("#pccc").val(),
                pclambda:$("#pclambda").val(),
                pck:$("#pck").val(),
                classId:$("#classId").val(),
            }
            $.ajax({
                type:"POST",
                url:"/teacher/gujie/initData",
                contentType:"application/json;charset=utf-8",
                data: JSON.stringify(postData),
                success:function (data) {
                    if(data.code==200){
                        window.location.href="/teacher/classList"
                    }else{
                        alert(data.msg);
                    }
                    tijiao.removeAttr("disabled");
                }

            });
        }else{
            alert("参数为空");
        }
    });
</script>
<#include "foot.ftl">