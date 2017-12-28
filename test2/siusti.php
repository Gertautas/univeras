<?php

$email=$_POST["email"];

$EmailTo = "gmaciuta@gmail.com";
$Subject = "Error page message";
$emailas = "gm4415@gmail.com";

$Body .="Email: ";
$Body .= $email;
$Body .="\n";

//send email

$success = mail($EmailTo,$Subject,$Body, "From:".$emailas);

if($success){
    echo "success";
}else{
    echo "invalid";
}
?>