<?php
    include "connect.php";
	$tensanpham = $_POST['tensanpham'];
    $gia = $_POST['gia'];
    $hinhanh = $_POST['hinhanh'];
    $mota = $_POST['mota'];
    $soluongkho =  $_POST['soluongkho'];
    $loai = $_POST['loai'];

    $query = 'INSERT INTO `sanpham`(`tensanpham`, `giasp`, `soluongkho`, `hinhanh`, `mota`, `loai`) VALUES ("'.$tensanpham.'","'.$gia.'","'.$soluongkho.'" ,"'.$hinhanh.'","'.$mota.'",'.$loai.')';
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