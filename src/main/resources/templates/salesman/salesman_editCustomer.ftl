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

        textarea {
            width: 50%;
            height: 90px;
            color: #555;
            border: 1px solid #ccc;
            border-radius: 4px;
            resize: none;
        }
    </style>
<#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form class="form-horizontal" role="form" action="/salesman/saveCustomerInfo" method="post"
                          onsubmit="return checkCustomerForm();">
                        <input type="hidden" class="form-control" name="id" readonly="readonly"
                               value="${customerInfo.id!""}">
                        <div class="form-group">
                            <label for="receptionTime" class="col-sm-2 control-label">接待销售</label>
                            <div class="col-sm-6 column">
                                <select name="salesmanId" class="form-control">
                                <#list list as dto>
                                    <#if currentId == dto.id>
                                        <option value="${dto.id}" selected="selected">${dto.name}</option>
                                    <#else >
                                        <option value="${dto.id}">${dto.name}</option>
                                    </#if>
                                </#list>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="receptionTime" class="col-sm-2 control-label">接待时间</label>
                            <div class="col-sm-6 column">
                                <input type="text" class="form-control" id="receptionTime" name="receptionTime"
                                       readonly="readonly" value="${customerInfo.receptionTime!""}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="name" class="col-sm-2 control-label">姓名</label>
                            <div class="col-sm-6 column">
                                <input type="text" class="form-control" id="name" name="name"
                                       value="${customerInfo.name}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="phone" class="col-sm-2 control-label">客户电话</label>
                            <div class="col-sm-6 column">
                                <input type="text" class="form-control" id="phone" name="phone"
                                       value="${customerInfo.phone!""}"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="company" class="col-sm-2 control-label">代理公司</label>
                            <div class="col-sm-6 column">
                                <input type="text" class="form-control" id="company" name="company"
                                       value="${customerInfo.company!""}"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">性别</label>
                                <label>
                                    <input type="radio" name="sex" value="1"><span>男</span>
                                </label>
                                <label>
                                    <input type="radio" name="sex" value="2"><span>女</span>
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">年龄</label>
                                <label>
                                    <input type="radio" name="ageRange" value="25以下"><span>25以下</span>
                                </label>
                                <label>
                                    <input type="radio" name="ageRange" value="26-30"><span>26-30</span>
                                </label>
                                <label>
                                    <input type="radio" name="ageRange" value="31-35"><span>31-35</span>
                                </label>
                                <label>
                                    <input type="radio" name="ageRange" value="36-40"><span>36-40</span>
                                </label>
                                <label>
                                    <input type="radio" name="ageRange" value="40-50"><span>40-50</span>
                                </label>
                                <label>
                                    <input type="radio" name="ageRange" value="50-60"><span>50-60</span>
                                </label>
                                <label>
                                    <input type="radio" name="ageRange" value="其他"><span>其他</span>
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">家庭结构</label>
                                <label>
                                    <input type="radio" name="familyStructure" value="单身"><span>单身</span>
                                </label>
                                <label>
                                    <input type="radio" name="familyStructure" value="二人世界"><span>二人世界</span>
                                </label>
                                <label>
                                    <input type="radio" name="familyStructure" value="三口之家"><span>三口之家</span>
                                </label>
                                <label>
                                    <input type="radio" name="familyStructure" value="两代同堂"><span>两代同堂</span>
                                </label>
                                <label>
                                    <input type="radio" name="familyStructure" value="三代同堂"><span>三代同堂</span>
                                </label>
                                <label>
                                    <input type="radio" name="familyStructure" value="其他"><span>其他</span>
                                </label>
                            </div>

                        </div>

                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">居住区域</label>
                                <label>
                                    <input type="radio" name="residentialRegion" value="中心城区"><span>中心城区</span>
                                </label>
                                <label>
                                    <input type="radio" name="residentialRegion" value="南湖新区"><span>南湖新区</span>
                                </label>
                                <label>
                                    <input type="radio" name="residentialRegion" value="秀洲区"><span>秀洲区</span>
                                </label>
                                <label>
                                    <input type="radio" name="residentialRegion" value="经济开发区"><span>经济开发区</span>
                                </label>
                                <label>
                                    <input type="radio" name="residentialRegion" value="城北城东"><span>城北城东</span>
                                </label>
                            </div>

                        </div>


                        <div class="form-group">
                            <label for="residentialDistrict" class="col-sm-2 control-label">居住小区</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="residentialDistrict"
                                       name="residentialDistrict" value="${customerInfo.residentialDistrict!""}"/>
                            </div>
                        </div>

                        <div class=" form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">工作区域</label>
                                <label>
                                    <input type="radio" name="workingArea" value="科技城"><span>科技城</span>
                                </label>
                                <label>
                                    <input type="radio" name="workingArea" value="南湖新区"><span>南湖新区</span>
                                </label>
                                <label>
                                    <input type="radio" name="workingArea" value="国际商务园"><span>国际商务园</span>
                                </label>
                                <label>
                                    <input type="radio" name="workingArea" value="城东"><span>城东</span>
                                </label>
                                <label>
                                    <input type="radio" name="workingArea" value="城南"><span>城南</span>
                                </label>
                                <label>
                                    <input type="radio" name="workingArea" value="城北"><span>城北</span>
                                </label>
                                <label>
                                    <input type="radio" name="workingArea" value="老城区"><span>老城区</span>
                                </label>
                                <label>
                                    <input type="radio" name="workingArea" value="秀湖区"><span>秀湖区</span>
                                </label>
                                <label>
                                    <input type="radio" name="workingArea" value="大桥镇"><span>大桥镇</span>
                                </label>
                                <label>
                                    <input type="radio" name="workingArea" value="新风镇"><span>新风镇</span>
                                </label>
                                <label>
                                    <input type="radio" name="workingArea" value="风桥镇"><span>风桥镇</span>
                                </label>
                                <label>
                                    <input type="radio" name="workingArea" value="余新镇"><span>余新镇</span>
                                </label>
                                <label>
                                    <input type="radio" name="workingArea" value="七星镇"><span>七星镇</span>
                                </label>
                                <label>
                                    <input type="radio" name="workingArea" value="嘉善"><span>嘉善</span>
                                </label>
                                <label>
                                    <input type="radio" name="workingArea" value="上海"><span>上海</span>
                                </label>
                                <label>
                                    <input type="radio" name="workingArea" value="平湖"><span>平湖</span>
                                </label>
                                <label>
                                    <input type="radio" name="workingArea" value="海盐"><span>海盐</span>
                                </label>
                                <label>
                                    <input type="radio" name="workingArea" value="其他"><span>其他</span>
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">工作区域</label>
                                <label>
                                    <input type="radio" name="msgAccess" value="户外大牌"><span>户外大牌</span>
                                </label>
                                <label>
                                    <input type="radio" name="msgAccess" value="户外高炮"><span>户外高炮</span>
                                </label>
                                <label>
                                    <input type="radio" name="msgAccess" value="工地现场"><span>工地现场</span>
                                </label>
                                <label>
                                    <input type="radio" name="msgAccess" value="阵地包装"><span>阵地包装</span>
                                </label>
                                <label>
                                    <input type="radio" name="msgAccess" value="户外道旗"><span>户外道旗</span>
                                </label>
                                <label>
                                    <input type="radio" name="msgAccess" value="电视"><span>电视</span>
                                </label>
                                <label>
                                    <input type="radio" name="msgAccess" value="电台"><span>电台</span>
                                </label>
                                <label>
                                    <input type="radio" name="msgAccess" value="报纸"><span>报纸</span>
                                </label>
                                <label>
                                    <input type="radio" name="msgAccess" value="派单"><span>派单</span>
                                </label>
                                <label>
                                    <input type="radio" name="msgAccess" value="房展"><span>房展</span>
                                </label>
                                <label>
                                    <input type="radio" name="msgAccess" value="巡展"><span>巡展</span>
                                </label>
                                <label>
                                    <input type="radio" name="msgAccess" value="微信圈"><span>微信圈</span>
                                </label>
                                <label>
                                    <input type="radio" name="msgAccess" value="渠道"><span>渠道</span>
                                </label>
                                <label>
                                    <input type="radio" name="msgAccess" value="网络"><span>网络</span>
                                </label>
                                <label>
                                    <input type="radio" name="msgAccess" value="其他"><span>其他</span>
                                </label>
                            </div>

                        </div>


                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">单位分类</label>
                                <label>
                                    <input type="radio" name="companyType" value="国企"><span>国企</span>
                                </label>
                                <label>
                                    <input type="radio" name="companyType" value="政府机关"><span>政府机关</span>
                                </label>
                                <label>
                                    <input type="radio" name="companyType" value="事业单位"><span>事业单位</span>
                                </label>
                                <label>
                                    <input type="radio" name="companyType" value="金融业"><span>金融业</span>
                                </label>
                                <label>
                                    <input type="radio" name="companyType" value="服务业"><span>服务业</span>
                                </label>
                                <label>
                                    <input type="radio" name="companyType" value="企业员工"><span>企业员工</span>
                                </label>
                                <label>
                                    <input type="radio" name="companyType" value="企业法人"><span>企业法人</span>
                                </label>
                                <label>
                                    <input type="radio" name="companyType" value="房地产"><span>房地产</span>
                                </label>
                                <label>
                                    <input type="radio" name="companyType" value="电信电力"><span>电信电力</span>
                                </label>
                                <label>
                                    <input type="radio" name="companyType" value="设计装潢"><span>设计装潢</span>
                                </label>
                                <label>
                                    <input type="radio" name="companyType" value="媒体业"><span>媒体业</span>
                                </label>
                                <label>
                                    <input type="radio" name="companyType" value="交通运输物流"><span>交通运输物流</span>
                                </label>
                                <label>
                                    <input type="radio" name="companyType" value="医疗医药"><span>医疗医药</span>
                                </label>
                                <label>
                                    <input type="radio" name="companyType" value="其他"><span>其他</span>
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">职务</label>
                                <label>
                                    <input type="radio" name="job" value="法人"><span>法人</span>
                                </label>
                                <label>
                                    <input type="radio" name="job" value="总经理"><span>总经理</span>
                                </label>
                                <label>
                                    <input type="radio" name="job" value="主管"><span>主管</span>
                                </label>
                                <label>
                                    <input type="radio" name="job" value="部门经理"><span>部门经理</span>
                                </label>
                                <label>
                                    <input type="radio" name="job" value="医生"><span>医生</span>
                                </label>
                                <label>
                                    <input type="radio" name="job" value="老师</"><span>老师</span>
                                </label>
                                <label>
                                    <input type="radio" name="job" value="职员"><span>职员</span>
                                </label>
                                <label>
                                    <input type="radio" name="job" value="其他"><span>其他</span>
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">首选产品</label>
                                <label>
                                    <input type="radio" name="preferredProduct" value="高层"><span>高层</span>
                                </label>
                                <label>
                                    <input type="radio" name="preferredProduct" value="洋房"><span>洋房</span>
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">首选面积</label>
                                <label>
                                    <input type="radio" name="preferredArea" value="<90"><span><90</span>
                                </label>
                                <label>
                                    <input type="radio" name="preferredArea" value="90-105"><span>90-105</span>
                                </label>
                                <label>
                                    <input type="radio" name="preferredArea" value="105-120"><span>105-120</span>
                                </label>
                                <label>
                                    <input type="radio" name="preferredArea" value="120-140"><span>120-140</span>
                                </label>
                                <label>
                                    <input type="radio" name="preferredArea" value="140-160"><span>140-160</span>
                                </label>
                                <label>
                                    <input type="radio" name="preferredArea" value="160万以上"><span>160万以上</span>
                                </label>
                                <label>
                                    <input type="radio" name="preferredArea" value="别墅"><span>别墅</span>
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">意向单价</label>
                                <label>
                                    <input type="radio" name="psychologicalUnitPrice"
                                           value="14000以下"><span>14000以下</span>
                                </label>
                                <label>
                                    <input type="radio" name="psychologicalUnitPrice" value="14000-15000"><span>14000-15000</span>
                                </label>
                                <label>
                                    <input type="radio" name="psychologicalUnitPrice" value="15000-16000"><span>15000-16000</span>
                                </label>
                                <label>
                                    <input type="radio" name="psychologicalUnitPrice"
                                           value="16000以上"><span>16000以上</span>
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">意向总价</label>
                                <label>
                                    <input type="radio" name="psychologicalTotalPrice"
                                           value="130万以内"><span>130万以内</span>
                                </label>
                                <label>
                                    <input type="radio" name="psychologicalTotalPrice"
                                           value="130-140万"><span>130-140万</span>
                                </label>
                                <label>
                                    <input type="radio" name="psychologicalTotalPrice"
                                           value="140-150"><span>140-150万</span>
                                </label>
                                <label>
                                    <input type="radio" name="psychologicalTotalPrice"
                                           value="150-160万"><span>150-160万</span>
                                </label>
                                <label>
                                    <input type="radio" name="psychologicalTotalPrice"
                                           value="160-170万"><span>160-170万</span>
                                </label>
                                <label>
                                    <input type="radio" name="psychologicalTotalPrice"
                                           value="170-180万"><span>170-180万</span>
                                </label>
                                <label>
                                    <input type="radio" name="psychologicalTotalPrice"
                                           value="180-190"><span>180-190万</span>
                                </label>
                                <label>
                                    <input type="radio" name="psychologicalTotalPrice"
                                           value="190-200万"><span>190-200万</span>
                                </label>
                                <label>
                                    <input type="radio" name="psychologicalTotalPrice"
                                           value="200万以上"><span>200万以上</span>
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">购房动机</label>
                                <label>
                                    <input type="radio" name="reason" value="自住"><span>自住</span>
                                </label>
                                <label>
                                    <input type="radio" name="reason" value="投资"><span>投资</span>
                                </label>
                                <label>
                                    <input type="radio" name="reason" value="为子女"><span>为子女</span>
                                </label>
                                <label>
                                    <input type="radio" name="reason" value="为父母"><span>为父母</span>
                                </label>
                                <label>
                                    <input type="radio" name="reason" value="婚房"><span>婚房</span>
                                </label>
                                <label>
                                    <input type="radio" name="reason" value="其他"><span>其他</span>
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">付款方式</label>
                                <label>
                                    <input type="radio" name="payWay" value="一次性付款"><span>一次性付款</span>
                                </label>
                                <label>
                                    <input type="radio" name="payWay" value="银行按揭(30%)"><span>银行按揭(30%)</span>
                                </label>
                                <label>
                                    <input type="radio" name="payWay" value="银行按揭(50%)"><span>银行按揭(50%)</span>
                                </label>
                                <label>
                                    <input type="radio" name="payWay" value="分期"><span>分期</span>
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">出行工具</label>
                                <label>
                                    <input type="radio" name="tripTools" value="自行车"><span>自行车</span>
                                </label>
                                <label>
                                    <input type="radio" name="tripTools" value="助动车"><span>助动车</span>
                                </label>
                                <label>
                                    <input type="radio" name="tripTools" value="公交车"><span>公交车</span>
                                </label>
                                <label>
                                    <input type="radio" name="tripTools" value="私家车"><span>私家车</span>
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">关键因素</label>
                                <label>
                                    <input type="radio" name="keyFactor" value="价格"><span>价格</span>
                                </label>
                                <label>
                                    <input type="radio" name="keyFactor" value="地段"><span>地段</span>
                                </label>
                                <label>
                                    <input type="radio" name="keyFactor" value="交通"><span>交通</span>
                                </label>
                                <label>
                                    <input type="radio" name="keyFactor" value="户型面积"><span>户型面积</span>
                                </label>
                                <label>
                                    <input type="radio" name="keyFactor" value="开发商名片"><span>开发商名片</span>
                                </label>
                                <label>
                                    <input type="radio" name="keyFactor" value="物业服务"><span>物业服务</span>
                                </label>
                                <label>
                                    <input type="radio" name="keyFactor" value="社区配套"><span>社区配套</span>
                                </label>
                                <label>
                                    <input type="radio" name="keyFactor" value="景观环境"><span>景观环境</span>
                                </label>
                                <label>
                                    <input type="radio" name="keyFactor" value="学区"><span>学区</span>
                                </label>
                                <label>
                                    <input type="radio" name="keyFactor" value="升值潜力"><span>升值潜力</span>
                                </label>
                                <label>
                                    <input type="radio" name="keyFactor" value="其他"><span>其他</span>
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">置业次数</label>
                                <label>
                                    <input type="radio" name="askingTime" value="首次置业"><span>首次置业</span>
                                </label>
                                <label>
                                    <input type="radio" name="askingTime" value="非首次置业"><span>非首次置业</span>
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">贷款次数</label>
                                <label>
                                    <input type="radio" name="loanTime" value="0次"><span>0次</span>
                                </label>
                                <label>
                                    <input type="radio" name="loanTime" value="1次"><span>1次</span>
                                </label>
                                <label>
                                    <input type="radio" name="loanTime" value="2次"><span>2次</span>
                                </label>
                                <label>
                                    <input type="radio" name="loanTime" value="3次及以上"><span>3次及以上</span>
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">客户意愿</label>
                                <label>
                                    <input type="radio" name="willingness" value="意向强烈"><span>意向强烈</span>
                                </label>
                                <label>
                                    <input type="radio" name="willingness" value="可能回头"><span>可能回头</span>
                                </label>
                                <label>
                                    <input type="radio" name="willingness" value="意愿平平"><span>意愿平平</span>
                                </label>
                                <label>
                                    <input type="radio" name="willingness" value="观光调研"><span>观光调研</span>
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">客户描述</label>
                                <textarea name="desc" maxlength="100">
                                ${customerInfo.desc!""}
                                    </textarea>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default">添加</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <script>

        $('#receptionTime').datetimepicker({
            format: 'yyyy-mm-dd', /*此属性是显示顺序，还有显示顺序是mm-dd-yyyy*/
            minView: "month", //选择日期后，不会再跳转去选择时分秒
            language: 'zh-CN',
            todayBtn: 1,
            autoclose: 1,
            language: 'zh-CN'
        });
        $("input[name='receptionTime']").val("${customerInfo.receptionTime}".substring(0, 10));
        $("input[name='sex'][value='${customerInfo.sex!""}']").attr("checked", true);
        $("input[name='ageRange'][value='${customerInfo.ageRange!""}']").attr("checked", true);
        $("input[name='familyStructure'][value='${customerInfo.familyStructure!""}']").attr("checked", true);
        $("input[name='residentialRegion'][value='${customerInfo.residentialRegion!""}']").attr("checked", true);
        $("input[name='workingArea'][value='${customerInfo.workingArea!""}']").attr("checked", true);
        $("input[name='companyType'][value='${customerInfo.companyType!""}']").attr("checked", true);
        $("input[name='job'][value='${customerInfo.job!""}']").attr("checked", true);
        $("input[name='preferredProduct'][value='${customerInfo.preferredProduct!""}']").attr("checked", true);
        $("input[name='preferredArea'][value='${customerInfo.preferredArea!""}']").attr("checked", true);
        $("input[name='psychologicalUnitPrice'][value='${customerInfo.psychologicalUnitPrice!""}']").attr("checked", true);
        $("input[name='psychologicalTotalPrice'][value='${customerInfo.psychologicalTotalPrice!""}']").attr("checked", true);
        $("input[name='reason'][value='${customerInfo.reason!""}']").attr("checked", true);
        $("input[name='payWay'][value='${customerInfo.payWay!""}']").attr("checked", true);
        $("input[name='tripTools'][value='${customerInfo.tripTools!""}']").attr("checked", true);
        $("input[name='keyFactor'][value='${customerInfo.keyFactor!""}']").attr("checked", true);
        $("input[name='askingTime'][value='${customerInfo.askingTime!""}']").attr("checked", true);
        $("input[name='loanTime'][value='${customerInfo.loanTime!""}']").attr("checked", true);
        $("input[name='willingness'][value='${customerInfo.willingness!""}']").attr("checked", true);

        $('form').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                salesmanId: {
                    validators: {
                        notEmpty: {
                            message: '置业顾问不能为空'
                        }
                    }
                },
                name: {
                    validators: {
                        notEmpty: {
                            message: '客户姓名不能为空'
                        },
                        stringLength: {
                            min: 1,
                            max: 18,
                            message: '姓名长度必须在1到18位之间'
                        }
                    }
                },
                phone: {
                    validators: {
                        notEmpty: {
                            message: '手机号码不能为空'
                        },
                        regexp: {
                            regexp: /^1(3|4|5|7|8)\d{9}$/,
                            message: '手机号码格式不正确'
                        }
                    }
                }
            }
        });

        //获取初始手机号码，如果手机号码有变动，则进行校验
        var oldPhone = "${customerInfo.phone!""}";
        function checkCustomerForm() {
            var checkResult = false;
            var currentPhone = $("input[name='phone']").val();
            if (currentPhone != oldPhone) {
                //获取当前表单状态
                var flag = $("form").data("bootstrapValidator").isValid();
                if (flag) {
                    //获取手机号码
                    var phone = $("#phone").val();
                    //发送ajax请求
                    $.ajax({
                        url: '/salesman/checkCustomerInfoByPhone',
                        async: false,//同步，会阻塞操作
                        type: 'GET',//PUT DELETE POST
                        data: {"phone": phone},
                        success: function (result) {
                            if (result.code == 0) {
                                checkResult = true;
                            } else {
                                alert(result.msg);
                            }
                        }
                    })
                }
            } else {
                checkResult = true;
            }

            return checkResult;
        }
    </script>
</body>
</html>