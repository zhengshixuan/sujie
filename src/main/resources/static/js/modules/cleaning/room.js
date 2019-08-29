$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + '/roominfo/list',
        datatype: "json",
        colModel: [
            { label: '序号', name: 'id', width: 30, key: true },
            { label: '操作', name: 'id', sortable: false, width: 30,formatter:edit     },
            { label: '房间号', name: 'roomId', width: 100 },
            { label: '品牌名', name: 'homestayName', width: 80 },
            { label: '地址', name: 'roomAddress', width: 80 },
            { label: '房间户型', name: 'roomTypeName', width: 80 },
            { label: '保洁费用', name: 'price', width: 80 },
            { label: '备注', name: 'comments', width: 80 }
        ],
        // viewrecords: true,
        //间隔行样式
        // altRows:true,
        // altclass:"tr_success",
        height: 400,
        rowNum: 10,
        rowList : [10,30,50],
        // rownumbers: true,
        rownumWidth: 25,
        autowidth:true,
        // multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page",
            rows:"limit",
            order: "order"
        },
        gridComplete:function(){
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
        }
    });
});
function edit(cellvalue, options, rowObject) {
    return '<img src="/images/图层1.png" onclick="toUpdateHomestay('+cellvalue+');"></img>';
}
function toUpdateHomestay(id) {
    $.ajax({
        type: "get",
        url: "/listHomestayInfo",
        contentType: "application/json",
        success: function(r){
            if(r.code === 0){
                vm.homestays = r.list;
            }else{
                alert(r.msg);
            }
        }
    });

        $('.ui.modal').modal('show');
}
var vm = new Vue({
    el:'#rrapp',
    data:{
        q:{
            homestayName: null,
            roomAddress:null,
            roomId:null

        },
        title: null,
        homestays: {},
        room:{
            openMethod:0,
            needWashingSheets:0,
            roomType:0
        },
        roomTypes:{},
        showList:true
    },

    mounted:function () {
        this.listHomestay();
        this.getRoomType();
    },
    methods: {
        toAdd:function () {
            window.location.href="/modules/homestay/roomAdd.html";
        },
        listHomestay:function () {
            $.ajax({
                type: "get",
                url: "/listHomestayInfo",
                contentType: "application/json",
                success: function(r){
                    if(r.code === 0){
                        vm.homestays = r.list;
                    }else{
                        alert(r.msg);
                    }
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
                        vm.roomTypes=r.list;
                    }else{
                        alert(r.msg);
                    }
                }
            });
        },
        query: function () {
            vm.reload();
        },
        reload: function (event) {
            var page = $("#jqGrid").jqGrid('getGridParam','page');
            $("#jqGrid").jqGrid('setGridParam',{
                postData:{'homestayName': vm.q.homestayName,'roomId':vm.q.roomId,'roomAddress':vm.q.roomAddress},
                page:page
            }).trigger("reloadGrid");
        },
        clear: function () {
            vm.q.homestayName = null;
            vm.q.operatorsName = null;
        },
        saveOrUpdate:function () {
            var data =  JSON.stringify(vm.homestay);
            $.ajax({
                type: "post",
                url: "/homestayInfo",
                contentType: "application/json",
                data: data,
                success: function(r){
                    if(r.code === 0){
                        alert('操作成功', function(index){
                            window.location.href="/modules/homestay/homestayList.html";
                        });
                    }else{
                        alert(r.msg);
                    }
                }
            });
        }
    }
});

