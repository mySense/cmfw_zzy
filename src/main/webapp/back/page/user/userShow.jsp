<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    <script>
        $(function(){


        $("#userdatagrid").edatagrid({
            url:'${pageContext.request.contextPath}/user/findAll',
            fitColumns:true,
            fit:true,
            autoSave:true,
            pagination:true,
            view:detailview,
            detailFormatter:function(index,row){
                return "<img style='width:200px;height:300px;' src=\"${pageContext.request.contextPath}/upload/"+row.photo+"\"/>";
            },
            updateUrl:'${pageContext.request.contextPath}/user/update',
            columns:[[
                {title:'编号',field:'id',width:100},
                {title:'姓名',field:'name',width:100},
                {title:'法号',field:'fname',width:100},
                {title:'手机号',field:'phone',width:100},
                {title:'性别',field:'sex',width:100},
                {title:'所在地',field:'location',width:100},
                {title:'状态',field:'status',width:100,editor:{
                    type:'combobox',
                    options:{
                        valueField: 'label',
                        textField: 'value',
                        data: [{
                            label: 'Y',
                            value: '正常'
                        },{
                            label: 'N',
                            value: '冻结'
                        }]
                    }
                }}
            ]],
            toolbar: [{
                text:'添加',
                iconCls: 'icon-add',
                handler: function(){
                    $("#addUser").dialog({
                        title:'添加界面',
                        width:400,
                        height:600,
                        href:'${pageContext.request.contextPath}/back/page/user/addUser.jsp',
                        buttons:[{
                            text:'保存',
                            handler:function(){
                                $("#userform").form('submit',{
                                    url:'${pageContext.request.contextPath}/user/save',
                                    success:function(data){
                                        $("#userform").form('clear');
                                        $("#addUser").dialog('close',true);
                                        $("#userdatagrid").edatagrid('reload');
                                        $.messager.alert("我的消息",data);
                                    }
                                });
                            }
                        },{
                            text:'关闭',
                            handler:function(){
                                $("#addUser").dialog('close',true);
                            }
                        }]
                    })
                }
            },{
                text:'导入',
                iconCls:'icon-ok',
                handler: function(){

                }
            },{
                text:'导出',
                iconCls:'icon-remove',
                handler: function(){

                }
            }]
        });

        });
        //$function结束处
    </script>
    <table id="userdatagrid"></table>
<div id="addUser"></div>