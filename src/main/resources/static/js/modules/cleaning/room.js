$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + '/roominfo/list',
        datatype: "json",
        colModel: [
            { label: '序号', name: 'id', width: 30, key: true },
            { label: '操作', name: 'id', sortable: false, width: 60 },
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
        height: 385,
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

var vm = new Vue({
    el:'#rrapp',
    data:{
        q:{
            homestayName: null,
            operatorsName:null
        },
        title: null,
        homestay: {}
    },
    methods: {
        query: function () {
            vm.reload();
        },
        reload: function (event) {
            var page = $("#jqGrid").jqGrid('getGridParam','page');
            $("#jqGrid").jqGrid('setGridParam',{
                postData:{'homestayName': vm.q.homestayName,'operatorsName':vm.q.operatorsName},
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

