<?php

    include('connect.php');
    
    $name = $_POST["product_name"];
    $price = $_POST["product_price"];
    $des = $_POST["product_description"];
   
    
    if($name=="" && $price=="" && $des=="")
    {
        echo '0';
    }
    else
    {
        $sql ="Insert into Inventory_Products(product_name,product_price,product_description) values ('$name','$price','$des')";
        
        $ex=mysqli_query($con,$sql);
    }

?>