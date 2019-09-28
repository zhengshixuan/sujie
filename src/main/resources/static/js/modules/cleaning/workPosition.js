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
        workPosition: {}
    },
    mounted: function () {
        this.getStaffInfo();
        this.getAllWorkPlace();

    },
    methods: {
        saveOrUpdate: function () {
            vm.workPosition.staffId = vm.staff.staffId;
            vm.workPosition.id=null;
            var data = JSON.stringify(vm.workPosition);
            $.ajax({
                type: "post",
                url: "/staffworkplace/save",
                contentType: "application/json",
                data: data,
                success: function (r) {
                    if (r.code === 0) {
                        alert(r.msg);

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
                            vm.getWorkPosition();
                            // $('#demo1').attr('src', '/staffinfo/getStaffPhoto?id=' + vm.staff.id); //图片链接（base64）
                            // $('#picId').show();
                            // var url='/staffinfo/getStaffPhoto?id=' + vm.staff.id;
                            // $('#test1').css("background-image", 'url(' + r.staffInfo.photo + ')').css("background-size", "100% 100%");
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
                        if (r.places != null) {
                            vm.places = r.places;
                        }
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

        },
        getWorkPosition: function () {
            var staffId = vm.staff.staffId;
            if (null != staffId && "" != staffId) {
                $.ajax({
                    type: "get",
                    url: "/staffworkplace/getWorkPosition",
                    contentType: "application/json",
                    data: {"staffId": staffId},
                    success: function (r) {
                        if (r.code === 0) {
                            if (null != r.map) {
                                vm.workPosition = r.map;
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

