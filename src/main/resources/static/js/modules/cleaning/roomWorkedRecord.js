$(function () {
    $(".img").click(function () {
        var path = $(this).attr("src");

        // layer.open({
        //     type: 1,
        //     title: false,
        //     closeBtn: 0,
        //     shadeClose: true,
        //     skin: 'yourclass',
        //     content: '自定义HTML内容'
        // });
        layer.open({
            type: 1,
            title: false,
            closeBtn: 1,
            area: '516px',
            offset:'100px',
            skin: 'layui-layer-nobg', //没有背景色
            shadeClose: true,
            content: '<img style="width:100%;height: 100%;top:100px;" src="'+path+'"></img>'
        });


        // $(this).attr("width","300px").attr("height","200px");
    });
});

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
            var $more_img_box = $("#toiletPic");
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
                                    if(vm.image[i].item_code==5){
                                        $("#toilet1").find("img").attr("src",vm.image[i].path);
                                        $more_img_box.parent().find("span").text(vm.image[i].comments)
                                    }else if(vm.image[i].item_code==6){
                                        $("#toilet2").find("img").attr("src",vm.image[i].path);
                                        $more_img_box.parent().find("span").text(vm.image[i].comments)
                                    }else if(vm.image[i].item_code==7){
                                        $("#toilet3").find("img").attr("src",vm.image[i].path);
                                        $more_img_box.parent().find("span").text(vm.image[i].comments)
                                    }else if(vm.image[i].item_code==16){
                                        $("#otherImg").parent().find("span").text(vm.image[i].comments);
                                        vm.otherImage.push(vm.image[i].path);
                                    }
                                }
                                if(vm.otherImage.length<3){
                                    for(var i=0;i<=3-vm.otherImage.length;i++){
                                        vm.otherImage.push("../../images/logo.png");
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