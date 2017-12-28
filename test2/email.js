 $("#emailas").validator().on("submit", function(event){
     if(event.isDefaultPrevented()){
        console.log('erroras')
     }else{
         event.preventDefault();
         submitForm();
         console.log('ok');
     }
 });

    function submitForm(){
        var email = $("#email").val();

        $.ajax({
            type: "POST",
            url: "siusti.php",
            data: "erroras pas: " + email,
            success: function(text){
                if (text == "success") {
                    formSuccess();
                } else {
                    submitMSG(false, text);
                }
            }
        });
    }