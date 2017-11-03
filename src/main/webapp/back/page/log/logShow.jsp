<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/themes/gray/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/themes/IconExtension.css"/>
    <script>
        $(function(){

        $("#logdatagrid").edatagrid({
            url:'${pageContext.request.contextPath}/log/findAll',
            fitColumns:true,
            fit:true,
            pagination:true,
            columns:[[
                {title:'编号',field:'id',width:100},
                {title:'姓名',field:'name',width:100},
                {title:'时间',field:'date',width:100},
                {title:'事件',field:'doSomeThing',width:100},
                {title:'状态',field:'status',width:100}
                ]]
        });
        });
    </script>

    <table id="logdatagrid"></table>
