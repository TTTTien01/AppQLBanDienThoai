<?php
include "connect.php";

if($_GET['key'] && $_GET['reset'])
{
  $email=$_GET['key'];
  $pass=$_GET['reset'];
  $query = "select email,password from user where email='$email' and password='$pass'";
  $data = mysqli_query($conn, $query) ;
  if($data== true)
  {
    ?>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet">

    <div class="card text-center mx-auto" style="width: 400px; margin-top: 200px;">

    <div class="card-header h5 text-white bg-primary">Đặt lại mật khẩu</div>

    <div class="card-body px-5">
        <p class="card-text py-2">Bạn hãy nhập lại một mật khẩu mới!!!</p>
        <div class="form-outline">
          <form method="post" action="submit_new.php">
            <input type="hidden" name="email" value="<?php echo $email;?>">
            <input type="password" name='password'>
            <input type="submit" name="submit_password">
           </form>
        </div>
    </div>
  </div>

    <?php
  }
}
?>