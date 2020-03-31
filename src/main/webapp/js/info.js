$(function () {
    var iosDialog = $('#iosDialog');
    $('#dialogs').on('click', '.weui-dialog__btn', function () {
        $(this).parents('.js_dialog').fadeOut(200);
    });

    $('#showIOSDialog').on('click', function () {
        iosDialog.fadeIn(200);
    });

    unbindingClick();
});

function unbindingClick() {
    $('#confirmUnbinding').on('click', function () {
        var url = 'unbinding.do';
        $.ajax({
            async : false,
            type: 'post',
            url: url,
            dataType: 'json'
        });
    });
}