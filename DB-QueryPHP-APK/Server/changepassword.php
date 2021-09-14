<?php
require 'connect.php';
$oldpassword =  $_POST['oldpassword'];
$newpassword =  $_POST['newpassword'];
$confirmpassword =  $_POST['confirmpassword'];
$user_name = $_POST['user_name'];

$passwordmd5old = hash('sha256', $oldpassword);
$passwordmd5new = hash('sha256', $newpassword);
$passwordmd5confirm = hash('sha256', $confirmpassword);

$sql = "SELECT * FROM User WHERE password = '$passwordmd5old' AND user_name ='$user_name'";
$query = mysqli_query($con,$sql);
if($passwordmd5new == $passwordmd5confirm){
    if(!mysqli_num_rows($query)>0){
        $status = "notexsits";
    }
    else
    {
        $update = "UPDATE User SET password='$passwordmd5new' WHERE user_name = '$user_name'";
        $res = mysqli_query($con,$update);
        if($res){
             $status = "oke";
        }
        else{
            $status = "error";
        }
    }
}
else{
   $status ="notsame";
}
  echo json_encode(array("response"=>$status));
    mysqli_close($con);
?>