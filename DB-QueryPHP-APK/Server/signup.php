<?php
   
	require "connect.php";
    $name = $_POST['name'];
    $user_name = $_POST['user_name'];
    $password = $_POST['password'];
    $email = $_POST['email'];
    
    $query = "SELECT * FROM User WHERE user_name = '$user_name'";
    $result = mysqli_query($con, $query);
    $query1 = "SELECT * FROM User WHERE email = '$email'";
    $result1 = mysqli_query($con, $query1);
	if (mysqli_num_rows($result)>0){
    $status = "exists";}
	else if(mysqli_num_rows($result1)>0){
    $status = "exists1";
	}
	else{
	    $passwordmd5 = hash('sha256', $password);
	   // $passwordmd5 = md5($password);

	 // for non-registered user
    $sql="INSERT INTO User (MATHANHVIEN, name, user_name,password,email) VALUES (null,'$name','$user_name','$passwordmd5','$email')";
    if(mysqli_query($con,$sql)){
		    $status = "inserted";
	    }else{
		    $status = "error";
	    }
	}

    echo json_encode(array("response"=>$status));
    mysqli_close($con);
    
?>