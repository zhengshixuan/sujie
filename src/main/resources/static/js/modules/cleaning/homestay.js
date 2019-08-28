$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + '/homestayInfos',
        datatype: "json",
        colModel: [
            {label: '序号', name: 'id', width: 30, key: true},
            {label: '操作', name: 'id', sortable: false, width: 60,formatter:edit},
            {label: '民宿品牌', name: 'homestayName', width: 100},
            {label: '名字', name: 'operatorsName', width: 80},
            {label: '电话', name: 'operatorsTelephone', width: 80},
            {label: '备注', name: 'comments', width: 80}
        ],
        // viewrecords: true,
        //间隔行样式
        // altRows:true,
        // altclass:"tr_success",
        height: 385,
        rowNum: 10,
        rowList: [10, 30, 50],
        // rownumbers: true,
        rownumWidth: 25,
        autowidth: true,
        // multiselect: true,
        pager: "#jqGridPager",
        jsonReader: {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order"
        },
        gridComplete: function () {
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }
    });
});

function edit(cellvalue, options, rowObject) {
    return '<img src="/images/修改icon.png" onclick="toUpdateHomestay('+cellvalue+');"></img>';
}
function toUpdateHomestay(id) {
    window.location.href = "/comm/toUpdateHomestay?homestayId=" + id;
}

var vm = new Vue({
    el: '#rrapp',
    data: {
        q: {
            homestayName: null,
            operatorsName: null
        },
        title: null,
        homestay: {
            isVip:0,
            isReception:0
        }
    },
    mounted:function () {
        this.queryHomestay();
    },
    methods: {
        queryHomestay:function () {
            var homestayId = $("#homestayId").val();
            if(null!=homestayId&&""!=homestayId){
                $.ajax({
                    type: "get",
                    url: "/homestayInfo/"+homestayId,
                    contentType: "application/json",
                    success: function (r) {
                        if (r.code === 0) {
                            vm.homestay=r.homestayInfo;
                        } else {
                            alert(r.msg);
                        }
                    }
                });
            }
        },
        query: function () {
            vm.reload();
        },
        reload: function (event) {
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {'homestayName': vm.q.homestayName, 'operatorsName': vm.q.operatorsName},
                page: page
            }).trigger("reloadGrid");
        },
        clear: function () {
            vm.q.homestayName = null;
            vm.q.operatorsName = null;
        },
        toAdd: function () {
            window.location.href = "/modules/homestay/homestayAdd.html";
        },
        isNotNull: function (value) {
            if (null == value || "" == value) {
                return false;
            } else {
                return true;
            }
        },
        checkTelephone: function (value) {
            var regex = /^1[3456789]\d{9}$/;
            return regex.test(value);
        },
        goback:function () {
            history.go(-1);
        },
        saveOrUpdate: function () {
            var data = JSON.stringify(vm.homestay);
            var homestayName = vm.homestay.homestayName;
            var address = vm.homestay.homestayAddress;
            var bossName = vm.homestay.bossName;
            var bossTelephone = vm.homestay.bossTelephone;
            var operatorsName = vm.homestay.operatorsName;
            var operatorsTelephone = vm.homestay.operatorsTelephone;
            var password = vm.homestay.password;
            var roomNumber = vm.homestay.roomsNumber;
            if (!this.isNotNull(homestayName)) {
                alert("民宿名称不能为空！");
                return;
            }
            if (!this.isNotNull(address)) {
                alert("民宿地址不能为空！");
                return;
            }
            if (!this.isNotNull(bossName)) {
                alert("经营者姓名不能为空！");
                return;
            }
            if (!this.isNotNull(operatorsName)) {
                alert("运营者姓名不能为空！");
                return;
            }
            if (!this.isNotNull(password)) {
                alert("密码不能为空！");
                return;
            }
            if (!this.checkTelephone(bossTelephone)) {
                alert("请输入正确的经营者手机号！");
                return;
            }
            if (!this.checkTelephone(operatorsTelephone)) {
                alert("请输入正确的运营者手机号！");
                return;
            }if(!/^[0-9]*$/.test(roomNumber)){
                alert("请输入正确的房间数！");
                return;
            }
            var homestayId = $("#homestayId").val();
            var url ;
            if(null!=homestayId&&""!=homestayId){
                url="/updateHomeStayInfo";
            }else {
                url="/homestayInfo"
            }

            $.ajax({
                type: "post",
                url: url,
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
        }
    }
});

