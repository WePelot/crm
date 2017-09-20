<html>
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#--边栏sidebar-->
    <#include "../admin/nav.ftl">

    <#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>用户名</th>
                            <th>密码</th>
                            <th>姓名</th>
                            <th>手机</th>
                            <th>地址</th>
                            <th>身份</th>
                            <th>创建时间</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list list as dto>
                        <tr>
                            <td>${list.username}</td>
                            <td>${list.password}</td>
                            <td>${list.name}</td>
                            <td>${list.phone}</td>
                            <td>${list.address}</td>
                            <td>${list.getOrderStatusEnum().msg}</td>
                            <td>${list.createTime}</td>
                            <td><a href="/admin/salesman/detail?orderId=${dto.orderId}">详情</a></td>
                            <td>
                                <#if dto.getOrderStatusEnum().msg == "新订单">
                                    <a href="/seller/order/cancel?orderId=${dto.orderId}">删除</a>
                                </#if>
                            </td>
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
                        <li><a href="/seller/order/list?page=${currentPage -1}&size=${size}">上一页</a></li>
                    </#if>
                    <#list 1..list.getTotalPages() as index>
                        <#if currentPage == index>
                            <li class="disabled"><a href="#">${index}</a></li>
                        <#else >
                            <li class=><a href="/seller/order/list?page=${index}&size=${size}">${index}</a></li>
                        </#if>
                    </#list>
                    <#if currentPage gte list.getTotalPages()>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else >
                        <li><a href="/seller/order/list?page=${currentPage + 1}&size=${size}">下一页</a></li>
                    </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</body>
</html>