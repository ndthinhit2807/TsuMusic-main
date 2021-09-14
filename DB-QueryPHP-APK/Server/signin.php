<?php
	 require "connect.php";
    $user_name=$_POST['user_name'];
    $email = $_POST['email'];
    $password=$_POST['password'];
    $passwordmd5 = hash('sha256', $password);
    // $passwordmd5 = md5($password);
	 
    $sql ="SELECT * FROM User WHERE  (user_name='$user_name' and password='$passwordmd5')  or (email='$email' and password='$passwordmd5') ";
 	$result = mysqli_query($con,$sql);
	if(!mysqli_num_rows($result)>0){
	$status="failed";
    echo json_encode(array("response"=>$status));
    }

	else{
	 $row= mysqli_fetch_assoc($result);
    $name= $row['name'];
    $url_image= $row['url_image'];
    $email= $row['email'];
    $status="ok";
    echo json_encode(array("response"=>$status,"name"=>$name,"user_name"=>$user_name,"email" => $email, "url_image"=>$url_image));
	}
	mysqli_close($con);
?>