$(function(){
  // 搜索事件
$('.searched').on('click',function(){
  console.log(11);
  let src1 = $('#exampleInputName2').val()
  let src2 = $('.selecthome').val()
  console.log(src2);


})
  // 清除事件
$('.cleared').on('click',function(){

   $('#exampleInputName2').val('')
   $('.selecthome').val('')



})

})