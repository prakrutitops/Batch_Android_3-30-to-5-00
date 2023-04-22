<?php

include('dbConnect.php');

$p_name = $_POST["product_name"];
$p_price = $_POST["product_price"];


if($p_name=="" && $p_price=="")
{
    echo '0';
}
else
{
    $sql ="insert into mobile (product_name,product_price) values ('$p_name','$p_price')";
    mysqli_query($con,$sql);
}


?>