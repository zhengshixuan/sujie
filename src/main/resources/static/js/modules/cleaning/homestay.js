$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + '/homestayInfos',
        datatype: "json",
        colModel: [
            { label: '序号', name: 'id', width: 30, key: true },
            { label: '操作', name: 'id', sortable: false, width: 60 },
            { label: '民宿品牌', name: 'homestayName', width: 100 },
            { label: '名字', name: 'operatorsName', width: 80 },
            { label: '电话', name: 'operatorsTelephone', width: 80 },
            { label: '备注', name: 'comments', width: 80 }
        ],
        viewrecords: true,
        // altRows:true,
        // altclass:"tr_success",
        height: 385,
        rowNum: 10,
        rowList : [10,30,50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth:true,
        multiselect: true,
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
            paramKey: null
        },
        title: null,
        config: {}
    },
    methods: {
        query: function () {
            vm.reload();
        },
        reload: function (event) {
            var page = $("#jqGrid").jqGrid('getGridParam','page');
            $("#jqGrid").jqGrid('setGridParam',{
                postData:{'paramKey': vm.q.paramKey},
                page:page
            }).trigger("reloadGrid");
        }
    }
});

