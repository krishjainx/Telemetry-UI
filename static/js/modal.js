$(function(){
    hideModal();
    $("#modal-overlay").click(function(){
        hideModal();
    });
});

function showModal(title,message){
    $("#modal-title").text(title);
    $("#modal-body").text(message);
    $("#modal-overlay").show();

}

function hideModal(){
    $("#modal-overlay").hide();
}
