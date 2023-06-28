<?php
    include "connect.php";
	$search = $_POST['search'];
	if(empty($search)){
		$arr = [
				'success' => false,
				'message' => 'Không tìm thấy kết quả nào!!',
			];
	}else{
		$query = "SELECT * FROM `sanpham` WHERE `tensanpham` LIKE '%".$search."%'";
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
				'message' => 'Không tìm thấy sản phẩm, vui lòng nhập lại',
				'result' => $result
			];
		}
	}
	print_r(json_encode($arr));
?>