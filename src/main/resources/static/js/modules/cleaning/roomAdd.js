$(function () {

    layui.use('upload', function () {
        var upload = layui.upload;
        //执行实例
        var uploadInst = upload.render({
            elem: '.layui-btn' //绑定元素
            ,
            url: '/roominfo/upload' //上传接口
            ,
            done: function (res) {
                //上传完毕回调

                if (res.code > 0) {
                    return layer.msg('上传失败');
                } else if (res.code == 0) {
                    var index = $(this.item).val();
                    $(this.item).css("background-image", 'url(' + res.path + ')').css("background-size", "100% 100%");
                    var val = $(this.item).parent().find("textarea").val();
                    if (val == null || "" == val) {
                        vm.room.imageDes[index - 1] = '';
                        // $(this.item).parent().find("textarea").val('123')
                    }
                    // console.log("下一个节点的值为" + val);
                    vm.room.imageType[index - 1] = index - 1;
                    vm.room.path[index - 1] = res.path;
                    // vm.room.imageType.push($(this.item).val());
                    // $('#test1').css("background-image",'url('+res.path+')').css("background-size","100% 100%");
                    return layer.msg('上传成功');
                }
            },
            error: function () {
                //请求异常回调
            }
        })
    })
});