<?php 
	
//importing dbDetails file 
include 'animal_connect.php';	

//this is our upload folder 
$upload_path = 'aimage/';

//Getting the server ip 
$server_ip = gethostbyname(gethostname());

//creating the upload url 
//$upload_url = 'http://'.$server_ip.'/animal/'.$upload_path; 

$upload_url = 'https://'.$_SERVER['SERVER_NAME'] . "/db_files/animal/" . $upload_path;
	
	
//getting name from the request 
$name = $_POST['name'];
 $email = $_POST['email'];
 $password = $_POST['password'];

//getting file info from the request 
$fileinfo = pathinfo($_FILES["img"]["name"]);

//getting the file extension 
$extension = $fileinfo["extension"];

//file url to store in the database 
$file_url = $upload_url . $name . '.' . $extension;

//file path to upload in the server 
$file_path = $upload_path . $name . '.'. $extension; 
			
//saving the file 
move_uploaded_file($_FILES["img"]["tmp_name"],$file_path);

if($name=="" && $email=="" && $password==""&& $file_url=="")
{
       echo '0';
}
else
{
        $sql = "INSERT INTO animal (name,email,password,img) VALUES ('$name','$email','$password','$file_url')";
        $ex=mysqli_query($con,$sql);
}
echo $sql;
//exit;

			
//closing the connection 
mysqli_close($con);

?>
