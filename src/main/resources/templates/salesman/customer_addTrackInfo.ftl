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
                    <form class="form-horizontal" role="form" action="/crm/salesman/saveCustomerTrackInfo"
                          method="post">
                        <input type="hidden" name="customerInfoId" value="${customerInfo.id}">

                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">客户姓名</label>
                                <div class="col-sm-4">
                                    <input type="text" readonly="readonly" name="name" class="form-control"
                                           value="${customerInfo.name}">
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">具体事项</label>
                                <div class="col-sm-8">
                                    <textarea name="desc" maxlength="100" class="form-control"></textarea>
                                </div>
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
                desc: {
                    validators: {
                        notEmpty: {
                            message: '客户描述不能为空'
                        }
                    }
                }
            }
        });

    </script>
</body>
</html>