<?php
    include "connect.php";
	$sodienthoai = $_POST['sodienthoai'];
	$email = $_POST['email'];
	$tongtien = $_POST['tongtien'];
	$iduser = $_POST['iduser'];
	$diachi = $_POST['diachi'];
	$soluong = $_POST['soluong'];
	$chitiet = $_POST['chitiet'];


//câu truy vấn đon 
	$query = 'INSERT INTO `donhang`(`iduser`, `diachi`, `sodienthoai`, `email`, `soluong`, `tongtien`) VALUES ('.$iduser.',"'.$diachi.'","'.$sodienthoai.'","'.$email.'",'.$soluong.', "'.$tongtien.'")';

	$data = mysqli_query($conn, $query) ;

	if($data == true){

		$query = 'SELECT id AS iddonhangct FROM `donhang` WHERE `iduser` = '.$iduser.' ORDER BY id DESC LIMIT 1';
		$data = mysqli_query($conn, $query);

		while ($row = mysqli_fetch_assoc($data)) {
			$iddonhang = ($row);
		}

		if(!empty($iddonhang)){
			//co don hang
			$chitiet = json_decode($chitiet, true);
			foreach ($chitiet as $key => $value) {
				$truyvan='INSERT INTO `chitietdonhang`(`iddonhang`, `idsp`,`soluong`, `gia`) VALUES ('.$iddonhang["iddonhangct"].','.$value["idsp"].','.$value["soluong"].', "'.$value["giasp"].'")' ;
				$data = mysqli_query($conn, $truyvan);
			}
			if($data == true){
					$arr = [
						'success' => true,
						'message' => 'thanh cong',
					    'iddonhang' =>$iddonhang["iddonhangct"]
					];

				}else{
					$arr = [
						'success' => false,
						'message' => 'khong thanh cong'
					];
				}
			print_r(json_encode($arr));
		}
	}else{
		$arr = [
			'success' => false,
			'message' => 'khong thanh cong'];
		print_r(json_encode($arr));
	}
	

?>