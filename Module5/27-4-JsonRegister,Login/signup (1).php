<?php

include('connect.php');

$firstname=$_POST["firstname"];
$lastname=$_POST["lastname"];
$gender=$_POST["gender"];
$email=$_POST["email"];
$phone=$_POST["phone"];
$password=$_POST["password"];


if($firstname=="" && $lastname=="" && $gender=="" && $email=="" && $phone=="" && $password=="")
{
    echo '0';
}
else
{
    $sql ="insert into test1(firstname,lastname,gender,email,phone,password) values ('$firstname','$lastname','$gender','$email','$phone','$password')";
    
    mysqli_query($con,$sql);
}


?>