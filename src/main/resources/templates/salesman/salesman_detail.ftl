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
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="username" class="col-sm-2 control-label">用户名</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="username" name="username"
                                       readonly="readonly" value="${salesmanInfo.username}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="name" class="col-sm-2 control-label">姓名</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="text" name="text"
                                       value="${salesmanInfo.name}" readonly="readonly"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="name" class="col-sm-2 control-label">身份</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="text" name="text"
                                       value="${salesmanInfo.getSalesmanInfoIdentityEnum().getMsg()}"
                                       readonly="readonly"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="phone" class="col-sm-2 control-label">手机号码</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="phone" name="phone"
                                       value="${salesmanInfo.phone}" readonly="readonly"/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>