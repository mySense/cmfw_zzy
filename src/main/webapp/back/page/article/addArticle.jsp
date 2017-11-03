<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script>
    $(function(){
        $("#guruname").combobox({
            valueField: 'id',
            textField: 'name',
            url:'${pageContext.request.contextPath}/guru/findGuru'
        });
        KindEditor.create('#contentEditor',{
            afterBlur: function () { this.sync(); },
            basePath:'${pageContext.request.contextPath}/back/editor/',
            uploadJson:'${pageContext.request.contextPath}/article/upload',
            filePostName:'articleimg'
        })
    })
</script>
<form id="articleform" method="post" enctype="multipart/form-data">
    <div style="text-align: center;margin-top:30px;">
    <input name="photo" class="easyui-filebox"  data-options="accept:'.jpg',label:'选择头像',buttonText:'浏览',buttonAlign:'left',width:200"/><br/><br/><br/>
    <input name="name" class="easyui-textbox" data-options="label:'名&nbsp;&nbsp;&nbsp;&nbsp;字',width:200,labelWidth:40"/><br/><br/><br/>
    <input name="href" class="easyui-textbox" data-options="label:'路&nbsp;&nbsp;&nbsp;&nbsp;径',width:200,labelWidth:40"/><br/><br/><br/>
    <input name="ext" class="easyui-textbox" data-options="label:'扩&nbsp;&nbsp;&nbsp;&nbsp;展',width:200,labelWidth:40"/><br/><br/><br/>
    <input id="guruname" name="guruid" class="easyui-combobox" data-options="label:'上&nbsp;&nbsp;&nbsp;&nbsp;师',width:200,labelWidth:40"/><br/><br/><br/>
        <textarea id="contentEditor" name="contentE" style="width:270px;height:200px;"></textarea>
    </div>
</form>
