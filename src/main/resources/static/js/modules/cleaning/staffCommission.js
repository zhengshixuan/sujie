var vm = new Vue({
    el:'#rrapp',
    data:{
        q:{
            staffName: null,
            staffType: null
        },
        title: null,
        staffCommission: {},
        roomType:{}
    },
    mounted:function () {
        this.getRoomType();
    },
    methods: {
        query: function () {
            vm.reload();
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
        }
    }
});

