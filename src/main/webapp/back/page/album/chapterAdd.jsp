<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script>
    $(function(){

        $("#albumid").combobox({
            url:"${pageContext.request.contextPath}/album/find",
            valueField:'id',
            textField:'name'
        })

    })
</script>
<form method="post" id="uploadchapter" enctype="multipart/form-data">
    <div style="text-align: center;margin-top:30px;">
        <input name="singer" class="easyui-filebox"  data-options="accept:'.mp3',label:'选择文件',buttonText:'浏览',buttonAlign:'left',width:200"/><br/><br/><br/>
        <input name="name" class="easyui-textbox" data-options="label:'名&nbsp;&nbsp;&nbsp;&nbsp;字',width:200,labelWidth:40"/><br/><br/><br/>
        专辑名称<input id="albumid" name="albumid"/>
    </div>
</form>

