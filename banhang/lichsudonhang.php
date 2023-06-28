<?php
    include "connect.php";
	$iduser = $_POST['iduser'];
	
	if($iduser == 0){
		//get all don hang
		$query = 'SELECT donhang.id, user.username,donhang.diachi,donhang.sodienthoai,donhang.email,donhang.soluong,donhang.tongtien,donhang.tinhtrang,donhang.ngaydathang FROM `donhang` INNER JOIN user ON donhang.iduser = user.id ORDER BY donhang.id DESC';
	}else{
        $query = 'SELECT * FROM `donhang` WHERE `iduser` = '.$iduser.' ORDER BY id DESC';
	}

	$data = mysqli_query($conn, $query) ;
	$result = array();
	while ($row = mysqli_fetch_assoc($data)) {
		$sql = 'SELECT * FROM `chitietdonhang` INNER JOIN sanpham ON chitietdonhang.idsp = sanpham.id WHERE chitietdonhang.iddonhang  = '.$row['id'];
		$data1 = mysqli_query($conn, $sql) ;
		$item = array();
		while ($row1 = mysqli_fetch_assoc($data1)) {
			$item[] = $row1;
		}

		$row['item'] = $item;
		$result[] = ($row);

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