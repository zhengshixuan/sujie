var vm = new Vue({
    el: '#rrapp',
    data: {
        q: {
            homestayName: null,
            operatorsName: null
        },
        title: null,
        staff: {},
        places: {},
        workPosition:{

        }
    },
    mounted: function () {
        this.getStaffInfo();
        this.getAllWorkPlace();
    },
    methods: {
        saveOrUpdate:function () {
            vm.workPosition.staffId=vm.staff.staffId;
            var data = JSON.stringify(vm.workPosition);
            $.ajax({
                type: "post",
                url: "/staffworkplace/save",
                contentType: "application/json",
                data: data,
                success: function (r) {
                    if (r.code === 0) {
                        window.location.href="";
                    } else {
                        alert(r.msg);
                    }
                }
            });
        },
        getStaffInfo: function () {
            var staffId = $("#staffId").val();
            if (null != staffId && "" != staffId) {
                $.ajax({
                    type: "get",
                    url: "/staffinfo/info/" + staffId,
                    contentType: "application/json",
                    data: {"id": staffId},
                    success: function (r) {
                        if (r.code === 0) {
                            vm.staff = r.staffInfo;
                            // $('#demo1').attr('src', '/staffinfo/getStaffPhoto?id=' + vm.staff.id); //图片链接（base64）
                            // $('#picId').show();
                            // var url='/staffinfo/getStaffPhoto?id=' + vm.staff.id;
                            $('#test1').css("background-image", 'url(' + r.staffInfo.photo + ')').css("background-size", "100% 100%");
                        } else {
                            alert(r.msg);
                        }
                    }
                });
            }

        },
        getAllWorkPlace: function () {
            $.ajax({
                type: "get",
                url: "/getAllWorkPlace",
                contentType: "application/json",
                success: function (r) {
                    if (r.code === 0) {
                        vm.places = r.places;
                    } else {
                        alert(r.msg);
                    }
                }
            });
        },
        goback: function () {
            history.go(-1);
        },
        save: function () {

        }
    }
});

