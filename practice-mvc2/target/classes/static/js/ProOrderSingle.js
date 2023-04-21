//下单查询购物车商品数量
$(".btn-proceed-checkout.full-width.top-margin-15-default.pro_detele").hide()
//在jq中修改获取Url参数的方法
$.getUrlParam=function (name) {
    var reg=new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r=window.location.search.substr(1).match(reg);
    if (r !=null) return unescape(r[2]); return null;
}
        var totalsum=0
        var sum=0
        $.get('/read',{id:$.getUrlParam("pro_id")},function (result) {
            num=$.getUrlParam("num")
            $(".full-width.relative.overfollow-hidden").append("" +
                "<div class=\"relative clearfix full-width product-order-sidebar border no-border-t no-border-r no-border-l\">" +
                "<label class='boxsum' value='0' for='pro_id'><input type='hidden' name='pro_num' value='"+num+"'/><input class='order_item'type='checkbox' name='pro_id' placeholder='true'/></label><div class=\"image-product-order-sidebar center-vertical-image\">" +
                "        <img src=\"img/file/"+result.production.img+"\" alt=\"\"/>" +
                "    </div>" +
                "    <div class=\"relative info-product-order-sidebar\">" +
                "<p class=\"title-product top-margin-15-default animate-default title-hover-black\">" +
                "<a href='/product_view?id="+result.production.proId+"'>"+result.production.name+" x"+num+"</a></p>" +
                "<p price='"+result.production.price*num+"' class=\"price-product\">$"+result.production.price*num+"</p>" +
                "    </div>"+"</input>"+"</div>")
            totalsum+=parseInt(num)
            sum += result.production.price*num

            $(".order_item").attr("value",result.production.proId)
            $(".totalsum").attr("value",totalsum)

            $(".text-red.price-shoping-cart").text("$"+sum)
            $(".text-red.price-shoping-cart").attr("value",sum)
        },'json')



//出现delete
var pro_item_namager=0
$(".pro_item_manager").on("click",function () {
    if (pro_item_namager==0){
        $(".btn-proceed-checkout.full-width.top-margin-15-default.pro_detele").show()
        pro_item_namager=1
    }else {
        $(".btn-proceed-checkout.full-width.top-margin-15-default.pro_detele").hide()
        pro_item_namager=0
    }
})

$(".btn-proceed-checkout.full-width.top-margin-15-default.pro_detele").on("click",function () {
    $(".sub_form").attr("action","/deleteitem")
})

var orderSum=0;
for (let i = 0; i <$(".full-width.relative.overfollow-hidden").children().length ; i++) {

    var price=0;
    $(".full-width.relative.overfollow-hidden").on("click",".order_item"+i,function () {

        if ($(this).prop("checked")){
            price += parseInt($(".relative.info-product-order-sidebar"+i+" p.price-product").attr("price"))
        }
        else {
            price -= parseInt($(".relative.info-product-order-sidebar"+i+" p.price-product").attr("price"))
        }



        $(".text-red.price-shoping-cart.Order_total").text("")
        $(".text-red.price-shoping-cart.Order_total").text("$"+price)

    })



}














//











