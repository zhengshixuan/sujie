$(function () {
    $('.my-set').on('click', function () {
        var src1 = $('.selectname').val()
        var src2 = $('.selectaddress').val()
        var src3 = $('.selectmoney').val()
        var src4 = $('.selectnum').val()
    })
    $('.my-clear').on('click', function () {
        $('.selectname').val('')
        $('.selectaddress').val('')
        $('.selectmoney').val('')
        $('.selectnum').val('')
    })
})
var vm = new Vue({
    el: '#rrapp',
    data: {
        title: null,
        homestays: {},
        homestay: {}

    }, mounted: function () {
        this.listHomestay();
    },
    methods: {
        save: function () {
            var balance = vm.homestay.balance;
            if(!/^(([1-9]\d*)|\d)(\.\d{1,2})?$/.test(balance)){
                alert("充值金额只能为数字")
                return;
            }
            var data = JSON.stringify(vm.homestay);
            $.ajax({
                type: "post",
                url: "/updateHomeStayInfo",
                contentType: "application/json",
                data: data,
                success: function (r) {
                    if (r.code === 0) {
                        alert('操作成功', function (index) {
                            window.location.href = "/modules/homestay/homestayList.html";
                        });
                    } else {
                        alert(r.msg);
                    }
                }
            });
        },
        listHomestay: function () {
            $.ajax({
                type: "get",
                url: "/listHomestayInfo",
                contentType: "application/json",
                success: function (r) {
                    if (r.code === 0) {
                        vm.homestays = r.list;
                        if (null != vm.homestays && vm.homestays.length > 0) {
                            vm.homestay.id = vm.homestays[0].id;
                        }
                    } else {
                        alert(r.msg);
                    }
                }
            });
        }
    }
});

