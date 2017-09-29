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
                            <th>客户姓名</th>
                            <th>客户性别</th>
                            <th>客户电话</th>
                            <th>接待销售</th>
                            <th colspan="4">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#if list.data?exists>
                            <#list list.data as dto>
                            <tr>
                                <td>${dto.name}</td>
                                <td>${dto.sex}</td>
                                <td>${dto.phone}</td>
                                <td>${dto.salesmanName}</td>
                                <td><a href="/salesman/customerInfoDetail?id=${dto.id}">客户详情</a></td>
                                <td><a href="/salesman/toEditCustomer?id=${dto.id}">编辑</a></td>
                                <td><a href="/salesman/delCustomerInfo?id=${dto.id}">信息删除</a></td>
                                <td><a href="/salesman/delCustomerInfo?id=${dto.id}">客户信息追踪</a></td>
                            </tr>
                            </#list>
                        </#if>
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
                        <li><a href="/salesman/list?pageNo=${currentPage + 1}&pageSize=${size}">下一页</a></li>
                    </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</body>
</html>