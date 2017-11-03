<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>
    $(function(){


        var myEchart=echarts.init(document.getElementById('map'));

        $.ajax({
            type:'post',
            dataType:'JSON',
            url:'${pageContext.request.contextPath}/user/findCityNum',
            success:function(data){
                option = {
                    title: {
                        text: 'app用户地区分布',
                        subtext: '真实有效',
                        left: 'center'
                    },
                    tooltip: {
                        trigger: 'item'
                    },
                    legend: {
                        orient: 'vertical',
                        left: 'left',
                        data: ['用户分布']
                    },
                    visualMap: {
                        min: 0,
                        max: 300,
                        left: 'left',
                        top: 'bottom',
                        text: ['高', '低'],           // 文本，默认为数值文本
                        calculable: true
                    },
                    toolbox: {
                        show: true,
                        orient: 'vertical',
                        left: 'right',
                        top: 'center',
                        feature: {
                            mark: {show: true},
                            dataView: {show: true, readOnly: false},
                            restore: {show: true},
                            saveAsImage: {show: true}
                        }
                    },
                    series: [
                        {
                            name: '用户分布',
                            type: 'map',
                            mapType: 'china',
                            roam: false,
                            label: {
                                normal: {
                                    show: false
                                },
                                emphasis: {
                                    show: true
                                }
                            },
                            data:data
                        }]
                };

                myEchart.setOption(option);
            }
        });


    });

</script>
<div id="map" style="width:600px;height:400px;"></div>

