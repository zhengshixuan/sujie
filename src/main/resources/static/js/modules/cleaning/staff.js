$(function () {
    layui.use('upload', function(){
        var upload = layui.upload;

        //执行实例
        var uploadInst = upload.render({
            elem: '#test1' //绑定元素
            ,url: '/upload/' //上传接口
            ,done: function(res){
                //上传完毕回调
            }
            ,error: function(){
                //请求异常回调
            }
        });
    });
})

$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + '/staffinfo/list',
        datatype: "json",
        colModel: [
            { label: '序号', name: 'id', width: 30, key: true },
            { label: '操作', name: 'id', sortable: false, width: 60 },
            { label: '阿姨类别', name: 'staffType', width: 100 },
            { label: '名字', name: 'staffName', width: 80 },
            { label: '电话', name: 'telphone', width: 80 },
            { label: '身份证', name: 'idNo', width: 80 },
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

