<?php
require  'connect.php';
require 'PHPMailer/PHPMailerAutoload.php';
require  'PHPMailer/class.phpmailer.php';
require 'PHPMailer/class.smtp.php';
require 'admin.php';
$email = $_POST['email'];
 $sql = "SELECT * FROM `User` WHERE email ='$email'";
 $check =mysqli_query($con,$sql);

 if(mysqli_num_rows($check)==1){
    $mail = new PHPMailer;
    // Set mailer to use SMTP
    $mail->isSMTP();
    $mail->Host = 'babyshark.maychu.cloud';  // Specify main and backup SMTP servers
    $mail->SMTPAuth = true;       
     // Enable SMTP authentication
 
     $mail->SMTPDebug = 2;    
     //cap quyen truy cap cho gmail
    //https://www.google.com/settings/security/lesssecureapps
    $mail->Username = $adminemail;                 // SMTP username
    $mail->Password = $adminpassword;                        // SMTP password
    $mail->SMTPSecure = 'tls';    
    
    // Enable TLS encryption, `ssl` also accepted
    $mail->Port = 587;                                    // TCP port to connect to

    $mail->setFrom('noreply@tsumusics.com', 'Tsumusic');
    $mail->addAddress($email);     // Add a recipient             // Name is optional
    $mail->addReplyTo('noreply@tsumusics.com', 'Tsumusic');


    // $ok = md5($email)
    $mail->Subject ='Reset Password at Tsumusic';
    $mail->Body="Hey $email,
   Your Tsumusic password can be reset by clicking the button below. If you did not request a new password, please ignore this email.
   https://www.tsumusics.com/Server/resetpassword.php?key=$email";

   
    // $mail->AltBody = 'This is the body in plain text for non-HTML mail clients';

    if(!$mail->send()) {
        echo 'Message could not be sent.';
        echo 'Mailer Error: ' . $mail->ErrorInfo;
    } else {
        $msg["mail"]="send";
        echo json_encode($msg);
    }



}   
else
    {
        echo"Invalid Email";
    }