<?php
$con = mysqli_connect("localhost","root","","database");


//query the database for user
// $result = mysqli_query($con,"select * from users where username = '$username' and password = '$password'")
//         or die("Failed to quesry database".mysql_error());
// $row=mysqli_fetch_array($result);


if(isset($_POST['checkb'])){
    session_start();

   $user123=$_SESSION['useris'];
   $pass123=$_SESSION['passwordas'];

    $name = $_POST['checkb'];
    $query  = "UPDATE users(username,password,statusas)
     VALUES ($user123,$pass123,'".$_POST["checkb"]."')";
     $result = mysqli_query($con, $query);
        //Test if there was a query error
        if ($result) {
            //SUCCESS
        header('Location: index.html');
        } else {
            //FAILURE
            die("Database query failed. " . mysqli_error($con)); 
            //last bit is for me, delete when done
    }
}
?>