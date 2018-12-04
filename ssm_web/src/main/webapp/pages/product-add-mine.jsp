<%--
  Created by IntelliJ IDEA.
  User: 98137
  Date: 2018-12-2
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<html>
<head>
    <title>产品增加页面</title>
    
    <%--引入资源文件--%>
    <link rel="stylesheet" href="${pageContext.request.contextpath}/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextpath}/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextpath}/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextpath}/plugins/iCheck/square/blue.css">
    <link rel="stylesheet" href="${pageContext.request.contextpath}/plugins/morris/morris.css">
    <link rel="stylesheet" href="${pageContext.request.contextpath}/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet" href="${pageContext.request.contextpath}/plugins/datepicker/datepicker3.css">
    <link rel="stylesheet" href="${pageContext.request.contextpath}/plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet" href="${pageContext.request.contextpath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextpath}/plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextpath}/plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet" href="${pageContext.request.contextpath}/plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet" href="${pageContext.request.contextpath}/plugins/select2/select2.css">
    <link rel="stylesheet" href="${pageContext.request.contextpath}/plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextpath}/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextpath}/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextpath}/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextpath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextpath}/plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet" href="${pageContext.request.contextpath}/plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet" href="${pageContext.request.contextpath}/plugins/bootstrap-slider/slider.css">
    <link rel="stylesheet" href="${pageContext.request.contextpath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
</head>
<body>
<form action="${pageContext.request.contextPath}/product/saveProduct"></form>
<div class="row data-type">

    <div class="col-md-2 title">订单编号</div>
    <div class="col-md-4 data text">
        xxxxxxx
    </div>

    <div class="col-md-2 title">路线名称</div>
    <div class="col-md-4 data text">
        2019-01-01
    </div>

    <div class="col-md-2 title">出发城市</div>
    <div class="col-md-4 data text">
        xxxxxxx
    </div>

    <div class="col-md-2 title">产品价格</div>
    <div class="col-md-4 data text">
        北京
    </div>

    <div class="col-md-2 title">产品描述</div>
    <div class="col-md-10 data text">
        aaadfsdfdsfsdfdsa
    </div>
    <div class="col-md-2 title">状态</div>
    <div class="col-md-10 data text">
        aaadfsdfdsfsdfdsa
    </div>
    <div class="col-md-2 title rowHeight2x">高度2x</div>
    <div class="col-md-10 data rowHeight2x">
        <textarea class="form-control" rows="3" placeholder="请输入${pageContext.request.contextpath}." disabled="disabled"></textarea>
    </div>

</div>
</body>
</html>
