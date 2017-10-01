<nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
    <ul class="nav sidebar-nav">
        <li class="sidebar-brand">
            <a href="#">
                CRM管理系统
            </a>
        </li>
        <li>
            <a href="/salesman/listCustomerInfo"><i class=" fa fa-fw fa-list-alt"></i>客户信息列表</a>
        </li>

    <#if identity == 0>
        <li>
            <a href="/salesman/toAddCustomer"><i class=" fa fa-fw fa-list-alt"></i>新增客戶信息</a>
        </li>
    </#if>

    <#if identity != 0>
        <li>
            <a href="/salesman/listSalesmanInfo?pageNo=1&pageSize=20"><i class="fa fa-fw fa-list-alt"></i>销售人员列表</a>
        </li>

        <li>
            <a href="/salesman/toAddSalesman"><i class=" fa fa-fw fa-list-alt"></i>新增销售人员</a>
        </li>
    </#if>

        <li>
            <a href="/salesman/detail"><i class=" fa fa-fw fa-list-alt"></i>个人信息查询</a>
        </li>

        <li>
            <a href="/salesman/toChgMsg"><i class=" fa fa-fw fa-list-alt"></i>个人信息修改</a>
        </li>

        <li>
            <a href="/salesman/toChgPwd"><i class=" fa fa-fw fa-list-alt"></i>密码修改</a>
        </li>

    <#if identity == 2>
        <li>
            <a href="/salesman/statistics"><i class=" fa fa-fw fa-list-alt"></i>统计</a>
        </li>
    </#if>

        <li>
            <a href="/user/logout"><i class="fa fa-fw fa-list-alt"></i> 登出</a>
        </li>

    </ul>
</nav>