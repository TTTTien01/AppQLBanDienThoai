<?php
    include "connect.php";
	$id = $_POST['id'];


    $query = 'DELETE FROM `sanpham` WHERE `id`='.$id;
    $data = mysqli_query($conn, $query) ;
    if($data == true){
        $arr = [
                'success' => true,
                'message' => 'Xóa thành công!!!'
            ];    
        
     }else{
         $arr = [
                'success' => false,
                'message' => 'Xóa thất bại!!!'
            ];   
     }   
    
	print_r(json_encode($arr));
?>