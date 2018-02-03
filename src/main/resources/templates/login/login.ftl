<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>上海大学实验系统</title>
    <link rel="stylesheet" href="/plug/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/css/style.css"/>
    <link href="//cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="/js/jquery-3.3.1.min.js"></script>
    <script src="/plug/bootstrap/js/bootstrap.min.js"></script>
</head>
<style>
    .loginDiv {
        margin: 0 auto;
        width: 500px;
        height: 300px;
        margin-top: 300px;
        padding-top: 30px;
        background: rgba(255, 255, 255, 0.2);
    }
    body{background: rgba(0, 0, 0, 0.2);background-size:cover;font-size: 16px;}
</style>
<body>
<div class="loginDiv">
    <div class="row">
        <div class="col-md-12">
            <form class="form-horizontal">
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
                    <div class="col-sm-10">
                        <input type="email" class="form-control" id="inputEmail3" placeholder="Email">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox"> Remember me
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label"></label>
                    <div class="col-sm-10">
                        <p class="form-control-static" style="color: red;">email@example.com</p>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">Sign in</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>