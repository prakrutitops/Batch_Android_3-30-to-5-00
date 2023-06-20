<?php
    
    include('connect.php');
    
     $phone=$_REQUEST["phone"];
       $sql="select * from art_cart where phone='$phone'";
    
    $r=mysqli_query($con,$sql);
    $response=array();
    
    while($row=mysqli_fetch_array($r))
    {
        
        $value["id"]=$row["id"];
        $value["image"]=$row["image"];
        $value["price"]=$row["price"];
        $value["phone"]=$row["phone"];
        
        array_push($response,$value);
        
    }
    echo json_encode($response);
    
    mysqli_close($con)
    

?>