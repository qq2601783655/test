<!--商品浏览-->
$.get('/readproduction',{},function (result) {
    let pros = result.list;
    for(var i=0;i<pros.length;i++){
        // 把html转换为字符串、拼接商品数据
        var dom_str = "<div class=\"col-md-4 col-sm-4 col-xs-12 product-category relative effect-hover-boxshadow animate-default\">\n" +
            "                                <div class=\"image-product relative overfollow-hidden\">\n" +
            "                                    <div class=\"center-vertical-image\">\n" +
            "                                        <img src=\"/img/file/"+pros[i].img+"\" alt=\"Product\">\n" +
            "                                    </div>\n" +
            "                                    <a href=\"product_view/\"></a>\n" +
            "                                    <ul class=\"option-product animate-default\">\n" +
            "                                        <li class=\"relative\"><a href=\"checkout_single?pro_id="+pros[i].proId+"&num=1"+"\"><i\n" +
            "                                                class=\"data-icon data-icon-ecommerce icon-ecommerce-bag\"></i></a></li>\n" +
            "                                        <li class=\"relative\"><a href=\"#\"><i\n" +
            "                                                class=\"data-icondata-icon-basic icon-basic-heart\"\n" +
            "                                                aria-hidden=\"true\"></i></a></li>\n" +
            "                                        <li class=\"relative\"><a href=\"javascript:;\"><i\n" +
            "                                                class=\"data-icon data-icon-basic icon-basic-magnifier\"\n" +
            "                                                aria-hidden=\"true\"></i></a></li>\n" +
            "                                    </ul>\n" +
            "                                </div>\n" +
            "                                <h3 class=\"title-product clearfix full-width title-hover-black\"><a href=\"product_view?id="+pros[i].proId+"\">" + pros[i].name + "</a></h3>\n" +
            "                                <p class=\"clearfix price-product\"><span class=\"price-old\">$" + pros[i].price + "</span> $" + pros[i].price + "</p>\n" +
            "                                <div class=\"clearfix ranking-product-category ranking-color\">\n" +
            "                                    <i class=\"fa fa-star\" aria-hidden=\"true\"></i>\n" +
            "                                    <i class=\"fa fa-star\" aria-hidden=\"true\"></i>\n" +
            "                                    <i class=\"fa fa-star\" aria-hidden=\"true\"></i>\n" +
            "                                    <i class=\"fa fa-star-half\" aria-hidden=\"true\"></i>\n" +
            "                                    <i class=\"fa fa-star-o\" aria-hidden=\"true\"></i>\n" +
            "                                </div>\n" +
            "                            </div>";
        //3、在pro_list_box添加dom节点【图片的div】
        $('#pro_list_box').append($(dom_str));
    }
},'json')