var vm = new Vue({
    el: '#rrapp',
    data: {
        showList: true,
        roomInfo: {}
    },
    mounted: function () {
        this.getRoomInfo();
    },
    methods: {
        getRoomInfo: function () {
            var homestayId = $("#homestayId").val();
            var roomId = $("#roomId").val();
            var data = "{\"homestayId\":\"" + homestayId + "\",\"roomId\":\"" + roomId + "\"}";

            if (null != homestayId && "" != homestayId && null != roomId && "" != roomId) {
                $.ajax({
                    type: "post",
                    url: "/roominfo/getRoomInfo",
                    data: data,
                    contentType: "application/json",
                    success: function (r) {
                        if (r.code === 0) {
                            vm.roomInfo = r.roomInfo;
                        } else {
                            alert(r.msg);
                        }
                    }
                });

            }
        }
    }
});