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
            {label: '优先打扫', name: 'isFirst', width: 80, formatter: isFirst},
            {label: '阿姨选择', name: '', width: 80, formatter: staffList},
            {label: '保洁阿姨费用', name: 'staffCost', width: 80},
            {label: '保洁状态', name: 'statusName', width: 80},
            {label: '操作', name: 'id', width: 80, formatter: toSendOrder}
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
            $("#jqGrid").closest(".ui-jqgrid .ui-jqgrid-btable tbody tr.jqgrow td").css({"overflow": "visible"});
        }
    });

});

function toSendOrder(id, options, rowObject) {
    var html = '<div class="btn-group">' +
        '<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">' +
        '操作 <span class="caret"></span></button>' +
        '<ul class="dropdown-menu">' +
        '<li><a href="javascript:sendOrder(' + id + ')">派单</a></li>' +
        '<li><a href="javascript:getLastCleanRecord(\''+rowObject.homestayId+'\',\''+rowObject.roomId+'\')">查看详情</a></li></ul></div>';
    return html;
}
function getLastCleanRecord(homestayId,roomId) {
    window.location.href="/comm/getRoomWorkedRecord?homestayId="+homestayId+"&roomId="+roomId;
}
function sendOrder(id){
    // var staffName = $("#jqGrid").find("tr").eq(index).find("td select").val();
    var data ="{\"id\":\"1\",\"staffId\":\"2\"}";
    $.ajax({
        type: "post",
        url: "/order/sendOrder",
        data:data,
        contentType: "application/json",
        success: function (r) {
            if (r.code == 0) {
                alert("派单成功");
            } else {
                alert(r.msg);
            }
        }
    });
}

function staffList(value, options, rowObject) {
    var staffNameArr = new Array();
    var staffIdArr = new Array();

    if (staffNameArr.length == 0) {
        $.ajax({
            type: "get",
            url: "/staffinfo/listAllStaff",
            contentType: "application/json",
            async: false,
            success: function (r) {
                if (r.code == 0) {
                    var data = r.list;
                    for (var i = 0; i < data.length; i++) {
                        staffNameArr.push(data[i].staff_name);
                        staffIdArr.push(data[i].staff_id);
                    }
                } else {
                    alert(r.msg);
                }
            }
        });
    }
    var select = '';
    if (staffNameArr.length > 0) {
        // value = "李阿姨,张阿姨,王阿姨";
        // var dataV = staffNameArr.split(",");
        // var dataK = staffIdArr.splice(",")
        select = '<select class="demo" multiple="multiple">';
        for (var i = 0; i < staffNameArr.length; i++) {
            select = select + '<option value="' + staffIdArr[i] + '">';
            select = select + staffNameArr[i];
            select = select + '</option>';
        }
        select = select + '</select>';
        select = select + commitList();
    }
    return select;


}


function commitList() {
    var commit = '<script>$(function () {$(' + "'" + '.demo' + "'" + ').fSelect();});</script>';
    return commit;
}

function isFirst(value, options, rowObject) {
    if ("0" == value) {
        return "是";
    } else {
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
        staffinfo: {},
        homestay: {
            isVip: 0,
            isReception: 0
        }
    },
    // mounted: function () {
    //     this.getStaffList();
    // },
    method: {
        getStaffList: function () {
            $.ajax({
                type: "get",
                url: "/staffinfo/listAllStaff",
                contentType: "application/json",
                success: function (r) {
                    if (r.code == 0) {
                        vm.room = r.roomInfo;
                        vm.staffinfo = r.list;
                    } else {
                        alert(r.msg);
                    }
                }
            });
        }
    }
});

