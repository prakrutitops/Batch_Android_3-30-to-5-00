<?php

include('connect.php');
$id=$_POST["product_id"];
$name=$_POST["product_name"];
$price=$_POST["product_price"];
$des=$_POST["product_description"];

$sql="Update Inventory_Products set product_name='$name',product_price='$price',product_description='$des' where product_id='$id'";


//$ex=mysqli_query($con,$sql);

if(mysqli_query($con,$sql))
{
    echo 'Record Updated Succesfully';
}
else
{
    echo 'Something went Wrong';
}


?>