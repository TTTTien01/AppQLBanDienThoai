<?php
include 'connect.php'; 

$query = "SELECT idsp, sanpham.tensanpham, SUM(`soluong`) as Tongsoluong from `chitietdonhang` INNER JOIN sanpham ON sanpham.id = chitietdonhang.idsp GROUP BY `idsp` order by Tongsoluong desc";
$data = mysqli_query($conn, $query);
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