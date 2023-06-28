<?php
    include "connect.php";
	$page = $_POST['page'];
	$total = 5;
	$pos = ($page-1) * $total; 
	$loai = $_POST['loai'];

	$query = 'SELECT * FROM `sanpham` WHERE `loai` = '.$loai.' LIMIT '.$pos.','.$total.'';
	$data = mysqli_query($conn, $query) ;
	$result = array();
	while ($row = mysqli_fetch_assoc($data)) {
		$result[] = ($row);
		// code...
	}
	if(!empty($result)){
		$arr = [
			'success' => true,
			'message' => 'thanh cong',
			'result' => $result
		];
	
	}else{
		$arr = [
			'success' => false,
			'message' => 'khong thanh cong',
			'result' => $result
		];
	}
	
	print_r(json_encode($arr));
?>