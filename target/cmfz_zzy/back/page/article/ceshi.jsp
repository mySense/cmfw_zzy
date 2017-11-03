<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/easyUi/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/editor/kindeditor-all-min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/editor/lang/zh-CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyUi/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyUi/easyui-lang-zh_CN.js"></script>
<script>
    $(function(){
        KindEditor.create('#contentEditor',{
            afterBlur: function () { this.sync(); }
        })
        $("#sss").click(function(){
            $("#formid").form('submit',{
                url:'wqe4qwr/qweqwr'
            })
        })

    })
</script>
</head>
<body>
<form id="formid"  method="post" enctype="multipart/form-data">
    <input name="photo" class="easyui-filebox"  data-options="accept:'.jpg',label:'选择头像',buttonText:'浏览',buttonAlign:'left',width:200"/><br/><br/><br/>
    <input name="name" class="easyui-textbox" data-options="label:'名&nbsp;&nbsp;&nbsp;&nbsp;字',width:200,labelWidth:40"/><br/><br/><br/>
    <textarea id="contentEditor" name="contentE" style="width:270px;height:200px;"></textarea>
    <input id="sss" type="button" value="wqerew" name="content"/>
</form>
</body>
</html>