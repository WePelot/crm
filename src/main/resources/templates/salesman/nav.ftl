<script>
    //给url增加时间戳，防止页面304浏览器缓存
    function setUrlWithTime(url) {
        if (url.indexOf("?") != -1) {
            url += "&time=" + new Date().getTime();
        } else {
            url += "?time=" + new Date().getTime();
        }

        window.location.href = url;
    }
</script>

<nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
    <ul class="nav sidebar-nav">
        <li class="sidebar-brand">
            <a href="#">
                CRM管理系统
            </a>
        </li>
        <li>
            <a href="#" onclick="setUrlWithTime('/crm/salesman/listCustomerInfo?pageNo=1&pageSize=20')"><i
                    class=" fa fa-fw fa-list-alt"></i>客户信息列表</a>
        </li>

    <#if identity == 0>
        <li>
            <a href="#" onclick="setUrlWithTime('/crm/salesman/toAddCustomer')"><i class=" fa fa-fw fa-list-alt"></i>新增客戶信息</a>
        </li>
    </#if>

    <#if identity != 0>
        <li>
            <a href="#" onclick="setUrlWithTime('/crm/salesman/listSalesmanInfo?pageNo=1&pageSize=20')"><i
                    class="fa fa-fw fa-list-alt"></i>销售人员列表</a>
        </li>

        <li>
            <a href="#" onclick="setUrlWithTime('/crm/salesman/toAddSalesman')"><i class=" fa fa-fw fa-list-alt"></i>新增销售人员</a>
        </li>
    </#if>

        <li>
            <a href="#" onclick="setUrlWithTime('/crm/salesman/detail')"><i class=" fa fa-fw fa-list-alt"></i>个人信息查询</a>
        </li>

        <li>
            <a href="#" onclick="setUrlWithTime('/crm/salesman/toChgMsg')"><i
                    class=" fa fa-fw fa-list-alt"></i>个人信息修改</a>
        </li>

        <li>
            <a href="#" onclick="setUrlWithTime('/crm/salesman/toChgPwd')"><i class=" fa fa-fw fa-list-alt"></i>密码修改</a>
        </li>

    <#if identity == 2>
        <li>
            <a href="#" onclick="setUrlWithTime('/crm/salesman/statistics')"><i class=" fa fa-fw fa-list-alt"></i>统计</a>
        </li>
    </#if>

        <li>
            <a href="#" onclick="setUrlWithTime('/crm/user/logout')"><i class="fa fa-fw fa-list-alt"></i> 登出</a>
        </li>

    </ul>
</nav>