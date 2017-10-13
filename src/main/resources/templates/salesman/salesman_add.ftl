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
                    <form class="form-horizontal" role="form" action="/crm/salesman/add" method="post"
                          onsubmit="return checkAddInfo();">
                        <div class="form-group">
                            <label for="username" class="col-sm-2 control-label">用户名</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="username" name="username"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">身份</label>
                            <div class="col-sm-6">
                                <select name="identity" class="form-control">
                                <#if identity==1>
                                    <option value="0">普通销售</option>
                                </#if>
                                <#if identity==2>
                                    <option value="1">销售组长</option>
                                </#if>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="name" class="col-sm-2 control-label">姓名</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="name" name="name"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="phone" class="col-sm-2 control-label">手机号码</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="phone" name="phone"/>
                                <input type="button" class="form-control" id="checkPhone" name="checkPhone"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default">添加</button>
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
                username: {
                    validators: {
                        notEmpty: {
                            message: '用户名不能为空'
                        },
                        stringLength: {
                            min: 6,
                            max: 18,
                            message: '用户名长度必须在6到18位之间'
                        },
                        regexp: {
                            regexp: /^[a-zA-Z0-9_]+$/,
                            message: '用户名只能包含大写、小写、数字和下划线'
                        }
                    }
                },
                name: {
                    validators: {
                        notEmpty: {
                            message: '姓名不能为空'
                        },
                        stringLength: {
                            min: 1,
                            max: 18,
                            message: '姓名长度必须在1到18位之间'
                        }
                    }
                },
                phone: {
                    validators: {
                        notEmpty: {
                            message: '手机号码不能为空'
                        },
                        regexp: {
                            regexp: /^1(3|4|5|7|8)\d{9}$/,
                            message: '手机号码格式不正确'
                        }
                    }
                }
            }
        });

        function checkAddInfo() {
            var checkResult = false;

            //获取当前表单状态
            var flag = $("form").data("bootstrapValidator").isValid();
            if (flag) {
                //获取用户名
                var username = $("#username").val();
                //获取手机号码
                var phone = $("#phone").val();
                //获取姓名
                var name = $("#name").val();

                //发送ajax请求
                $.ajax({
                    url: '/crm/salesman/checkSalesmanInfoByQuery',
                    async: false,//同步，会阻塞操作
                    type: 'GET',//PUT DELETE POST
                    data: {"username": username, "phone": phone, "name": name},
                    success: function (result) {
                        if (result.code == 0) {
                            checkResult = true;
                        } else {
                            alert(result.msg);
                        }
                    }
                })
            }
            return checkResult;
        }


        function checkPhone() {
            var checkResult = false;
            //获取手机号码
            var phone = $("#phone").val();

            //发送ajax请求
            $.ajax({
                url: '/crm/salesman/checkSalesmanInfoByQuery',
                async: false,//同步，会阻塞操作
                type: 'GET',//PUT DELETE POST
                data: {"phone": phone},
                success: function (result) {
                    if (result.code == 0) {
                        checkResult = true;
                    } else {
                        alert(result.msg);
                    }
                }
            });
            return checkResult;
        }

        $("#checkPhone").click(function () {
            checkPhone();
        })
    </script>
</body>
</html>