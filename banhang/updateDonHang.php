<?php
    include "connect.php";
	$id = $_POST['id'];
    $tinhtrang = $_POST['tinhtrang'];

    $query = 'UPDATE `donhang` SET `tinhtrang`='.$tinhtrang.' WHERE `id` ='.$id;
    $data = mysqli_query($conn, $query) ;
    if($data == true){
        $arr = [
                'success' => true,
                'message' => 'Thêm thành công!!!'
            ];    
        
     }else{
         $arr = [
                'success' => false,
                'message' => 'Thêm thất bại!!!'
            ];   
     }   
    
	print_r(json_encode($arr));
?>