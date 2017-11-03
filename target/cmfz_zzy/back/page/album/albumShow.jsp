<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script>
    $(function(){
        $("#albumdatagrid").treegrid({
            url:'${pageContext.request.contextPath}/album/findAll',
            fit:true,
            fitColumns:true,
            pagination:true,
            idField:'id',
            treeField:'name',
            columns:[[
                {field:'name',title:'专辑名称',width:100,},
                {field:'setCount',title:'集数',width:100,},
                {field:'createTime',title:'上传时间',width:100},
                {field:'score',title:'评分',width:100},
                {field:'author',title:'作者',width:100},
                {field:'broadcast',title:'播音者',width:100},
                {field:'status',title:'状态',width:100,editor:{
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
                }},
                {field:'cz',title:'操作',width:100,
                    formatter: function(value,row,index){
                        if(row.size==null) {
                            return "<a href='javascript:;' onClick=\"updateRow();\" class='upd'>保存</a>";
                        }else{
                            return "<a href='javascript:;' onClick=\"downloadRow();\" class='down'>下载</a>"
                                +"<a href='javascript:;' style='display: none' onClick=\"stopRow();\" class='audiostop'>暂停</a>";
                        }
                    }
                }
            ]],
            onLoadSuccess:function(){
                $(".upd").linkbutton({plain:true,iconCls:'icon-edit'});
                $(".down").linkbutton({plain:true,iconCls:'icon-ok'});
                $(".audiostop").linkbutton({plain:true,iconCls:' icon-control_pause_blue'});
            },
            toolbar: [{
                text:'添加专辑',
                iconCls: 'icon-add',
                handler: function(){
                    $("#albumadd").dialog({
                        width:400,
                        height:500,
                        href:'${pageContext.request.contextPath}/back/page/album/albumAdd.jsp',
                        title:'上传专辑窗口',
                        buttons:[{
                            text:'保存',
                            handler:function(){

                                $("#uploadalbum").form('submit',{
                                    url:'${pageContext.request.contextPath}/album/save',
                                    success:function(data){
                                        $("#uploadalbum").form('clear');
                                        $("#albumadd").dialog("close",true);
                                        $('#albumdatagrid').treegrid('reload');
                                        $.messager.alert("我的消息",data);

                                    }

                                })
                            }
                        },{
                            text:'关闭',
                            handler:function(){
                                $("#albumadd").dialog("close",true);
                            }
                        }]
                    })
                }
            },'-',{
                text:'添加章节',
                iconCls: 'icon-add',
                handler: function(){
                    $("#chapteradd").dialog({
                        width:400,
                        height:400,
                        href:'${pageContext.request.contextPath}/back/page/album/chapterAdd.jsp',
                        title:'上传章节窗口',
                        buttons:[{
                            text:'保存',
                            handler:function(){
                                $("#uploadchapter").form('submit',{
                                    url:'${pageContext.request.contextPath}/chapter/save',
                                    success:function(data){
                                        $("#uploadchapter").form('clear');
                                        $("#chapteradd").dialog("close",true);
                                        $('#albumdatagrid').treegrid('reload');
                                        $.messager.alert("我的消息",data);
                                    }
                                })
                            }
                        },{
                            text:'关闭',
                            handler:function(){
                                $("#chapteradd").dialog("close",true);
                            }
                        }]
                    });
                }
            }],
            onAfterEdit:function(row,changes){
                $.ajax({
                    type:'post',
                    data:JSON.stringify(row),
                    url:'${pageContext.request.contextPath}/album/update',
                    contentType:'application/json',
                    success:function(result){
                        $.messager.alert('我的消息',result);
                        $("#albumdatagrid").treegrid('reload');

                    }
                })
            },
            onDblClickRow:function (row) {
                if(row.size==null) {
                    //父类开始编辑修改
                    $("#albumdatagrid").treegrid('beginEdit', row.id);
                }else{
                    //音频播放
                    var row=$("#albumdatagrid").treegrid('getSelected');
                    var media=document.getElementById("musicbox");
                    $(media).prop("src","${pageContext.request.contextPath}/upload/"+row.download);
                    media.play();
                    $(".audiostop").css("display","inline");
                }
            }

        });
    });
    //音频终止
    function stopRow(){
        $(".audiostop").css("display","none");
        var media=document.getElementById("musicbox");
        media.pause();
    }
    //结束编辑
    function updateRow(){
        var row=$("#albumdatagrid").treegrid('getSelected');
        $("#albumdatagrid").treegrid('endEdit',row.id);

    }
    //下载事件
    function downloadRow(){
        var row=$("#albumdatagrid").treegrid('getSelected');
        location.href='${pageContext.request.contextPath}/chapter/download?name='+row.download;
    }
</script>
<table id="albumdatagrid">
</table>
<div id="albumadd"></div>
<div id="chapteradd"></div>
<audio id="musicbox"  autoplay="true"></audio>
