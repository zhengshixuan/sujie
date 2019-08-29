$(function() {
    window.onload = function() {
        var tableCont = document.querySelector('#table-cont');

        function scrollHandle(e) {
            console.log(this);
            var scrollTop = this.scrollTop;
            this.querySelector('thead').style.transform = 'translateY(' + scrollTop + 'px)';
        }

        tableCont.addEventListener('scroll', scrollHandle);
    }
})