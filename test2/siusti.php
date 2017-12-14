<?php

$email=$_POST["email"];

$EmailTo = "gmaciuta@gmail.com";
$Subject = "Error page message";

$Body .="Email: ";
$Body .= $email;
$Body .="\n";

//send email

$success = mail($EmailTo,$Subject, "From:".$email);

if($success){
    echo "success";
}else{
    echo "invalid";
}
?>