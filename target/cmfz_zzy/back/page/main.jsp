<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>持名法州主页</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/themes/gray/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/themes/IconExtension.css"/>

     <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyUi/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyUi/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyUi/form.validator.rules.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyUi/jquery.edatagrid.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyUi/datagrid-detailview.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/editor/kindeditor-all-min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/editor/lang/zh-CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyUi/echarts.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyUi/chain.js"></script>
    <script>
        var $dd;
        $(function(){
            $dd=$("#aa");
            //ajax
            $.get('<c:url value="/menu/findAll" />',function(result){
                $.each(result,function(idx,menu){
                    var content='<div style="text-align:center;">';
                    $.each(menu.children,function(idx,child){
                        var tz=child.href+"*"+child.title+"*"+child.iconCls;
                        content+="<div class='easyui-linkbutton' onClick=\"tz('"+tz+"');\" style='margin:10px 0px 10px 0px;width:90%;border:1px solid #95B8E7' data-options='plain:true,iconCls:\""+child.iconCls+"\"'>"+child.title+"</div><br/>";
                    })
                    $dd.accordion('add',{
                        title:menu.title,
                        iconCls:menu.iconCls,
                        content:content+"</div>",
                    });
                });

            },"JSON");
        });



        //系统菜单二级
        function tz(a){
            var z=a.split("*");
            var href=z[0];
            var title=z[1];
            var iconCls=z[2];
            if(!$("#tt").tabs('exists',title)){
                $("#tt").tabs('add',{
                    title:title,
                    href:href,
                    closable:true,
                    iconCls:iconCls,
                    tools:[{
                        iconCls:'icon-reload',
                        handler:refreshTab,
                    }]
                });
                var tab= $("#tt").tabs('getSelected');
                tab.panel('refresh');
            }else{
                $("#tt").tabs('select',title);
                var tab= $("#tt").tabs('getSelected');
                tab.panel('refresh');
            }
        }

        //选项卡刷新
        function refreshTab(){
            var tab= $("#tt").tabs('getSelected');
            tab.panel('refresh');
        }
        //修改密码
        function updatePassword(){
            $("#updatePassword").dialog({
                    title:'账号安全',
                    width:300,
                    height:200,
                    href:'${pageContext.request.contextPath}/back/page/updateAdmin.jsp',
                    buttons:[{
                        text:'修改密码',
                        handler:function(){
                            $("#updatepwd").form('submit',{
                                url:'${pageContext.request.contextPath}/admin/updatePassword',
                                success:function(data){
                                    $("#updatePassword").dialog('close',true);
                                    $.messager.alert('我的消息',data);
                                }


                            })
                        }
                        },{
                        text:'关闭',
                        handler:function(){
                            $("#updatePassword").dialog('close',true);
                        }
                        }]
            })
        }
        //退出登陆
        function outLogin(){
            window.location.href='${pageContext.request.contextPath}/admin/outLogin';
        }
    </script>
</head>
<body class="easyui-layout">
<div data-options="region:'north'" style="height:60px;background-color:  #5C160C">
    <div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    <div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.admin.username} &nbsp;<a href="#" class="easyui-linkbutton" onClick="updatePassword();" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="#" class="easyui-linkbutton" onClick="outLogin();" data-options="iconCls:'icon-01'">退出系统</a></div>
</div>
<div data-options="region:'south'" style="height: 40px;background: #5C160C">
    <div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育</div>
</div>

<div data-options="region:'west',title:'导航菜单',iconCls:'icon-home'" style="width:220px;">
    <div id="aa" class="easyui-accordion" data-options="fit:true">

    </div>
</div>
<div data-options="region:'center'">
    <div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
        <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(../img/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
    </div>
</div>


<%--修改密码的界面--%>
<div id="updatePassword"></div>
</body>
</html>