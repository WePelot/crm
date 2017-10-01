<html>
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
<#--边栏sidebar-->
<#include "../salesman/nav.ftl">
    <style>
        input[type=radio] {
            margin-top: 10px;
            margin-right: 1px;
        }

        div.label-radio label {
            margin-right: 10px;
        }
    </style>
<#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="receptionTime" class="col-sm-2 control-label">接待销售</label>
                            <div class="col-sm-6 column">
                                <input type="text" class="form-control" id="salesmanName" name="salesmanName"
                                       value="${salesmanName}"
                                       readonly="readonly">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="receptionTime" class="col-sm-2 control-label">销售组长</label>
                            <div class="col-sm-6 column">
                                <input type="text" class="form-control" id="salesmanLeaderName"
                                       name="salesmanLeaderName"
                                       value="${salesmanLeaderName}"
                                       readonly="readonly">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="receptionTime" class="col-sm-2 control-label">接待时间</label>
                            <div class="col-sm-6 column">
                                <input type="text" class="form-control" id="receptionTime" name="receptionTime"
                                       readonly="readonly">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="name" class="col-sm-2 control-label">姓名</label>
                            <div class="col-sm-6 column">
                                <input type="text" class="form-control" id="name" name="name"
                                       value='${customerInfo.name!""}'
                                       readonly="readonly">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="phone" class="col-sm-2 control-label">客户电话</label>
                            <div class="col-sm-6 column">
                                <input type="text" class="form-control" id="phone" name="phone"
                                       value="${customerInfo.phone!""}"
                                       readonly="readonly">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="company" class="col-sm-2 control-label">代理公司</label>
                            <div class="col-sm-6 column">
                                <input type="text" class="form-control" id="company" name="company"
                                       value="${customerInfo.company!""}"
                                       readonly="readonly">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">性别</label>
                            <div class="col-sm-6 column">
                            <#if customerInfo.sex == 1>
                                <input type="text" class="form-control" id="sex" name="sex"
                                       value="男"
                                       readonly="readonly">
                            <#else >
                                <input type="text" class="form-control" id="sex" name="sex"
                                       value="女"
                                       readonly="readonly">
                            </#if>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">年龄</label>
                            <div class="col-sm-6 column">
                                <input type="text" class="form-control" id="ageRange" name="ageRange"
                                       value="${customerInfo.ageRange!""}"
                                       readonly="readonly">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">家庭结构</label>
                            <div class="col-sm-6 column">
                                <input type="text" class="form-control" id="familyStructure" name="familyStructure"
                                       value="${customerInfo.familyStructure!""}"
                                       readonly="readonly">
                            </div>

                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">居住区域</label>
                            <div class="col-sm-6 column">
                                <input type="text" class="form-control" id="residentialRegion"
                                       name="residentialRegion"
                                       value="${customerInfo.residentialRegion!""}"
                                       readonly="readonly">
                            </div>

                        </div>


                        <div class="form-group">
                            <label for="residentialDistrict" class="col-sm-2 control-label">居住小区</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="residentialDistrict"
                                       name="residentialDistrict"
                                       value="${customerInfo.residentialDistrict!""}"
                                       readonly="readonly">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">工作区域</label>
                            <div class="col-sm-6 column">
                                <input type="text" class="form-control" id="workingArea" name="workingArea"
                                       value="${customerInfo.workingArea!""}"
                                       readonly="readonly">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">获取渠道</label>
                            <div class="col-sm-6 column">
                                <input type="text" class="form-control" id="msgAccess" name="msgAccess"
                                       value="${customerInfo.msgAccess!""}"
                                       readonly="readonly">
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-sm-2 control-label">单位分类</label>
                            <div class="col-sm-6 column">
                                <input type="text" class="form-control" id="companyType" name="companyType"
                                       value="${customerInfo.companyType!""}"
                                       readonly="readonly">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">职务</label>
                            <div class="col-sm-6 column">
                                <input type="text" class="form-control" id="job" name="job"
                                       value="${customerInfo.job!""}"
                                       readonly="readonly">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">首选产品</label>
                            <div class="col-sm-6 column">
                                <input type="text" class="form-control" id="preferredProduct"
                                       name="preferredProduct"
                                       value="${customerInfo.preferredProduct!""}"
                                       readonly="readonly">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">首选面积</label>
                            <div class="col-sm-6 column">
                                <input type="text" class="form-control" id="preferredArea" name="preferredArea"
                                       value="${customerInfo.preferredArea!""}"
                                       readonly="readonly">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">意向单价</label>
                            <div class="col-sm-6 column">
                                <input type="text" class="form-control" id="psychologicalUnitPrice"
                                       name="psychologicalUnitPrice"
                                       value="${customerInfo.psychologicalUnitPrice!""}"
                                       readonly="readonly">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">意向总价</label>
                            <div class="col-sm-6 column">
                                <input type="text" class="form-control" id="psychologicalTotalPrice"
                                       name="psychologicalTotalPrice"
                                       value="${customerInfo.psychologicalTotalPrice!""}"
                                       readonly="readonly">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">购房动机</label>
                            <div class="col-sm-6 column">
                                <input type="text" class="form-control" id="reason" name="reason"
                                       value="${customerInfo.reason!""}"
                                       readonly="readonly">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">付款方式</label>
                            <div class="col-sm-6 column">
                                <input type="text" class="form-control" id="payWay" name="payWay"
                                       value="${customerInfo.payWay!""}"
                                       readonly="readonly">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">出行工具</label>
                            <div class="col-sm-6 column">
                                <input type="text" class="form-control" id="tripTools" name="tripTools"
                                       value="${customerInfo.tripTools!""}"
                                       readonly="readonly">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">关键因素</label>
                            <div class="col-sm-6 column">
                                <input type="text" class="form-control" id="keyFactor" name="keyFactor"
                                       value="${customerInfo.keyFactor!""}"
                                       readonly="readonly">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">置业次数</label>
                            <div class="col-sm-6 column">
                                <input type="text" class="form-control" id="askingTime" name="askingTime"
                                       value="${customerInfo.askingTime!""}"
                                       readonly="readonly">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">贷款次数</label>
                            <div class="col-sm-6 column">
                                <input type="text" class="form-control" id="loanTime" name="loanTime"
                                       value="${customerInfo.loanTime!""}"
                                       readonly="readonly">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">客户意愿</label>
                            <div class="col-sm-6 column">
                                <input type="text" class="form-control" id="willingness" name="willingness"
                                       value="${customerInfo.willingness!""}"
                                       readonly="readonly">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">客户描述</label>
                                <textarea name="desc" id="desc" maxlength="100" class="my_textarea" disabled>
                                <#--${customerInfo.desc!""}-->
                                </textarea>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <script>
        var receptionTime = "${customerInfo.receptionTime}";
        $("#receptionTime").val(receptionTime.substring(0, 10));
        var descValue = "${customerInfo.desc!""}".mytrim();
        $("#desc").text(descValue);

    </script>
</body>
</html>