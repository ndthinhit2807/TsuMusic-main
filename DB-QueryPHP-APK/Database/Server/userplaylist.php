<?php
	require "connect.php";
	
	$data = mysqli_query($con,$query);
	$mathanhvien = $_POST['username'];
	$query = "SELECT * FROM danhsachbaihat,User WHERE danhsachbaihat.MATHANHVIEN = User.MATHANHVIEN AND FIND_IN_SET('$mathanhvien',User.user_name)";
	class Topic{

		function Topic($madanhsach,$mathanhvien,$tendanhsach,$mieuta,$ngaytao){
			$this->MADANHSACH = $madanhsach;
			$this->MATHANHVIEN = $mathanhvien;
			$this->TENDANHSACH = $tendanhsach;
			$this->MIEUTA = $mieuta;
			$this->NGAYTAO = $ngaytao;
		}	
	}
	$topicarray = array();
	while ($row = mysqli_fetch_assoc($data)) {
		array_push($topicarray, new Topic($row['MADANHSACH'],$row['MATHANHVIEN'],$row['TENDANHSACH'],$row['MIEUTA'],
												$row['NGAYTAO']));
		
		# code...
	}
	echo json_encode($topicarray);

?>