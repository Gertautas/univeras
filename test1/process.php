<?php
//get values
$username = $_POST['user'];
$password = $_POST['pass'];

//prevent mysql injection
// $username = stripcslashes($username);
// $password = stripcslashes($password);
// $username=mysql_real_escape_string($username);
// $password=mysql_real_escape_string($password);

//connect to server/database
$con = mysqli_connect("localhost","root","","database");

//query the database for user
$result = mysqli_query($con,"select * from users where username = '$username' and password = '$password'")
        or die("Failed to quesry database".mysql_error());
$row=mysqli_fetch_array($result);
if($row['username']==$username && $row['password'] == $password && $row['statusas']=='kitkas'){
    header('Location: galutinis_kitkas.html');
}else if($row['username']==$username && $row['password'] == $password && $row['statusas']==''){
    header('Location: choiche.html');
}
else if($row['username']=='' && $row['password']== ''){
    $query  = "INSERT INTO users (username, password)
            VALUES ('".$_POST["user"]."','".$_POST["pass"]."')";
    $result = mysqli_query($con, $query);
        //Test if there was a query error
        if ($result) {
            //SUCCESS
        header('Location: choiche.html');
        } else {
            //FAILURE
            die("Database query failed. " . mysqli_error($con)); 
            //last bit is for me, delete when done
        }
}

?>