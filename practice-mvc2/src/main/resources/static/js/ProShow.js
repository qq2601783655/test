
$(function (){
    //在jq中修改获取Url参数的方法
    $.getUrlParam=function (name) {
        var reg=new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r=window.location.search.substr(1).match(reg);
        if (r !=null) return unescape(r[2]); return null;
    }
    //1、发起异步请求获取商品列表的数据
    $.get('/read',{id:$.getUrlParam('id')},function (reuslt){
        //2、数据拿到--通过jq函数来修改dom中的数值
        $('#product_content .name-product').text(reuslt.production.name);
        $('#product_content .price-old').text('$'+reuslt.production.price);
        $('#product_content .price-new').text('$'+reuslt.production.price);
        $('#pro_information').text(reuslt.production.information);
    },'json');
    // alert(id=$.getUrlParam('id'));
    <!--商品图片异步请求-->
    $.get('/read1',{pid:$.getUrlParam('id')},function (result) {

        $("#owl-big-slide img:eq(0)").attr("src","img/file/"+result.list[0].imgname)
        $("#owl-big-slide img:eq(1)").attr("src","img/file/"+result.list[1].imgname)
        $("#owl-big-slide img:eq(2)").attr("src","img/file/"+result.list[2].imgname)
        $("#owl-big-slide img:eq(3)").attr("src","img/file/"+result.list[3].imgname)

        $("#owl-thumbnail-slide img.show_little_img1").attr("src","img/file/"+result.list[0].imgname)
        $("#owl-thumbnail-slide img.show_little_img2").attr("src","img/file/"+result.list[1].imgname)
        $("#owl-thumbnail-slide img.show_little_img3").attr("src","img/file/"+result.list[2].imgname)
        $("#owl-thumbnail-slide img.show_little_img4").attr("src","img/file/"+result.list[3].imgname)
    },'json')

});