$(function () {

    $('.main-box').on('click', '.fold', function () {
        // console.log($(this).parent('.content-top').siblings());

        // console.log($(this).parent().siblings().hasClass("control"))
        // // 如果存在这个属性
        // if($(this).parent().siblings().hasClass("control")){
        //   $(this).parent().siblings().show();
        //   $(this).parent().siblings().removeClass("control")
        // }else{
        //   $(this).parent().siblings().hide();
        //   $(this).parent().siblings().addClass("control")
        // }
        // console.log($(this).parent().siblings().hasClass("control"))
        // // 如果存在这个属性
        if ($(this).parents('.content-top').siblings().hasClass("control")) {

            $(this).parents('.content-top').siblings().show();
            $(this).parents('.content-top').siblings().removeClass("control")
            // var address = $(this).find("input").val();
            // vm.getPreparOrderDetail(address);
        } else {
            $(this).parents('.content-top').siblings().hide();
            $(this).parents('.content-top').siblings().addClass("control")
        }


    })

})

var vm = new Vue({
    el: '#rrapp',
    data: {
        title: null,
        preparOrders: {},
        // preparOrdersDetail:{},
        total:0
    },
    mounted: function () {
        this.getPreparOrder();
    },
    methods: {
        getPreparOrder: function () {
            $.ajax({
                type: "get",
                url: "/order/listPreOrder",
                contentType: "application/json",
                success: function (r) {
                    if (r.code === 0) {
                        vm.preparOrders = r.preparOrders;
                        vm.total = r.total;
                    } else {
                        alert(r.msg);
                    }
                }
            });
        },
        getPreparOrderDetail:function (homestayAddress) {
            if(homestayAddress!=null&&homestayAddress!=""){

                $.ajax({
                    type: "get",
                    url: "/order/listPreOrderDetail",
                    contentType: "application/json",
                    data:{"homestayAddress":homestayAddress},
                    success: function (r) {
                        if (r.code === 0) {
                            vm.preparOrdersDetail = r.preparOrdersDetail;
                        } else {
                            alert(r.msg);
                        }
                    }
                });
            }else{
                alert("查询失败！");
            }
        }
    }
});

