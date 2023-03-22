<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="../../inc_common.jsp"%>
<%@ include file="../../inc_doctype.jsp"%>
<jsp:useBean id="constant" scope="page"
	class="com.dragon.plat.common.Constant"></jsp:useBean>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Untitled Document</title>
<style>
@page {
	margin: 10px 20px;
	padding: 0px, 10px;
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
	top: 10px;
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

.p-left {
	margin: 3px 0;
}

.partition {
	background: url("images/partition.png") center repeat-x;
	text-align: center;
}

div {
	margin: 0;
}

.lineHeightText {
	line-height: 25px;
}

.textIndent {
	text-indent: 2em;
}
</style>
</head>

<body style="width: 100%;">
<div>
    <h1>
        <img  width="100px;" height="60px;" src="${fundsSource.companyLogo}" />
    </h1>
	<h1>
		个人信用报告查询与上报授权书
	</h1>
	<div class="lineHeightText">申请编号：${member.loan.xtSn}</div>
	<div class="lineHeightText">授权人：${member.realName}</div>
	<div class="lineHeightText">证件名称：身份证</div>
	<div class="lineHeightText">证件号码：${member.creSn}</div>
	<div class="lineHeightText">受权人：重庆两江新区同泽小额贷款有限责任公司</div>
	<div class="lineHeightText">授权内容：</div>
	<div class="lineHeightText textIndent">
		本人因贷款业务办理需要，授权重庆两江新区同泽小额贷款有限责任公司向金融信用信息基础数据库（人行征信系统）查询、打印、复制、保存本人的个人信用报告，用于业务受理、审查审批以及贷后管理，并将个人基本信息、信贷交易信息、反映个人信用状况的其他信息向金融信用信息基础数据库（人行征信系统）报送。授权时间期限为业务受理之日起至贷款本息还清或者业务办理终结之日三个月后为止。
	</div>
	<div class="lineHeightText">
		本人知悉本人未按照合同履行义务的信息（如拖欠、逾期等）将报送金融信用信息基础数据库（人行征信系统）。若信贷业务未批准，本授
		权书、个人信用报告等材料本人不要求退回。</div>
	<div class="lineHeightText">特此授权！</div>
	<div style="padding-top: 6px;">授权人（签名）：</div>
	<div style="padding-top: 6px;">日期：${currDate}</div>
	</div>
</body>

</html>