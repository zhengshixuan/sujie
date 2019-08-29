$(function() {
  //  弹出模态框
  $('.changed').on('click', function() {
      $('.ui.modal')
          .modal('show');
  })

  // 根据姓名 阿姨类别搜索
  $('.miansearched').on('click', function() {
      let str1 = $('.brandname').val()
      let str2 = $('.roomnum').val()
      let str3 = $('.roomaddree').val()
      let str4 = $('.cleartime').val()

      console.log(str1);
  })


  // 清空按钮
  $('.mainclear').on('click', function() {
   $('.brandname').val('')
   $('.roomnum').val('')
   $('.roomaddree').val('')
   $('.cleartime').val('')
  })


  // 点击保存获取表单的数据 

  $('.mainseting').on('click', function() {


  })

})