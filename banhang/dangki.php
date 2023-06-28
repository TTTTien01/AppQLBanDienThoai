<?php
    include "connect.php";
	$username = $_POST['username'];
    $email = $_POST['email'];
    $password = $_POST['password'];
    $phonenumber = $_POST['phonenumber'];
    $uid = $_POST['uid'];

    //check email
    $query = 'SELECT * FROM `user` WHERE `email` ="'.$email.'" ';
    $data = mysqli_query($conn, $query) ;
    $numrow = mysqli_num_rows($data); //kiểm tra xem dl có trả về không
    if($numrow > 0){
        $arr = [
			'success' => false,
			'message' => 'Email đã tồn tại!'
		];
    }else{
    //insert
        $query = 'INSERT INTO `user`(`username`, `email`, `password`, `phonenumber`,`uid`) VALUES ("'.$username.'","'.$email.'","'.$password.'","'.$phonenumber.'","'.$uid.'")';
        $data = mysqli_query($conn, $query) ;
        
        if($data == true){
            $arr = [
                'success' => true,
                'message' => 'thanh cong'
            ];
        
        }else{
            $arr = [
                'success' => false,
                'message' => 'khong thanh cong'
            ];
        }
    }

	print_r(json_encode($arr));
?>