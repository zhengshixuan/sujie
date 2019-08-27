$(function () {
    layui.use('upload', function(){
        var upload = layui.upload;
         
        //执行实例
        var uploadInst = upload.render({
          elem: '#test1' //绑定元素
          ,url: '/staffinfo/upload/' //上传接口
          ,data:{}
          ,done: function(res){

            //上传完毕回调
          }
          ,error: function(){
            //请求异常回调
          }
        });
      });
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#entryTime', //指定元素
            done: function (value) {
                vm.staff.entryTime=value;
            }
        });
    });
})
