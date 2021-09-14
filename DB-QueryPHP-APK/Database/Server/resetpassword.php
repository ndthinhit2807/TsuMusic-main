<?php
require_once 'connect.php';
$email = $_GET['key'];
$sql = "SELECT * FROM User WHERE email ='$email'";
$result = mysqli_query($con, $sql);
if (mysqli_num_rows($result) == 1) {
    if (isset($_POST['submit'])) {
        $password = $_POST['password'];
        $cfmpassword = $_POST['cfmpassword'];
        
        $passwordmd5pass = hash('sha256', $password);
        $passwordmd5confirm = hash('sha256', $cfmpassword);

        if ($passwordmd5pass == "" && $passwordmd5confirm == "") {
            echo "some password are emty";
        } else {
            if ($passwordmd5pass == $passwordmd5confirm) {
                $update = "UPDATE User SET password='$passwordmd5pass' WHERE email ='$email'";
                if (mysqli_query($con, $update)) {
                    echo "<br><h4> Mật khẩu của $email đã được cập nhật vui lòng đăng nhập lại!</h4>";
                } else {
                    echo "Password changing error refess and reclick the email link";
                }
            } else {
                // echo "password are not match";
            }
        }
    } else {
    //   echo "Click here to submit button and change password";
    }
}
?>
<!DOCTYPE html>
<html lang="vi">
  <head>
    <meta charset="utf-8" />
    <meta name="author" content="Kodinger" />
    <meta name="viewport" content="width=device-width,initial-scale=1" />
    <title>Tsumuic - Resetpassword</title>
     <link rel="shortcut icon" type="image/png" href="https://namvan.000webhostapp.com/image/logo_app.png" />
    <meta property="og:image" content="https://namvan.000webhostapp.com/image/thumbnail.png">
     <meta property="og:image:type" content="image/png">
      <meta property="og:image:width" content="1919">
     <meta property="og:image:height" content="975">
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous"
    />
   
    <link rel="stylesheet" type="text/css" href="resource/style.css" />
  </head>
  <body class="my-login-page">
    <section class="h-100">
      <div class="container h-100">
        <div class="row justify-content-md-center align-items-center h-100">
          <div class="card-wrapper">
            <div class="brand">
               <img src="https://res.cloudinary.com/van-nam/image/upload/v1623203244/resource/logoapp_psaucw.png" alt="logo-app">
            </div>
            <div class="card fat">
              <div class="card-body">
                <h4 class="card-title">Cập nhật mật khẩu</h4>
                <form
                  method="post"
                  id="form"
                  class="my-login-validation"
                  action=""
                  >
                  <div class="form-group">
                    <label for="new-password">Mật khẩu mới</label>
                    <input
                      id="password"
                      type="password"
                      class="form-control"
                      name="password"
                      required
                      autofocus
                      data-eye
                      
                    />

                    <label for="cfm-password">Xác nhận mật khẩu</label>
                    <input
                      id="cfmpassword"
                      type="password"
                      class="form-control"
                      name="cfmpassword"
                      required
                      autofocus
                      data-eye
                      
                    />
                  </div>
                  <div id="error"></div>
                  <br />
                  <div clasdass="form-group m-0">
                    <button type="submit" name="submit"  class="btn btn-primary btn-block">
                      Cập nhật
                    </button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
   <script src="resource/script.js"></script>
   
  </body>
</html>