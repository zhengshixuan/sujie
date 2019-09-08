$(function () {
    var staffId = $("#staffId").val();
    vm.staffCommission.staffId= staffId;
});
var vm = new Vue({
    el:'#rrapp',
    data:{
        q:{
            staffName: null,
            staffType: null
        },
        title: null,
        staffCommission: {
            staffType:0,
            roomType:0
        },
        roomType:{

        }
    },
    mounted:function () {
        this.getRoomType();
    },
    methods: {
        query: function () {
            vm.reload();
        },
        save:function () {
            var id = $("#id").val();
            vm.staffCommission.id = id;
            var data = JSON.stringify(vm.staffCommission);
            var extraFee = vm.staffCommission.extraFee;
            var commission = vm.staffCommission.commission;
            if(!/^(([1-9]\d*)|\d)(\.\d{1,2})?$/.test(commission)){
                alert("房间提成只能为数字!");
                return;
            }
            if(!/^(([1-9]\d*)|\d)(\.\d{1,2})?$/.test(extraFee)){
                alert("加床费用只能为数字!");
                return;
            }
            $.ajax({
                type: "post",
                url: "/staffcommission/save",
                contentType: "application/json",
                data: data,
                success: function (r) {
                    if (r.code === 0) {
                        alert('操作成功', function (index) {
                            window.location.href = "/modules/homestay/staffList.html";
                        });
                    } else {
                        alert(r.msg);
                    }
                },error:function () {
                    alert("保存失败！");
                }
            });
        },
        getRoomType: function (event) {
            $.ajax({
                type: "post",
                url: "/dictroomtype/list",
                contentType: "application/json",
                success: function(r){
                    if(r.code === 0){
                            vm.roomType=r.list;

                    }else{
                        alert(r.msg);
                    }
                }
            });
        },goback:function () {
            history.go(-1);
        }
    }
});

