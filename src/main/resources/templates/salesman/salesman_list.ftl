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
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>用户名</th>
                            <th>姓名</th>
                            <th>手机</th>
                            <th>身份</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list list.data as dto>
                        <tr>
                            <td>${dto.username}</td>
                            <td>${dto.name}</td>
                            <td>${dto.phone}</td>
                            <td>${dto.getSalesmanInfoIdentityEnum().msg}</td>
                            <td><a href="/salesman/detail?id=${dto.id}">客户详情</a></td>
                            <td><a href="/salesman/resetPwd?id=${dto.id}">密码重置</a></td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
                <div class="col-md-12 column">
                    <ul class="pagination pull-right">
                    <#if currentPage lte 1>
                        <li class="disabled"><a href="#">上一页</a></li>
                    <#else >
                        <li><a href="/salesman/list?pageNo=${currentPage -1}&pageSize=${size}">上一页</a></li>
                    </#if>
                    <#list 1..list.getTotalPage() as index>
                        <#if currentPage == index>
                            <li class="disabled"><a href="#">${index}</a></li>
                        <#else >
                            <li class=><a href="/salesman/list?pageNo=${index}&pageSize=${size}">${index}</a></li>
                        </#if>
                    </#list>
                    <#if currentPage gte list.getTotalPage()>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else >
                        <li><a href="/salesman/list?pageNo==${currentPage + 1}&size=${size}">下一页</a></li>
                    </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</body>
</html>