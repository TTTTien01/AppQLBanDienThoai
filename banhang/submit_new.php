<?php
include "connect.php";
if(isset($_POST['submit_password']) && $_POST['email'])
{
  $email=$_POST['email'];
  $pass=$_POST['password'];

  $query = "update user set password='$pass' where email='$email'";
  $data = mysqli_query($conn, $query) ;
  if($data== true)
  {
    echo "Đặt lại mật khẩu hành công!. Bạn có thể đăng nhập lại app ^-^";
  }

}
?>