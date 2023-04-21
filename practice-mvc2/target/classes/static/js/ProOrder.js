//下单查询购物车商品数量
window.pro_num = 0;
$(".btn-proceed-checkout.full-width.top-margin-15-default.pro_detele").hide()
$.get('/read2',{},function (result) {
    var list = result.list
    $(".count-total-shopping.absolute").text(list.length)
    var sum =0;
    var totalsum=0
    for (let i = 0; i < list.length; i++) {
        $.get('/read',{id:list[i].pId},function (result) {
                $(".full-width.relative.overfollow-hidden").append("" +
                    "<div class=\"relative clearfix full-width product-order-sidebar border no-border-t no-border-r no-border-l\">" +
                    "<label class='boxsum' value='0' for='pro_id'><input type='hidden' name='pro_num' value='"+list[i].num+"'/><input class='order_item"+i+" 'type='checkbox' name='pro_id' placeholder='true'/></label><div class=\"image-product-order-sidebar center-vertical-image\">" +
                    "        <img src=\"img/file/"+result.production.img+"\" alt=\"\"/>" +
                    "    </div>" +
                    "    <div class=\"relative info-product-order-sidebar"+i+"\">" +
                    "<p class=\"title-product top-margin-15-default animate-default title-hover-black\">" +
                    "<a href='/product_view?id="+list[i].pId+"'>"+result.production.name+" x"+list[i].num+"</a></p>" +
                    "<p price='"+result.production.price*list[i].num+"' class=\"price-product\">$"+result.production.price*list[i].num+"</p>" +
                    "    </div>"+"</input>"+"</div>")
            totalsum+=parseInt(list[i].num)
            sum += result.production.price*list[i].num

            $(".order_item"+i).attr("value",list[i].pId)
            $(".totalsum").attr("value",totalsum)

            $(".text-red.price-shoping-cart").text("$"+sum)
            $(".text-red.price-shoping-cart").attr("value",sum)
        },'json')
    }
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











