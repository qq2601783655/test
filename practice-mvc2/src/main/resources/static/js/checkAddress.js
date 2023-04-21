
for (let j = 0; j <$(".full-width.relative.overfollow-hidden").children().length ; j++) {
    var checksum =0;
    $(".full-width.relative.overfollow-hidden").on("click",".order_item"+j,function () {
        if ($(this).prop("checked")){
            checksum+=1;
        }
        else {
            checksum-=1;
        }
    })

}

$(".full-width.relative.overfollow-hidden").on("click",".order_item",function () {
    if ($(this).prop("checked")){
        checksum+=1;
    }
    else {
        checksum-=1;
    }
})



$(".btn-proceed-checkout.full-width.top-margin-15-default.pro_check").on("click",function () {

    for (let i = 0; i < $(".relative.clearfix.full-width").children().length; i++) {

        if ($(".relative.clearfix.full-width input:eq("+i+")").attr("name")==="address"||$(".relative.clearfix.full-width input:eq("+i+")").attr("name")==="receiver"
            ||$(".relative.clearfix.full-width input:eq("+i+")").attr("name")==="mobile"){
            if($(".relative.clearfix.full-width input:eq("+i+")").val()==""){
                alert("没有填写收货信息")
                $("form").attr("onsubmit","return false")
                return
            }else {
                $("form").attr("onsubmit","")
            }
        }

        if (checksum==0){
            alert("没有选择商品")
            $("form").attr("onsubmit","return false")
            return;
        }else {
            $("form").attr("onsubmit","")
        }

    }






})