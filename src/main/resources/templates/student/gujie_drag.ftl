<#include "head.ftl">
<style>
    .float-button {
        position: fixed;
        bottom: 90px;
        right: 50px;
        background: #b4d145;
    }
</style>
<script src="/js/d3.js"></script>
<div class="container">
    <div class="row">
        <svg id="svgArea">
            <g id="g1">
                <g class="canmove" id="g1_1" transform='translate(295 115)'>
                    <ellipse fill="#FBB03B" cx="143.6" cy="99.7" rx="114.5" ry="71.4"/>
                    <linearGradient id="SVGID_1_" gradientUnits="userSpaceOnUse" x1="93.6895" y1="114.6165"
                                    x2="120.2629" y2="92.7051">
                        <stop offset="0" style="stop-color:#FFFFFF"/>
                        <stop offset="1" style="stop-color:#000000"/>
                    </linearGradient>
                    <ellipse fill="url(#SVGID_1_)" cx="143.3" cy="73.7" rx="113.8" ry="58.7"/>
                </g>
            </g>
        </svg>
    </div>
</div>
<div class="float-button">
    <button class="btn btn_default" id="nextStep"
    >下一步</button>
</div>
<script>
    var num = [{x: 150, y: 250},
        {x: 400, y: 250},
        {x: 150, y: 450},
        {x: 400, y: 450}];
    var colorText = [
        "红色",
        "蓝色",
        "黑色",
        "绿色",
    ]
    var currentNum = 3;
    var svg111 = d3.select("body").select("#svgArea").attr("width", "100%").attr("height", "800px").attr("fill", "blue");
    var svg = svg111.append("g")
    svg.call(d3.zoom().on("zoom", function () {
        console.log(d3.event.transform);
        svg.attr("transform", d3.event.transform)
    }))
    //d3.event.transform.
    var zhongxin_x = parseInt(svg.style("width")) / 2;
    svg.append("line").attr("x1", zhongxin_x).attr("y1", 0).attr("x2", zhongxin_x).attr("y2", 800).attr("stroke", "rgb(255,0,0)");
    svg.append("ellipse").attr("class", "canmove").attr("num", 0).attr("cx", num[0].x).attr("cy", num[0].y).attr("rx", 60).attr("ry", 30).attr("fill", "red");
    svg.append("ellipse").attr("class", "canmove").attr("num", 1).attr("cx", num[1].x).attr("cy", num[1].y).attr("rx", 80).attr("ry", 40).attr("fill", "blue");
    svg.append("ellipse").attr("class", "canmove").attr("num", 2).attr("cx", num[2].x).attr("cy", num[2].y).attr("rx", 100).attr("ry", 50).attr("fill", "black");
    svg.append("ellipse").attr("class", "canmove").attr("num", 3).attr("cx", num[3].x).attr("cy", num[3].y).attr("rx", 120).attr("ry", 60).attr("fill", "green");
    var textshow = svg.append("text").attr("x", 50).attr("y", 750).text("请移动绿色到右边");

    d3.selectAll(".canmove").on('mousedown', function () {
        coordX = d3.mouse(this)[0];
        coordY = d3.mouse(this)[1];
        console.log(coordX, coordY);
    }).call(d3.drag().on("start", started));

    function started() {
        var circle = d3.select(this).classed("dragging", true);

        d3.event.on("drag", dragged).on("end", ended);

        function dragged(d) {
//            circle.raise().attr("cx", d3.event.x).attr("cy", d3.event.y);
            var transX = d3.event.x - coordX
            var transY = d3.event.y - coordY
            d3.select(this).attr("transform", "translate(" + transX + " " + transY + ")")
        }

        function ended() {
            if (circle.attr("num") == currentNum && parseInt(circle.attr("cx")) > zhongxin_x) {
                currentNum--
                circle.attr("cx", zhongxin_x + 200).attr("cy", 500);
                circle.call(d3.drag().on("start", null));
                textshow.text("请移动" + colorText[currentNum] + "到右边");
            } else {
                alert("先动" + colorText[currentNum]);
                circle.attr("cx", num[circle.attr("num")].x).attr("cy", num[circle.attr("num")].y);
            }
            if (currentNum < 0) {
                d3.selectAll(".canmove").call(d3.drag().on("start", null));
                textshow.text("作业完成");
            }
            circle.classed("dragging", false);
        }
    }


</script>
<script>
    $("#nextStep").click(function () {
        $.ajax({
            type:"GET",
            url:"/student/inputdata",
            success:function (data) {
                if(data.code==200){
                    window.location.href="/student/gujie";
                }else{
                    alert(data.msg);
                }
            }
        })
    });
</script>
<#include "foot.ftl">