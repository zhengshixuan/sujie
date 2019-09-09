var vm = new Vue({
    el: '#rrapp',
    data: {
        showList: true,
        roomInfo: {},
        image:{},
        nessities:{},
        otherImage:[]
    },
    mounted: function () {
        this.getRoomInfo();
    },
    methods: {
        listAll:function () {
            $.ajax({
                type: "post",
                url: "/dictdailynessities/listAll",
                contentType: "application/json",
                success: function (r) {
                    if (r.code === 0) {
                        vm.nessities = r.list;
                    } else {
                        alert(r.msg);
                    }
                }
            });
        },
        getRoomInfo: function () {
            var homestayId = $("#homestayId").val();
            var roomId = $("#roomId").val();
            var data = "{\"homestayId\":\"" + homestayId + "\",\"roomId\":\"" + roomId + "\"}";
            var $img_box = $(".img-box");
            if (null != homestayId && "" != homestayId && null != roomId && "" != roomId) {
                $.ajax({
                    type: "post",
                    url: "/roominfo/getRoomInfo",
                    data: data,
                    contentType: "application/json",
                    success: function (r) {
                        if (r.code === 0) {
                            vm.roomInfo = r.roomInfo;
                            vm.image=vm.roomInfo.image;
                            if(vm.image.length>0){
                                for(var i=0;i<vm.image.length;i++){
                                    $img_box.find("img").eq(vm.image[i].item_code-1).attr("src",vm.image[i].path);
                                    $img_box.parent().find("span").eq(vm.image[i].item_code-1).text(vm.image[i].comments)
                                    if(vm.image[i].item_code==16){
                                        $("#otherImg").parent().find("span").text(vm.image[i].comments);
                                        vm.otherImage.push(vm.image[i].path);
                                    }
                                }
                            }
                        } else {
                            alert(r.msg);
                        }
                    }
                });

            }
        }
    }
});