//<!--    用户购物车商品查询-->
$.get('/read2',{},function (result) {
    var list = result.list
    $(".count-total-shopping.absolute").text(list.length)
    var sum =0;
    console.log(list.length)
    for (let i = 0; i < list.length; i++) {
        $.get('/read',{id:list[i].pId},function (result) {
            $("div.cart-detail-header.border div.relative.join").append(""
                +"<div class=\"product-cart-son clearfix\">"
                +"<div class=\"image-product-cart float-left center-vertical-image \">"
                +"<a href=\"#\"><img src=\"img/file/"+result.production.img+"\" alt=\"\"/></a></div>"
                +"<div class=\"info-product-cart float-left\">"
                +"<p class=\"title-product title-hover-black\"><a class=\"animate-default\" href=\"#\">"+result.production.name+"</a>"
                +"</p><p class=\"clearfix price-product\">$"+result.production.price*list[i].num+" <span class=\"total-product-cart-son\">(x"+list[i].num+")</span></p>"
                +"</div></div>"
            )
            sum+=parseInt(result.production.price)*list[i].num
            $(".relative.border.no-border-l.no-border-r.total-cart-header p:eq(1)").text("$"+sum)
        },'json')
    }
},'json')

//<!--    提交商品至购物车-->
$(".clear-margin.top-margin-default.clearfix.bottom-margin-default").click(function () {
    $.get("/submit_pro",{num:$(".left-margin-15-default").val(),pid:$.getUrlParam('id')},function (result) {
        if (result.status==="false"){
            alert("没有登录")
            window.location.href="/login"
        }else {
            location.reload(true);
        }

    },'json')
})