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
                        <#if identity==1>
                        <#--销售组长，拥有重置密码的功能-->
                            <th colspan="3">操作</th>
                        <#else >
                            <th colspan="2">操作</th>
                        </#if>

                        </tr>
                        </thead>
                        <tbody>
                        <#if list.data?exists>
                            <#list list.data as dto>
                            <tr>
                                <td>${dto.username}</td>
                                <td>${dto.name}</td>
                                <td>${dto.phone}</td>
                                <td>${dto.getSalesmanInfoIdentityEnum().msg}</td>
                                <td><a href="/crm/salesman/detail?id=${dto.id}">个人信息详情</a></td>
                                <td><a href="/crm/salesman/listCustomerInfo?salesmanId=${dto.id}">客户信息列表</a></td>
                                <#if identity==1>
                                    <td><a href="/crm/salesman/resetPwd?id=${dto.id}">密码重置</a></td>
                                </#if>
                            </tr>
                            </#list>
                        </#if>
                        </tbody>
                    </table>
                </div>
                <div class="col-md-12 column">
                    <ul class="pagination pull-right">
                        <li class="disabled"><a href="#">销售总数：${list.totalCount}</a></li>
                    <#if currentPage lte 1>
                        <li class="disabled"><a href="#">上一页</a></li>
                    <#else >
                        <li><a href="/crm/salesman/listSalesmanInfo?pageNo=${currentPage -1}&pageSize=${size}">上一页</a>
                        </li>
                    </#if>
                    <#list 1..list.getTotalPage() as index>
                        <#if currentPage == index>
                            <li class="disabled"><a href="#">${index}</a></li>
                        <#else >
                            <li class=><a
                                    href="/crm/salesman/listSalesmanInfo?pageNo=${index}&pageSize=${size}">${index}</a>
                            </li>
                        </#if>
                    </#list>
                    <#if currentPage gte list.getTotalPage()>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else >
                        <li><a href="/crm/salesman/listSalesmanInfo?pageNo=${currentPage + 1}&pageSize=${size}">下一页</a>
                        </li>
                    </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</body>
</html>