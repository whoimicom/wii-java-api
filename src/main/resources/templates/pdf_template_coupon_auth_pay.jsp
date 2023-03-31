<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../inc_common.jsp" %>
<%@ include file="../../inc_doctype.jsp" %>
<jsp:useBean id="constant" scope="page" class="com.dragon.plat.common.Constant"></jsp:useBean>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Untitled Document</title>
    <style>
    @page {
        margin: 10px 20px;
        padding: 0px 10px;
    }

    * {
        font-size: 12px;
        font-family: "SimSun";
    }

    body {
        margin: 0;
        padding: 0;
    }

    h1 {
        position: relative;
        text-align: center;
        height: 71px;
        line-height: 71px;
        font-size: 18px;
        font-weight: bold;
        margin: 0;
        padding: 0;
    }

    h1 img {
        position: absolute;
        left: 10px;
        top: 0px;
    }

    h3 {
        line-height: 6px;
    }

    h2 {
        position: relative;
        text-align: center;
        height: 51px;
        line-height: 31px;
        font-size: 20px;
        font-weight: bold;
        margin: 0;
        padding: 0;
    }

    h2 img {
        position: absolute;
        left: 10px;
        top: 8px;
    }

    table {
        margin: 7px;
        table-layout: fixed;
        width: 98%;
        margin: 0 auto;
    }

    table tr td {
        height: 6px;
    }

    p {
        margin: 0;
    }

    .lineHeightText {
        line-height: 20px;
    }

    .textIndent {
        text-indent: 2em;
    }
    </style>
</head>

<body style="width: 100%;">
<h1>委托扣款授权书</h1>
<p class="textIndent">委托人（代扣账户所有人）：</p>
<p class="textIndent">姓名<u> ${name} </u>，身份证号码<u> ${creSn} </u></p>
<p class="textIndent">受托人（向支付机构发送扣款指令人）：重庆两江新区同泽小额贷款有限公司</p>
<p class="textIndent">因委托人通过${wechatName}微信公众号购买还款优惠劵，为保证委托人能及时支付因购买该优惠劵产生的费用，特对受托人作出如下不可撤销的授权：</p>
<p class="textIndent">
    一、本人保证提供给受托人的银行账户信息（包括但不限于：卡号、姓名、证件号码、手机号码）为本人持有的真实、完整、合法、有效的银行账户信息，并同意受托人将以上信息送至发卡银行进行核验</p>
<p class="textIndent">
    二、本人同意在本授权有效期内，委托受托人及其合作的第三方机构（包括但不限于银联、易极付、中金支付等）及第三方公司的合作机构从本人指定的账户内以购买优惠劵时应付费用标准划付应付的费用。本人承诺前述委托扣款意愿真实，不得向发卡银行及其他代理扣款的支付清算机构提出异议
</p>
<p class="textIndent">三、本人保证在指定账户中留有足够余额，若因账户余额不足导致无法及时扣款或扣款异常，包括但不限于错误、失败等，不可归责于受托人，造成的任何损失及法律责任由委托人自行承担。</p>
<p class="textIndent">四、本授权书期限本授权书有效期自签署或盖章之日起至委托人支付完毕因购买优惠劵产生的应付款项时止。</p>
<h3 style="line-height: 20px">客户确认：本人已认真阅读本协议，在完全理解本协议的情况下，同意本协议的全部内容。</h3>

<p style="padding-top: 6px;">
    <strong>委托人（签名）：_________________</strong>
    <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
    <span><strong>受托人签章：______________</strong></span>
    <br/>
    <strong>身份证号码：<u> ${creSn} </u></strong><br/>
    <strong>银行账户信息：户名：<u> ${name} </u> &nbsp;账号： <u> ${bankCardNo} </u> &nbsp;开户行：<u> ${bankDesc} </u></strong><br/>
    <strong>签署日期：<u> ${currDate} </u></strong><br/>
</p>
</body>
</html>