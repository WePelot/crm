<html>
<head>
    <meta charset="utf-8">
    <title>提示</title>
    <link href="/bootstrap/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="alert alert-dismissable alert-success">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                <h4>
                    成功!
                </h4> <strong>${errorMsg!""}</strong><a href="${redirectUrl}" class="alert-link">1s后自动跳转</a>
            </div>
        </div>
    </div>
</div>

</body>

<script>
    setTimeout('location.href="${redirectUrl}"', 1000);
</script>

</html>