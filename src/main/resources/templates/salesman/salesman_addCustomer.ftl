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
            width: 60%;
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
                    <form class="form-horizontal" role="form" action="/salesman/add" method="post"
                          onsubmit="return checkCustomerForm();">
                        <div class="form-group">
                            <label for="receptionTime" class="col-sm-2 control-label">置业顾问</label>
                            <div class="col-sm-6 column">
                                <input type="text" class="form-control" id="salesmanName" name="salesmanName"
                                       value="${salesmanName}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="receptionTime" class="col-sm-2 control-label">接待时间</label>
                            <div class="col-sm-6 column">
                                <input type="text" class="form-control" id="receptionTime"
                                       readonly="readonly">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="name" class="col-sm-2 control-label">姓名</label>
                            <div class="col-sm-6 column">
                                <input type="text" class="form-control" id="name" name="name">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="phone" class="col-sm-2 control-label">客户电话</label>
                            <div class="col-sm-6 column">
                                <input type="text" class="form-control" id="phone" name="phone"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="company" class="col-sm-2 control-label">代理公司</label>
                            <div class="col-sm-6 column">
                                <input type="text" class="form-control" id="company" name="company"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">性别</label>
                                <label>
                                    <input type="radio" name="sex" checked="checked"><span>男</span>
                                </label>
                                <label>
                                    <input type="radio" name="sex"><span>女</span>
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">年龄</label>
                                <label>
                                    <input type="radio" name="ageRange"><span>25以下</span>
                                </label>
                                <label>
                                    <input type="radio" name="ageRange"><span>26-30</span>
                                </label>
                                <label>
                                    <input type="radio" name="ageRange"><span>31-35</span>
                                </label>
                                <label>
                                    <input type="radio" name="ageRange"><span>36-40</span>
                                </label>
                                <label>
                                    <input type="radio" name="ageRange"><span>40-50</span>
                                </label>
                                <label>
                                    <input type="radio" name="ageRange"><span>50-60</span>
                                </label>
                                <label>
                                    <input type="radio" name="ageRange"><span>其他</span>
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">家庭结构</label>
                                <label>
                                    <input type="radio" name="familyStructure"><span>单身</span>
                                </label>
                                <label>
                                    <input type="radio" name="familyStructure"><span>二人世界</span>
                                </label>
                                <label>
                                    <input type="radio" name="familyStructure"><span>三口之家</span>
                                </label>
                                <label>
                                    <input type="radio" name="familyStructure"><span>两代同堂</span>
                                </label>
                                <label>
                                    <input type="radio" name="familyStructure"><span>三代同堂</span>
                                </label>
                                <label>
                                    <input type="radio" name="familyStructure"><span>其他</span>
                                </label>
                            </div>

                        </div>

                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">居住区域</label>
                                <label>
                                    <input type="radio" name="residentialRegion"><span>中心城区</span>
                                </label>
                                <label>
                                    <input type="radio" name="residentialRegion"><span>南湖新区</span>
                                </label>
                                <label>
                                    <input type="radio" name="residentialRegion"><span>秀洲区</span>
                                </label>
                                <label>
                                    <input type="radio" name="residentialRegion"><span>经济开发区</span>
                                </label>
                                <label>
                                    <input type="radio" name="residentialRegion"><span>城北城东</span>
                                </label>
                            </div>

                        </div>


                        <div class="form-group">
                            <label for="residentialDistrict" class="col-sm-2 control-label">居住小区</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="residentialDistrict"
                                       name="residentialDistrict"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">工作区域</label>
                                <label>
                                    <input type="radio" name="workingArea"><span>科技城</span>
                                </label>
                                <label>
                                    <input type="radio" name="workingArea"><span>南湖新区</span>
                                </label>
                                <label>
                                    <input type="radio" name="workingArea"><span>国际商务园</span>
                                </label>
                                <label>
                                    <input type="radio" name="workingArea"><span>城东</span>
                                </label>
                                <label>
                                    <input type="radio" name="workingArea"><span>城南</span>
                                </label>
                                <label>
                                    <input type="radio" name="workingArea"><span>城北</span>
                                </label>
                                <label>
                                    <input type="radio" name="workingArea"><span>老城区</span>
                                </label>
                                <label>
                                    <input type="radio" name="workingArea"><span>秀湖区</span>
                                </label>
                                <label>
                                    <input type="radio" name="workingArea"><span>大桥镇</span>
                                </label>
                                <label>
                                    <input type="radio" name="workingArea"><span>新风镇</span>
                                </label>
                                <label>
                                    <input type="radio" name="workingArea"><span>风桥镇</span>
                                </label>
                                <label>
                                    <input type="radio" name="workingArea"><span>余新镇</span>
                                </label>
                                <label>
                                    <input type="radio" name="workingArea"><span>七星镇</span>
                                </label>
                                <label>
                                    <input type="radio" name="workingArea"><span>嘉善</span>
                                </label>
                                <label>
                                    <input type="radio" name="workingArea"><span>上海</span>
                                </label>
                                <label>
                                    <input type="radio" name="workingArea"><span>平湖</span>
                                </label>
                                <label>
                                    <input type="radio" name="workingArea"><span>海盐</span>
                                </label>
                                <label>
                                    <input type="radio" name="workingArea"><span>其他</span>
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">工作区域</label>
                                <label>
                                    <input type="radio" name="msgAccess"><span>户外大牌</span>
                                </label>
                                <label>
                                    <input type="radio" name="msgAccess"><span>户外高炮</span>
                                </label>
                                <label>
                                    <input type="radio" name="msgAccess"><span>工地现场</span>
                                </label>
                                <label>
                                    <input type="radio" name="msgAccess"><span>阵地包装</span>
                                </label>
                                <label>
                                    <input type="radio" name="msgAccess"><span>户外道旗</span>
                                </label>
                                <label>
                                    <input type="radio" name="msgAccess"><span>电视</span>
                                </label>
                                <label>
                                    <input type="radio" name="msgAccess"><span>电台</span>
                                </label>
                                <label>
                                    <input type="radio" name="msgAccess"><span>报纸</span>
                                </label>
                                <label>
                                    <input type="radio" name="msgAccess"><span>派单</span>
                                </label>
                                <label>
                                    <input type="radio" name="msgAccess"><span>房展</span>
                                </label>
                                <label>
                                    <input type="radio" name="msgAccess"><span>巡展</span>
                                </label>
                                <label>
                                    <input type="radio" name="msgAccess"><span>微信圈</span>
                                </label>
                                <label>
                                    <input type="radio" name="msgAccess"><span>渠道</span>
                                </label>
                                <label>
                                    <input type="radio" name="msgAccess"><span>网络</span>
                                </label>
                                <label>
                                    <input type="radio" name="msgAccess"><span>其他</span>
                                </label>
                            </div>

                        </div>


                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">单位分类</label>
                                <label>
                                    <input type="radio" name="companyType"><span>国企</span>
                                </label>
                                <label>
                                    <input type="radio" name="companyType"><span>政府机关</span>
                                </label>
                                <label>
                                    <input type="radio" name="companyType"><span>事业单位</span>
                                </label>
                                <label>
                                    <input type="radio" name="companyType"><span>金融业</span>
                                </label>
                                <label>
                                    <input type="radio" name="companyType"><span>服务业</span>
                                </label>
                                <label>
                                    <input type="radio" name="companyType"><span>企业员工</span>
                                </label>
                                <label>
                                    <input type="radio" name="companyType"><span>企业法人</span>
                                </label>
                                <label>
                                    <input type="radio" name="companyType"><span>房地产</span>
                                </label>
                                <label>
                                    <input type="radio" name="companyType"><span>电信电力</span>
                                </label>
                                <label>
                                    <input type="radio" name="companyType"><span>设计装潢</span>
                                </label>
                                <label>
                                    <input type="radio" name="companyType"><span>媒体业</span>
                                </label>
                                <label>
                                    <input type="radio" name="companyType"><span>交通运输物流</span>
                                </label>
                                <label>
                                    <input type="radio" name="companyType"><span>医疗医药</span>
                                </label>
                                <label>
                                    <input type="radio" name="companyType"><span>其他</span>
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">职务</label>
                                <label>
                                    <input type="radio" name="job"><span>法人</span>
                                </label>
                                <label>
                                    <input type="radio" name="job"><span>总经理</span>
                                </label>
                                <label>
                                    <input type="radio" name="job"><span>主管</span>
                                </label>
                                <label>
                                    <input type="radio" name="job"><span>部门经理</span>
                                </label>
                                <label>
                                    <input type="radio" name="job"><span>医生</span>
                                </label>
                                <label>
                                    <input type="radio" name="job"><span>老师</span>
                                </label>
                                <label>
                                    <input type="radio" name="job"><span>职员</span>
                                </label>
                                <label>
                                    <input type="radio" name="job"><span>其他</span>
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">首选产品</label>
                                <label>
                                    <input type="radio" name="preferredProduct"><span>高层</span>
                                </label>
                                <label>
                                    <input type="radio" name="preferredProduct"><span>洋房</span>
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">首选面积</label>
                                <label>
                                    <input type="radio" name="preferredArea"><span><90</span>
                                </label>
                                <label>
                                    <input type="radio" name="preferredArea"><span>90-105</span>
                                </label>
                                <label>
                                    <input type="radio" name="preferredArea"><span>105-120</span>
                                </label>
                                <label>
                                    <input type="radio" name="preferredArea"><span>120-140</span>
                                </label>
                                <label>
                                    <input type="radio" name="preferredArea"><span>140-160</span>
                                </label>
                                <label>
                                    <input type="radio" name="preferredArea"><span>160万以上</span>
                                </label>
                                <label>
                                    <input type="radio" name="preferredArea"><span>别墅</span>
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">意向单价</label>
                                <label>
                                    <input type="radio" name="psychologicalUnitPrice"><span>14000以下</span>
                                </label>
                                <label>
                                    <input type="radio" name="psychologicalUnitPrice"><span>14000-15000</span>
                                </label>
                                <label>
                                    <input type="radio" name="psychologicalUnitPrice"><span>15000-16000</span>
                                </label>
                                <label>
                                    <input type="radio" name="psychologicalUnitPrice"><span>16000以上</span>
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">意向总价</label>
                                <label>
                                    <input type="radio" name="psychologicalTotalPrice"><span>130万以内</span>
                                </label>
                                <label>
                                    <input type="radio" name="psychologicalTotalPrice"><span>130-140万</span>
                                </label>
                                <label>
                                    <input type="radio" name="psychologicalTotalPrice"><span>140-150万</span>
                                </label>
                                <label>
                                    <input type="radio" name="psychologicalTotalPrice"><span>150-160万</span>
                                </label>
                                <label>
                                    <input type="radio" name="psychologicalTotalPrice"><span>160-170万</span>
                                </label>
                                <label>
                                    <input type="radio" name="psychologicalTotalPrice"><span>170-180万</span>
                                </label>
                                <label>
                                    <input type="radio" name="psychologicalTotalPrice"><span>180-190万</span>
                                </label>
                                <label>
                                    <input type="radio" name="psychologicalTotalPrice"><span>190-200万</span>
                                </label>
                                <label>
                                    <input type="radio" name="psychologicalTotalPrice"><span>200万以上</span>
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">购房动机</label>
                                <label>
                                    <input type="radio" name="reason"><span>自住</span>
                                </label>
                                <label>
                                    <input type="radio" name="reason"><span>投资</span>
                                </label>
                                <label>
                                    <input type="radio" name="reason"><span>为子女</span>
                                </label>
                                <label>
                                    <input type="radio" name="reason"><span>为父母</span>
                                </label>
                                <label>
                                    <input type="radio" name="reason"><span>婚房</span>
                                </label>
                                <label>
                                    <input type="radio" name="reason"><span>其他</span>
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">付款方式</label>
                                <label>
                                    <input type="radio" name="payWay"><span>一次性付款</span>
                                </label>
                                <label>
                                    <input type="radio" name="payWay"><span>银行按揭(30%)</span>
                                </label>
                                <label>
                                    <input type="radio" name="payWay"><span>银行按揭(50%)</span>
                                </label>
                                <label>
                                    <input type="radio" name="payWay"><span>分期</span>
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">出行工具</label>
                                <label>
                                    <input type="radio" name="tripTools"><span>自行车</span>
                                </label>
                                <label>
                                    <input type="radio" name="tripTools"><span>助动车</span>
                                </label>
                                <label>
                                    <input type="radio" name="tripTools"><span>公交车</span>
                                </label>
                                <label>
                                    <input type="radio" name="tripTools"><span>私家车</span>
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">关键因素</label>
                                <label>
                                    <input type="radio" name="keyFactor"><span>价格</span>
                                </label>
                                <label>
                                    <input type="radio" name="keyFactor"><span>地段</span>
                                </label>
                                <label>
                                    <input type="radio" name="keyFactor"><span>交通</span>
                                </label>
                                <label>
                                    <input type="radio" name="keyFactor"><span>户型面积</span>
                                </label>
                                <label>
                                    <input type="radio" name="keyFactor"><span>开发商名片</span>
                                </label>
                                <label>
                                    <input type="radio" name="keyFactor"><span>物业服务</span>
                                </label>
                                <label>
                                    <input type="radio" name="keyFactor"><span>社区配套</span>
                                </label>
                                <label>
                                    <input type="radio" name="keyFactor"><span>景观环境</span>
                                </label>
                                <label>
                                    <input type="radio" name="keyFactor"><span>学区</span>
                                </label>
                                <label>
                                    <input type="radio" name="keyFactor"><span>升值潜力</span>
                                </label>
                                <label>
                                    <input type="radio" name="keyFactor"><span>其他</span>
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">置业次数</label>
                                <label>
                                    <input type="radio" name="askingTime"><span>首次置业</span>
                                </label>
                                <label>
                                    <input type="radio" name="askingTime"><span>非首次置业</span>
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">贷款次数</label>
                                <label>
                                    <input type="radio" name="loanTime"><span>0次</span>
                                </label>
                                <label>
                                    <input type="radio" name="loanTime"><span>1次</span>
                                </label>
                                <label>
                                    <input type="radio" name="loanTime"><span>2次</span>
                                </label>
                                <label>
                                    <input type="radio" name="loanTime"><span>3次及以上</span>
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">客户意愿</label>
                                <label>
                                    <input type="radio" name="willingness"><span>意向强烈</span>
                                </label>
                                <label>
                                    <input type="radio" name="willingness"><span>可能回头</span>
                                </label>
                                <label>
                                    <input type="radio" name="willingness"><span>意愿平平</span>
                                </label>
                                <label>
                                    <input type="radio" name="willingness"><span>观光调研</span>
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="label-radio">
                                <label class="col-sm-2 control-label">客户描述</label>
                                <textarea name="desc" maxlength="100">

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

        $('#receptionTime').val(toDDMMMYYYY(new Date()));

        $('form').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                salesmanName: {
                    validators: {
                        notEmpty: {
                            message: '置业顾问姓名不能为空'
                        },
                        stringLength: {
                            min: 1,
                            max: 18,
                            message: '姓名长度必须在1到18位之间'
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

        function checkCustomerForm() {
            var checkResult = false;

            //获取当前表单状态
            var flag = $("form").data("bootstrapValidator").isValid();
            if (flag) {
                //获取用户名
                var username = $("#username").val();
                //获取手机号码
                var phone = $("#phone").val();

                //发送ajax请求
                $.ajax({
                    url: '/salesman/checkSalesmanInfoByUsernameAndPhone',
                    async: false,//同步，会阻塞操作
                    type: 'GET',//PUT DELETE POST
                    data: {"username": username, "phone": phone},
                    success: function (result) {
                        if (result.code == 0) {
                            checkResult = true;
                        } else {
                            alert(result.msg);
                        }
                    }
                })
            }
            return checkResult;
        }
    </script>
</body>
</html>