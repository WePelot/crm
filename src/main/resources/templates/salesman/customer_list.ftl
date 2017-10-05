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
                    <form class="form-horizontal" role="form" action="/crm/salesman/listCustomerInfo" method="get">
                        <div class="form-group">
                            <label for="name" class="col-sm-2 control-label" p>客户姓名</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="name" name="name" "/>
                            </div>
                            <div class="col-sm-2">
                                <button type="submit" class="btn btn-primary">查询</button>
                            </div>
                        </div>
                    </form>


                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>客户姓名</th>
                            <th>客户性别</th>
                            <th>客户电话</th>
                            <th>接待销售</th>
                            <th>销售组长</th>

                        <#if identity==0>
                            <th colspan="3">客户信息</th>
                            <th colspan="2">客户追踪</th>
                        <#elseif identity==1>
                            <th colspan="2">客户信息</th>
                            <th colspan="1">客户追踪</th>
                        <#else >
                            <th colspan="1">客户内容</th>
                            <th colspan="1">客户追踪</th>
                        </#if>

                        </tr>
                        </thead>
                        <tbody>
                        <#if list.data?exists>
                            <#list list.data as dto>
                            <tr>
                                <td>${dto.name}</td>
                                <#if dto.sex==1>
                                    <td>男</td>
                                <#else >
                                    <td>女</td>
                                </#if>

                                <td>${dto.phone}</td>
                                <td>${dto.salesmanName}</td>
                                <td>${dto.salesmanLeaderName}</td>
                                <#if identity==0>
                                    <td><a href="/crm/salesman/customerInfoDetail?id=${dto.id}">查看</a></td>
                                    <td><a href="/crm/salesman/toEditCustomer?id=${dto.id}">编辑</a></td>
                                    <td><a href="/crm/salesman/delCustomerInfo?id=${dto.id}">信息删除</a></td>
                                    <td><a href="/crm/salesman/listCustomerTrackInfo?customerInfoId=${dto.id}">详情</a>
                                    </td>
                                    <td><a href="/crm/salesman/toAddCustomerTrackInfo?customerInfoId=${dto.id}">新增</a>
                                    </td>
                                <#elseif identity==1>
                                    <td><a href="/crm/salesman/customerInfoDetail?id=${dto.id}">查看</a></td>
                                    <td><a href="/crm/salesman/toEditCustomer?id=${dto.id}">编辑</a></td>
                                    <td><a href="/crm/salesman/listCustomerTrackInfo?customerInfoId=${dto.id}">详情</a>
                                    </td>
                                <#else >
                                    <td><a href="/crm/salesman/customerInfoDetail?id=${dto.id}">查看</a></td>
                                    <td><a href="/crm/salesman/listCustomerTrackInfo?customerInfoId=${dto.id}">详情</a>
                                    </td>
                                </#if>

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
                        <li>
                            <a href="/crm/salesman/list?pageNo=${currentPage -1}&pageSize=${size}&salesmanId=${salesmanId}">上一页</a>
                        </li>
                    </#if>
                    <#list 1..list.getTotalPage() as index>
                        <#if currentPage == index>
                            <li class="disabled"><a href="#">${index}</a></li>
                        <#else >
                            <li class=><a
                                    href="/crm/salesman/list?pageNo=${index}&pageSize=${size}&salesmanId=${salesmanId}">${index}</a>
                            </li>
                        </#if>
                    </#list>
                    <#if currentPage gte list.getTotalPage()>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else >
                        <li>
                            <a href="/crm/salesman/list?pageNo=${currentPage + 1}&pageSize=${size}&salesmanId=${salesmanId}">下一页</a>
                        </li>
                    </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</body>
</html>