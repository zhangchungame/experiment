function isRealNum(val){
    // isNaN()函数 把空串 空格 以及NUll 按照0来处理 所以先去除
    if(val === "" || val ==null){
        return false;
    }
    if(!isNaN(val)){
        return true;
    }else{
        return false;
    }
}

function jumpUrl(page) {
    var tmp=window.location.search.split("&");
    tmp.push("page="+page);
    window.location.href=window.location.pathname+"?"+tmp.join("&");
}