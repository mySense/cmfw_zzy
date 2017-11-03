<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    <script type="text/javascript">
            $(function(){
                $("#articledatagrid").edatagrid({
                    url:'${pageContext.request.contextPath}/article/findAll',
                    fitColumns:true,
                    fit:true,
                    autoSave:true,
                    pagination:true,
                    view:detailview,
                    detailFormatter:function(index,row){
                        return row.content;
                    },
                    updateUrl:'${pageContext.request.contextPath}/article/update',
                    columns:[[
                        {title:'编号',field:'id',width:100},
                        {title:'文章名',field:'name',width:100},
                        {title:'上传时间',field:'createTime',width:100},
                        {title:'状态',field:'status',width:100,editor:{
                            type:'combobox',
                            options:{
                                valueField: 'label',
                                textField: 'value',
                                data: [{
                                    label: 'Y',
                                    value: '展示'
                                },{
                                    label: 'N',
                                    value: '不展示'
                                }]
                            }
                        }}
                    ]],
                    toolbar: [{
                        iconCls: 'icon-add',
                        handler: function(){
                            $("#addarticle").dialog({
                                width:685,
                                height:550,
                                title:'上传文章界面',
                                href:'${pageContext.request.contextPath}/back/page/article/addArticle.jsp',
                                buttons:[{
                                    text:'保存',
                                    handler:function(){
                                        $("#articleform").form('submit',{
                                            url:'${pageContext.request.contextPath}/article/save',
                                            success:function(data){
                                                $("#articleform").form('clear');
                                                $("#addarticle").dialog('close',true);
                                                $("#articledatagrid").edatagrid('reload');
                                                $.messager.alert('我的消息',data);
                                            }
                                        })
                                    }
                                },{
                                    text:'关闭',
                                    handler:function(){
                                        $("#addarticle").dialog('close',true);
                                    }
                                }]
                            })
                        }
                    }]

                });
            });

    </script>

    <table id="articledatagrid">
    </table>
    <div id="addarticle"></div>
