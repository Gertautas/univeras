(function($) {
    $(function() {
$("#newsletter").submit(function(event){
    event.preventDefault();
    submitForm();
});
    });
});

function submitForm(){
    var email = $("#email").val();

    $.ajax({
        type: "POST",
        url: "siusti.php",
        data: "email " + email,
        success: function(text){
            if(text == "submit"){
                formSuccess();
            }
        }
    });
}

function formSuccess(){
    $("submit").removeClass("hidden");
}