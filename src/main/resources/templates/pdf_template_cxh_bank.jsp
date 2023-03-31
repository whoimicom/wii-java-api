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
<p class="textIndent lineHeightText">授权人（代扣账户所有人）：</p>
<p class="textIndent lineHeightText">姓名<u> ${member.realName} </u>身份证号码<u> ${member.creSn} </u></p>
<p class="textIndent lineHeightText" >被授权人（向支付机构发送扣款指令人）：深圳市创想汇科技服务有限公司</p>
<p class="textIndent lineHeightText">
    鉴于授权人于<u> ${member.applyTime}</u>签署了《借款合同》（以下简称“合同”）授权人（以下简称“本人”）作出如下不可撤销的授权。
</p>
<p class="textIndent lineHeightText">
    一、本人保证提供给被授权人的银行卡资料（包括：卡号、姓名、证件号码、手机）为本人持有的真实、完整、合法、有效的银行卡信息，并同意被授权人将以上信息送至发卡银行进行核验 。
</p>
<p class="textIndent lineHeightText">
    二、本人同意被授权人在合同的约定的期限内或本授权书有效期内，委托银行或第三方支付机构（包括但不限于银联、易极付、中金支付等）及第三方支付公司的合作银行从本人指定的账户内以合同约定的费用标准划付应付的费用。本人承诺前述委托扣款意愿真实，不得向发卡银行及其他代理扣款的支付清算机构提出异议。
</p>
<p class="textIndent lineHeightText">
    三、本人同意并授权被授权人根据实际的借款金额，在约定期限内从本人指定的账户中、以及本人在第三方支付机构开立的任何账户中扣收贷款本息，并无任何异议。
</p>
<p class="textIndent lineHeightText">
    四、本人保证在指定账户中留有足够余额，若因账户余额不足导致无法及时扣款或扣款异常，包括但不限于错误、失败等，不可归责于被授权人，造成的任何损失及法律责任由授权人自行承担。
</p>
<p class="textIndent lineHeightText">
    五、本人保证在代扣账户信息变更时及时通知被授权人，若因本人未及时通知而造成的原账户扣款失败产生的逾期费、利息费及其他任何费用由本人全部承担，与被授权人无关。
</p>
<p class="textIndent lineHeightText">
    六、本授权书自授权人签字或盖章之日起生效，至授权人通知终止授权、或授权账户终止、或合同效力终止时终止。
</p>
<h3 style="line-height: 20px">客户确认：本人已认真阅读本协议，在完全理解本协议的情况下，同意本协议的全部内容。</h3>

<p style="padding-top: 6px;">
    <strong>授权人（签名）：_________________</strong><br />
    <strong>身份证号码：<u> ${member.creSn} </u></strong><br />
    <strong>授权日期：${currDate}</strong><br />
</p>
</body>
</html>