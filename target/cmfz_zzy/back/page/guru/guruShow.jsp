<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <script type="text/javascript">
            $(function(){
                $("#gurudatagrid").edatagrid({
                    url:'${pageContext.request.contextPath}/guru/findAll',
                    fitColumns:true,
                    fit:true,
                    autoSave:true,
                    pagination:true,
                    view:detailview,
                    detailFormatter:function(index,row){
                        return "<img style='width:200px;height:300px;' src=\"${pageContext.request.contextPath}/upload/"+row.imgPath+"\"/>";
                    },
                    updateUrl:'${pageContext.request.contextPath}/guru/update',
                    columns:[[
                        {title:'编号',field:'id',width:100},
                        {title:'法号',field:'name',width:100,editor:{
                            type:'textbox'
                        }},
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
                                    value: '囚禁'
                                }]
                            }
                        }}
                    ]],
                    toolbar: [{
                        text:'添加',
                        iconCls: 'icon-add',
                        handler: function(){
                            $("#addguru").dialog({
                                title:'添加界面',
                                width:300,
                                height:230,
                                href:'${pageContext.request.contextPath}/back/page/guru/addguru.jsp',
                                buttons:[{
                                    text:'保存',
                                    handler:function(){
                                        $("#guruform").form('submit',{
                                           url:'${pageContext.request.contextPath}/guru/save',
                                            success:function(data){
                                               $("#guruform").form('clear');
                                               $("#addguru").dialog('close',true);
                                               $("#gurudatagrid").edatagrid('reload');
                                               $.messager.alert("我的消息",data);
                                            }
                                        });
                                    }
                                },{
                                    text:'关闭',
                                    handler:function(){
                                        $("#addguru").dialog('close',true);
                                    }
                                }]
                            })
                        }
                    }]

                })

            })
    </script>

    <table id="gurudatagrid">
    </table>
    <div id="addguru"></div>

