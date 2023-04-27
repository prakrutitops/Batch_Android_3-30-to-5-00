<?php
    
    include('connect.php');
    
    $mobile=$_REQUEST["mob"];
    $pass=$_REQUEST["pass"];
    
    $sql="select * from test1 where phone='$mobile' and password ='$pass'";
    
    
    $ex=mysqli_query($con,$sql);
    
    $no=mysqli_num_rows($ex);
    
    
    if($no>0)
    {
    $fet=mysqli_fetch_object($ex);
    echo json_encode(['code'=>200]);
    }
    else
    {
    echo "0";
    }

?>