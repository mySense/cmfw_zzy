<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script>
    $(function(){
        $.extend($.fn.validatebox.defaults.rules, {
            equals: {
                validator: function(value,param){
                    return value == $(param[0]).val();
                },
                message: '两次密码不一致'
            }
        });
    });
</script>
<form method="post" id="updatepwd">
    <div style="text-align: center;margin-top:30px;">
        <input type="hidden" name="id" value="${sessionScope.admin.id}"/>
        <input type="hidden" name="username" value="${sessionScope.admin.username}"/>
        <input name="password" id="password" class="easyui-passwordbox" data-options="required:true,width:170,prompt:'请输入密码',label:'密&nbsp;&nbsp;&nbsp;&nbsp;码',labelWidth:40"/><br/><br/>
        <input name="password1" class="easyui-passwordbox"  validType="equals['#password']" data-options="required:true,width:170,prompt:'请输入确认密码',label:'确认密码',labelWidth:40"/><br/>
    </div>
</form>