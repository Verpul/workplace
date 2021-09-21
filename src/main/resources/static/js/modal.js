$('#confirm').on('show.bs.modal', function (e) {
    let someId = $(e.relatedTarget).data('id');
    let confirmType = $(e.relatedTarget).data('type');

    let text = confirmType === 'delete' ? 'Удалить ЭЦП?' : 'Действие ЭЦП закончено?';
    let url = confirmType === 'delete' ? '/delete/' : '/deactivate/';

    $('#confirm h5').text(text);
    $('#confirm a').attr('href', "eds" + url + someId);
})