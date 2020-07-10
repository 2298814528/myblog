function donation(){
    layer.open({
        type: 1
        ,title: false //不显示标题栏
        ,closeBtn: false
        ,area: '300px;'
        ,shade: 0.8
        ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
        ,btn: ['考虑考虑', '辣鸡作者不配']
        ,btnAlign: 'c'
        ,moveType: 1 //拖拽模式，0或者1
        ,content: '<div style="background-color: #393D49; color: #fff; font-weight: 300;text-align: center" align:center><img src="images/vx.jpg" style="height: 300px;width: 300px"></div>'
    });
}