<?php
    include "connect.php";
	$tensanpham = $_POST['tensanpham'];
    $giasp = $_POST['giasp'];
    $soluongkho =  $_POST['soluongkho'];
    $hinhanh = $_POST['hinhanh'];
    $mota = $_POST['mota'];
    $loai = $_POST['loai'];
    $id = $_POST['id'];


    $query = 'UPDATE `sanpham` SET `tensanpham`="'.$tensanpham.'",`giasp`="'.$giasp.'", `soluongkho`="'.$soluongkho.'", `hinhanh`="'.$hinhanh.'",`mota`="'.$mota.'",`loai`='.$loai.' WHERE `id`='.$id;
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