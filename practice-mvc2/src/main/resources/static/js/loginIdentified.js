<!--    登录验证-->
    $(function () {
    $.get('/cookie_identified',{},function (result){
        if (result.key==="true"){
            $("li.relative.account a.account").text("用户:"+result.name)
            $("li.relative.account").append("<ul>" +
                "<li><a href=\"/order_show\">订单</a></li>"+"<li><a href=\"/logout\">注销</a></li>"+
                "</ul>")
        }else {
            // window.location.href="/login";
        }
    },'json')
})

    //点击验证
    $("li.relative.account a").click(function () {

        $.get('/cookie_identified',{},function (result){
            if (result.key==="true"){
                alert("已登录")
            }else {
                window.location.href="/login";
            }
        },'json')
    })
