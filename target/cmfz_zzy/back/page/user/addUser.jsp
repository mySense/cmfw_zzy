<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script>
    $(function(){
        $("#sex").combobox({
            valueField: 'label',
            textField: 'value',
            data: [{
                label: 'f',
                value: '男'
            },{
                label: 'm',
                value: '女'
            }]
        })
    })
</script>
<form id="userform" method="post" enctype="multipart/form-data">
    <div style="text-align: center;margin-top:30px;">
    <input name="img" class="easyui-filebox"  data-options="accept:'.jpg',label:'选择头像',buttonText:'浏览',buttonAlign:'left',width:200"/><br/><br/><br/>
    <input name="name" class="easyui-textbox" data-options="label:'名&nbsp;&nbsp;&nbsp;&nbsp;字',width:200,labelWidth:40"/><br/><br/><br/>
        <input name="password" class="easyui-textbox" data-options="label:'密&nbsp;&nbsp;&nbsp;&nbsp;码',width:200,labelWidth:40"/><br/><br/><br/>
    <input name="fname" class="easyui-textbox" data-options="label:'法&nbsp;&nbsp;&nbsp;&nbsp;号',width:200,labelWidth:40"/><br/><br/><br/>
    <input name="phone" class="easyui-textbox" data-options="label:'手&nbsp;机&nbsp;号',width:200,labelWidth:40"/><br/><br/><br/>
    <input id="sex" name="sex" class="easyui-combobox" data-options="label:'性&nbsp;&nbsp;&nbsp;&nbsp;别',width:200,labelWidth:40"/><br/><br/><br/>
    <input name="location" class="easyui-textbox" data-options="label:'所&nbsp;在&nbsp;地',width:200,labelWidth:40"/><br/><br/><br/>
    <input name="city" class="easyui-textbox" data-options="label:'城&nbsp;&nbsp;&nbsp;&nbsp;市',width:200,labelWidth:40"/><br/><br/><br/>
    <input name="province" class="easyui-textbox" data-options="label:'省&nbsp;&nbsp;&nbsp;&nbsp;份',width:200,labelWidth:40"/><br/><br/><br/>
    <input name="description" class="easyui-textbox" data-options="label:'个性签名',width:200,labelWidth:40"/><br/><br/><br/>
    </div>
</form>
