<?php
    
    include('connect.php');
    
      $sql="select * from arts_category";
    
    $r=mysqli_query($con,$sql);
    $response=array();
    
    while($row=mysqli_fetch_array($r))
    {
        
        $value["id"]=$row["id"];
        $value["name"]=$row["name"];
        $value["image"]=$row["image"];
        
        
        array_push($response,$value);
        
    }
    echo json_encode($response);
    
    mysqli_close($con)
    

?>