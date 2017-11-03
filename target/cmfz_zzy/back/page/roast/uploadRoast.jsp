<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<form method="post" id="uploadRoast" enctype="multipart/form-data">
    <div style="text-align: center;margin-top:30px;">
        <input name="photo" class="easyui-filebox"  data-options="accept:'.jpg',label:'选择文件',buttonText:'浏览',buttonAlign:'left',width:200"/><br/><br/>
        <input name="alt" class="easyui-textbox" data-options="label:'描&nbsp;&nbsp;&nbsp;&nbsp;述',width:200,labelWidth:40"/><br/>
    </div>
</form>