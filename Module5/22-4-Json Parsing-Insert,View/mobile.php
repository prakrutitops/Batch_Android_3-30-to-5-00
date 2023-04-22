<?php
include('dbConnect.php');

 $sql = "SELECT * FROM mobile";
 
 $r = mysqli_query($con,$sql);
$response = array();
 
while ($row = mysqli_fetch_array($r))
 {
       // $value = array();
        $value["product_id"] = $row["product_id"];
        $value["product_name"] = $row["product_name"];
        $value["product_price"] = $row["product_price"];
        
        array_push($response, $value);
    }

    // echoing JSON response
    echo json_encode($response);
    mysqli_close($con);
 
 
?>