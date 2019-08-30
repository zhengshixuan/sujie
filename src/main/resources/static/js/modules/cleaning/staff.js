$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + '/staffinfo/list',
        datatype: "json",
        colModel: [
            {label: '序号', name: 'id', width: 30, key: true},
            {label: '操作', name: 'id', sortable: false, width: 60, formatter: edit},
            {label: '阿姨类别', name: 'staffType', width: 100, formatter: staffType},
            {label: '名字', name: 'staffName', width: 80},
            {label: '电话', name: 'telphone', width: 80},
            {label: '身份证', name: 'idNo', width: 80},
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

function staffType(cellvalue, options, rowObject) {
    if ("0" == cellvalue) {
        return "全职";
    } else if ("1" == cellvalue) {
        return "兼职";
    }
}

function edit(cellvalue, options, rowObject) {
    var img = '<img src="/images/修改icon.png" alt="提成" title="提成" onclick="toUpdateCommission(' + cellvalue + ');"></img>&nbsp;' +
        '<img src="/images/图层1.png" alt="修改" title="修改" onclick="toUpdateStaff(' + cellvalue + ');"></img>';
    return img;
}

function toUpdateCommission(id) {
    window.location.href = "/comm/toUpdateStaffCommission?staffId=" + id;
}


function toUpdateStaff(id) {
    window.location.href = "/comm/toUpdateStaff?staffId=" + id;
}


var vm = new Vue({
    el: '#rrapp',
    data: {
        q: {
            staffName: null,
            staffType: 0
        },
        title: null,
        staff: {
            staffType: 0
        }
    },
    mounted: function () {
        this.getStaffInfo();
    },
    methods: {
        query: function () {
            vm.reload();
        },
        reload: function (event) {
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {'staffName': vm.q.staffName, 'staffType': vm.q.staffType},
                page: page
            }).trigger("reloadGrid");
        },
        clear: function () {
            vm.q.staffName = null;
            vm.q.staffType = null;
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
        checkIdNo: function (value) {
            var regex = /^[1-9]\d{5}(18|19|20)\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/;
            return regex.test(value);

        },
        saveOrUpdate: function () {

            var staffId = $("#staffId").val();
            var url = staffId==null?'/staffinfo/save':'/staffinfo/update';
            var staffName = vm.staff.staffName;
            var telphone = vm.staff.telphone;
            var password = vm.staff.password;
            var idNo = vm.staff.idNo;
            var address = vm.staff.address;
            if(null!=staffId){
                vm.staff.id=staffId;
            }
            var data = JSON.stringify(vm.staff);
            if (!this.isNotNull(staffName)) {
                alert("保洁姓名不能为空！");
                return;
            }
            if (!this.isNotNull(address)) {
                alert("地址不能为空！");
                return;
            }
            if (!this.checkTelephone(telphone)) {
                alert("请输入正确的手机号！");
                return;
            }
            if (!this.isNotNull(password)) {
                alert("密码不能为空");
                return;
            }
            if (!this.checkIdNo(idNo)) {
                alert("请输入正确的身份证号");
                return;
            }


            $.ajax({
                type: "post",
                url: url,
                contentType: "application/json",
                data: data,
                success: function (r) {
                    if (r.code === 0) {
                        alert('操作成功', function (index) {
                            window.location.href = "/modules/homestay/staffList.html";
                        });
                    } else {
                        alert(r.msg);
                    }
                }
            });
        },
        toAddStaff: function () {
            window.location.href = "/modules/homestay/staffAdd.html";
        },
        goback: function () {
            history.go(-1);
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
                            var url='/staffinfo/getStaffPhoto?id=' + vm.staff.id;
                            $('#test1').css("background-image",'url(/staffinfo/getStaffPhoto?id=' + vm.staff.id+')').css("background-size","100% 100%");
                        } else {
                            alert(r.msg);
                        }
                    }
                });
            }

        }
    }
});

