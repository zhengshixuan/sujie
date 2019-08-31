$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + '/order/listRoomCleanRecord',
        datatype: "json",
        colModel: [
            { label: '序号', name: 'id', width: 30, key: true },
            { label: '保洁时间', name: 'actualCleanDate', sortable: false, width: 60},
            { label: '品牌名', name: 'homestayName', width: 100 },
            { label: '地址', name: 'homestayAddress', width: 80 },
            { label: '房间号', name: 'roomId', width: 80 },
            { label: '房间户型', name: 'roomType', width: 80 },
            { label: '保洁费用', name: 'staffCost', width: 80 },
            { label: '保洁阿姨', name: 'staffName', width: 80 },
            { label: '特殊说明', name: 'comments', width: 80 }
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
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#actualCleanDate', //指定元素
            done: function (value) {
                vm.q.actualCleanDate = value;
            }
        });
    });
});
var vm = new Vue({
    el:'#rrapp',
    data:{
        q:{
            homestayName: null,
            homestayAddress:null,
            roomId:null,
            actualCleanDate:null
        }
    },
    methods: {
        query: function () {
            vm.reload();
        },
        reload: function (event) {
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {'homestayName': vm.q.homestayName, 'homestayAddress': vm.q.homestayAddress,'roomId':vm.q.roomId,
                    'actualCleanDate':vm.q.actualCleanDate},
                page: page
            }).trigger("reloadGrid");
        },
    }
});

