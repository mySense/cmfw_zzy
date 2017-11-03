<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script>
    $(function(){
        $("#datagrid").edatagrid({
            url:'${pageContext.request.contextPath}/roast/findAll',
            autoSave:true,
            fit:true,
            fitColumns:true,
            pagination:true,
            view:detailview,
            detailFormatter:function(index,row){
                return "<img style='width:200px;height:300px;' alt=\""+row.alt+"\" src=\"${pageContext.request.contextPath}/upload/"+row.imgPath+"\"/>";
            },
            columns:[[
                {field:'id',title:'编号',width:100},
                {field:'alt',title:'描述',width:100,editor:{
                        type:'textbox',
                        options:{
                            required:true
                        }
                }},
                {field:'imgPath',title:'路径',width:100,},
                {field:'status',title:'状态',width:100,editor:{
                    type:'combobox',
                    options:{
                        url:'${pageContext.request.contextPath}/back/page/roast/roast.json',
                        valueField:'id',
                        textField:'text'
                    }
                }},
                {field:'createTime',title:'上传时间',width:100}
            ]],
            toolbar: [{
                iconCls: 'icon-add',
                handler: function(){
                    $("#filebox").dialog({
                        title:'上传界面',
                        width:300,
                        height:200,
                        href:'${pageContext.request.contextPath}/back/page/roast/uploadRoast.jsp',
                        buttons:[{
                            text:'上传',
                            handler:function(){
                                $("#uploadRoast").form('submit',{
                                    url:'${pageContext.request.contextPath}/roast/upload',
                                    success:function(sc){
                                        $("#uploadRoast").form('clear');
                                        $("#filebox").dialog('close',true);
                                        $("#datagrid").datagrid('reload');
                                        $.messager.alert('我的消息',sc);

                                    }
                                })

                            }
                        },{
                            text:'关闭',
                            handler:function(){
                                $("#filebox").dialog('close',true);                               }
                        }]

                    })
                }
            }],
            onAfterEdit:function(index,row,changes){
                $.ajax({
                    url:'${pageContext.request.contextPath}/roast/update',
                    data:JSON.stringify(row),
                    type:"POST",
                    contentType:"application/json",//请求格式 为json
                    success:function(result){
                        //刷新datagrid
                        $.messager.alert("我的消息",result);
                    }
                });
            }
        });
    });
</script>
<table id="datagrid" class="easyui-datagrid"  >
</table>
<div id="filebox"></div>
