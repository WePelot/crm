<html>
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
<#--边栏sidebar-->
<#include "../salesman/nav.ftl">

<#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form class="form-horizontal" role="form" method="post" action="/crm/salesman/chgPwd"
                          onsubmit="return checkPwd()">
                        <div class=" form-group">
                            <label for="oldPassword" class="col-sm-2 control-label">原密码</label>
                            <div class="col-sm-6">
                                <input type="password" class="form-control" id="oldPassword" name="oldPassword"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="newPassword" class="col-sm-2 control-label">新密码</label>
                            <div class="col-sm-6">
                                <input type="password" class="form-control" id="newPassword" name="newPassword"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="newPasswordSure" class="col-sm-2 control-label">确认密码</label>
                            <div class="col-sm-6">
                                <input type="password" class="form-control" id="newPasswordSure"
                                       name="newPasswordSure"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default">修改</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <script>
        $('form').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                oldPassword: {
                    validators: {
                        notEmpty: {
                            message: '密码不能为空'
                        },
                        stringLength: {
                            min: 6,
                            max: 18,
                            message: '密码长度必须在6到18位之间'
                        },
                        regexp: {
                            regexp: /^[a-zA-Z0-9_]+$/,
                            message: '密码只能包含大写、小写、数字和下划线'
                        }
                    }
                },
                newPassword: {
                    validators: {
                        notEmpty: {
                            message: '密码不能为空'
                        },
                        stringLength: {
                            min: 6,
                            max: 18,
                            message: '密码长度必须在6到18位之间'
                        },
                        regexp: {
                            regexp: /^[a-zA-Z0-9_]+$/,
                            message: '密码只能包含大写、小写、数字和下划线'
                        }
                    }
                },
                newPasswordSure: {
                    validators: {
                        notEmpty: {
                            message: '密码不能为空'
                        },
                        stringLength: {
                            min: 6,
                            max: 18,
                            message: '密码长度必须在6到18位之间'
                        },
                        regexp: {
                            regexp: /^[a-zA-Z0-9_]+$/,
                            message: '密码只能包含大写、小写、数字和下划线'
                        }
                    }
                }
            }
        });

        //密码校验
        function checkPwd() {
            //获取当前表单状态
            var flag = $("form").data("bootstrapValidator").isValid();
            if (flag) {
                var newPassword = document.getElementById("newPassword").value;
                var newPasswordSure = document.getElementById("newPasswordSure").value;
                if (newPassword == newPasswordSure) {
                    return true;
                } else {
                    alert("新密码两次输入不一致");
                    return false;
                }
            }

        }
    </script>
</body>
</html>