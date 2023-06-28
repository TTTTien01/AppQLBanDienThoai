<?php
    include "connect.php";
    use PHPMailer\PHPMailer\PHPMailer;
    use PHPMailer\PHPMailer\Exception;

    require 'PHPMailer/src/Exception.php';
    require 'PHPMailer/src/PHPMailer.php';
    require 'PHPMailer/src/SMTP.php';

    $email = $_POST['email'];
    $query = 'SELECT * FROM `user` WHERE `email`="'.$email.'" ';
	$data = mysqli_query($conn, $query) ;
	$result = array();
	while ($row = mysqli_fetch_assoc($data)) {
		$result[] = ($row);
		// code...
	}
    if(empty($result)){
        $arr = [
			'success' => false,
			'message' => 'Email không chính xác!',
			'result' => $result
		];
    }else{
        //gửi mail
        $email=($result[0]["email"]);
        $pass=($result[0]["password"]);

        $link="<a href='http://192.168.43.130:88/banhang/reset_pass.php?key=".$email."&reset=".$pass."'>Click To Reset password</a>";
        $mail = new PHPMailer();
        $mail->CharSet =  "utf-8";
        $mail->IsSMTP();
        // enable SMTP authentication
        $mail->SMTPAuth = true;                  
        // GMAIL username
        $mail->Username = "tranthithuytien2203@gmail.com";
        // GMAIL password
        $mail->Password = "ahhjcnmwkqqvochp"; //pass cua mai
        $mail->SMTPSecure = "ssl";  
        // sets GMAIL as the SMTP server
        $mail->Host = "smtp.gmail.com";
        // set the SMTP port for the GMAIL server
        $mail->Port = "465";
        $mail->From= "tranthithuytien2203@gmail.com";    //mail người nhận
        $mail->FromName='App bán hàng';
        $mail->AddAddress($email, 'reciever_name');
        $mail->Subject  =  'Reset Password';
        $mail->IsHTML(true);
        $mail->Body = $link;

        if($mail->Send())
        {
           $arr = [
            'success' => true,
            'message' => 'Vui lòng kiểm tra thông tin từ Email của bạn. Để đặt lại mật khẩu!',
            'result' => $result
        ];
        }
        else
        {
            $arr = [
            'success' => false,
            'message' => 'Gửi Email thất bại!!!',
            'result' => $result
        ];
        }
    }
    print_r(json_encode($arr));
        
?>