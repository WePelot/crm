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
            <#if isMySelf==1>
                <div class="col-md-12 column" style="margin-bottom: 15px;">
                    <a class="btn btn-default" href="/salesman/toAddCustomerTrackInfo?customerInfoId=${customerInfoId}">客户追踪信息添加</a>
                </div>
            </#if>
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>客户姓名</th>
                            <th>录入时间</th>
                            <th>具体事项</th>
                        <#if isMySelf==1>
                            <th colspan="1">操作</th>
                        </#if>
                        </tr>
                        </thead>
                        <tbody>
                        <#if list.data?exists>
                            <#list list.data as dto>
                            <tr>
                                <td>${dto.customerInfoName}</td>
                                <td>${dto.createTime}</td>
                                <td>${dto.desc}</td>
                                <#if isMySelf==1>
                                    <td>
                                        <a href="/salesman/delCustomerTrackInfo?customerTrackInfoId=${dto.id}&customerInfoId=${dto.customerInfoId}">删除</a>
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
                            <a href="/salesman/listCustomerTrackInfo?pageNo=${currentPage -1}&pageSize=${size}&salesmanId=${salesmanId}">上一页</a>
                        </li>
                    </#if>
                    <#list 1..list.getTotalPage() as index>
                        <#if currentPage == index>
                            <li class="disabled"><a href="#">${index}</a></li>
                        <#else >
                            <li class=><a
                                    href="/salesman/listCustomerTrackInfo?pageNo=${index}&pageSize=${size}">${index}</a>
                            </li>
                        </#if>
                    </#list>
                    <#if currentPage gte list.getTotalPage()>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else >
                        <li><a href="/salesman/listCustomerTrackInfo?pageNo=${currentPage + 1}&pageSize=${size}">下一页</a>
                        </li>
                    </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</body>
</html>