<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<script>
    $(function(){
    var youEchart=echarts.init(document.getElementById('bar'));
    $.ajax({
        type:'post',
        dataType:'JSON',
        url:'${pageContext.request.contextPath}/user/findUserNum',
        success:function(data){
            var option={
                title:{
                    text:'用户数量',
                },
                legend:{
                    data:['折线','柱状']
                },
                xAxis:{
                    data:['一周','两周','三周']
                },
                yAxis:{},
                series:[{
                    type:'line',
                    name:'折线',
                    data:data

                },{
                    type:'bar',
                    name:'柱状',
                    data:data

                }]

            }
            youEchart.setOption(option);

        }

        });

    });
</script>

<div id="bar" style="width:600px;height:400px;"></div>

