//////////////////////////////////////////////////////////
// Modal Dialog manager
// Handles a simple modal for error and status messages.
// Requires jQuery.
//////////////////////////////////////////////////////////

// On initialization, make sure the modal is hidden.
$(function(){
    hideModal();
});

// Shows a modal with the provided title and message.
function showModal(title,message){
    $("#modal-title").text(title);
    $("#modal-body").text(message);
    $("#modal-overlay").show();
}

// Hides the modal, if it's visible.
function hideModal(){
    $("#modal-overlay").hide();
}

//////////////////////////////////////////////////////////
// End of File
//////////////////////////////////////////////////////////
