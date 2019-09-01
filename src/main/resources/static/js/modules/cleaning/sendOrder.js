$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + '/order/listPrepareCleanOrder',
        datatype: "json",
        colModel: [
            {label: '序号', name: 'id', width: 30, key: true},
            {label: '房间号', name: 'roomId', sortable: false, width: 60},
            {label: '地址', name: 'homestayAddress', width: 100},
            {label: '品牌名', name: 'homestayName', width: 80},
            {label: '保洁时间', name: 'preCleanDate', width: 80},
            {label: '保洁老板费用', name: 'bossCost', width: 80},
            {label: '优先打扫', name: 'isFirst', width: 80,formatter:isFirst},
            {label: '阿姨选择', name: '', width: 80},
            {label: '保洁阿姨费用', name: 'staffCost', width: 80},
            {label: '保洁状态', name: 'statusName', width: 80}
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

function staffList(value,options,rowObject) {
    var select= '<select class="demo" multiple="multiple">'+
        '<option value="cp">李阿姨</option>'+
        '<option value="cp">张阿姨</option>'+
        '</select>'
    return select;
}

function isFirst(value, options, rowObject) {
    if("0"==value){
        return "是";
    }else{
        return "否"
    }
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
    }
});

