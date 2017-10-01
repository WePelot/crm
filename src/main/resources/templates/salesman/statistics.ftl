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
                            <th>销售组长</th>
                            <th>销售人数</th>
                            <th>客户人数</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#if list?exists>
                            <#list list as dto>
                            <tr>
                                <td>${dto.salesmanLeaderName}</td>
                                <td>${dto.salesmanCount}</td>
                                <td>${dto.customerCount}</td>
                            </tr>
                            </#list>
                        </#if>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>