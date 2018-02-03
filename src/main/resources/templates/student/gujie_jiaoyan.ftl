<#include "head.ftl">
<style>
    .input {
        width: 50px;
    }
</style>
<div class="container">
    <ol class="breadcrumb">
        <li>固结实验</li>
        <li>实验数据验证</li>
    </ol>
    <div class="row">
        <div class="col-md-4">
            <div class="col-md-12">
                <table class="table table-bordered">
                    <tr>
                        <td>密度</td>
                        <td>1</td>
                    </tr>
                    <tr>
                        <td>含水量（%）</td>
                        <td>1</td>
                    </tr>
                    <tr>
                        <td>土比重</td>
                        <td>1</td>
                    </tr>
                    <tr>
                        <td>初始高度</td>
                        <td>1</td>
                    </tr>
                </table>
            </div>
            <div class="col-md-12">
                <button class="btn btn-primary" type="button">计算校验</button>
                <button class="btn btn-primary" type="button">生成曲线</button>
                <button class="btn btn-primary" type="button">校验数据</button>
            </div>
        </div>
        <div class="col-md-8">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>P（kPa）</th>
                    <th>变形量（mm）</th>
                    <th>e</th>
                    <th>压缩系数</th>
                    <th>压缩莫量</th>
                </tr>
                </thead>
                <tbody id="tableBody">
                <tr>
                    <td>1</td>
                    <td>1</td>
                    <td><input type="text" class="input"></td>
                    <td><input type="text" class="input"></td>
                    <td><input type="text" class="input"></td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>1</td>
                    <td><input type="text" class="input"></td>
                    <td><input type="text" class="input"></td>
                    <td><input type="text" class="input"></td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>1</td>
                    <td><input type="text" class="input"></td>
                    <td><input type="text" class="input"></td>
                    <td><input type="text" class="input"></td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>1</td>
                    <td><input type="text" class="input"></td>
                    <td><input type="text" class="input"></td>
                    <td><input type="text" class="input"></td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>1</td>
                    <td><input type="text" class="input"></td>
                    <td><input type="text" class="input"></td>
                    <td><input type="text" class="input"></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12" style="margin-top: 10px;margin-bottom: 10px;border-top: 2px solid black;"></div>
    </div>
    <div class="row">
        <div class="col-md-3">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">数据校验结果</h3>
                </div>
                <div class="panel-body">
                    <h1>未校验</h1>
                </div>
            </div>
        </div>
        <div class="col-md-9">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">图形验证</h3>
                </div>
                <div class="panel-body">
                    <div class="col-md-12" id="chart" style="height: 500px;">

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/js/echarts.min.js"></script>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var data = [[12, 10], [11, 10], [15, 20], [22, 30], [25, 40]];
    var data2 = [[13, 0], [-14, 10], [-15.5, 20], [-52.1, 40]];
    var symbolSize = 10;
    var dom = document.getElementById("chart");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    option = {
        legend: {
            data:['原始数据','你的数据']
        },
        xAxis: {
            min: -100,
            max: 80,
            type: 'value',
            axisLine: {onZero: true}
        },
        yAxis: {
            min: -30,
            max: 60,
            type: 'value',
            axisLine: {onZero: true}
        },
        tooltip: {
            trigger: 'axis'
        },
        series: [
            {
                id: 'a',
                name:"原始数据",
                type: 'line',
                smooth: true,
                symbolSize: symbolSize,
                data: data
            },
            {
                id: 'b',
                name:"你的数据",
                type: 'line',
                smooth: true,
                symbolSize: symbolSize,
                data: data2
            }
        ]
    };
    ;
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
</script>
<#include "foot.ftl">