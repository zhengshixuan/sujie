$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + '/roominfo/list',
        datatype: "json",
        colModel: [
            {label: '序号', name: 'id', width: 30, key: true},
            {label: '操作', name: 'id', sortable: false, width: 30, formatter: vm.edit},
            {label: '房间号', name: 'roomId', width: 100},
            {label: '品牌名', name: 'homestayName', width: 80},
            {label: '地址', name: 'homestayAddress', width: 80},
            {label: '房间户型', name: 'roomTypeName', width: 80},
            {label: '保洁费用', name: 'price', width: 80},
            {label: '备注', name: 'comments', width: 80}
        ],
        // viewrecords: true,
        //间隔行样式
        // altRows:true,
        // altclass:"tr_success",
        height: 400,
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

// function edit(cellvalue, options, rowObject) {
//     return '<img src="/images/图层1.png" onclick="toUpdateHomestay(' + cellvalue + ');"></img>';
// }


var vm = new Vue({
    el: '#rrapp',
    data: {
        q: {
            homestayName: null,
            homestayAddress: null,
            roomId: null

        },
        title: null,
        homestays: {},
        room: {
            openMethod: 0,
            needWashingSheets: 0,
            roomType: 0,
            path: [],
            imageType: [],
            imageDes: []
        },
        roomTypes: {},

        showList: true
    },
    mounted: function () {
        this.listHomestay();
        this.getRoomType();
        this.getRoomInfo();
    },
    methods: {
        getRoomInfo:function () {
            var id = $("#id").val();
            if(null!=id&&""!=id){
                $.ajax({
                    type: "get",
                    url: "/roominfo/info/"+id,
                    contentType: "application/json",
                    success: function (r) {
                        if (r.code === 0) {
                            vm.room=r.roomInfo;
                            for (var i=0;i<vm.room.path.length;i++){
                                if(null!=vm.room.path[i]&&'null'!=vm.room.path[i]&&''!=vm.room.path[i]){
                                    $('.layui-btn').eq(i).css("background-image",'url(' + vm.room.path[i]+')').css("background-size","100% 100%");
                                }
                            }

                        } else {
                            alert(r.msg);
                        }
                    }
                });

            }
        },
        toAdd: function () {
            window.location.href = "/modules/homestay/roomAdd.html";
        },
        listHomestay: function () {
            $.ajax({
                type: "get",
                url: "/listHomestayInfo",
                contentType: "application/json",
                success: function (r) {
                    if (r.code === 0) {
                        vm.homestays = r.list;


                    } else {
                        alert(r.msg);
                    }
                }
            });
        },
        edit: function (cellvalue, options, rowObject) {
            var img = '<img src="/images/修改icon.png" alt="提成" title="提成" onclick="vm.toUpdateRoom(' + cellvalue + ');"></img>&nbsp;';
            return img;
        },
        toUpdateRoom:function (id) {
            window.location.href = "/comm/toUpdateRoom?id=" + id;
        },
        getRoomType: function (event) {
            $.ajax({
                type: "post",
                url: "/dictroomtype/list",
                contentType: "application/json",
                success: function (r) {
                    if (r.code === 0) {
                        vm.roomTypes = r.list;
                    } else {
                        alert(r.msg);
                    }
                }
            });
        },
        query: function () {
            vm.reload();
        },
        reload: function (event) {
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {
                    'homestayName': vm.q.homestayName,
                    'roomId': vm.q.roomId,
                    'homestayAddress': vm.q.homestayAddress
                },
                page: page
            }).trigger("reloadGrid");
        },
        clear: function () {
            vm.q.homestayName = null;
            vm.q.operatorsName = null;
        },
        saveOrUpdate: function () {
            var id = $("#id").val();
            if(null!=id&&""!=id){
                var url = "/roominfo/update";
            }else{
                var url = "/roominfo/save";
            }
            var data = JSON.stringify(vm.room);

            $.ajax({
                type: "post",
                url: url,
                contentType: "application/json",
                data: data,
                success: function (r) {
                    if (r.code === 0) {
                        alert('操作成功', function (index) {
                            window.location.href = "/modules/homestay/roomList.html";
                        });
                    } else {
                        alert(r.msg);
                    }
                }
            });
        },
        goback: function () {
            history.go(-1);
        }
    }
});

