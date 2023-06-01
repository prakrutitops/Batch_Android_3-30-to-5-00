<?php

include('connect.php');
$id=$_POST["product_id"];


$sql="Delete from Inventory_Products where product_id ='$id'";


//$ex=mysqli_query($con,$sql);

if(mysqli_query($con,$sql))
{
    echo 'Record Deleted Succesfully';
}
else
{
    echo 'Something went Wrong';
}


?>