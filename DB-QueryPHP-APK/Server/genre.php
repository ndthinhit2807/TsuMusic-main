<?php
	require "connect.php";
	$query = "SELECT DISTINCT * FROM theloai ORDER BY rand(" . date("Ymd") . ") LIMIT 8";
	$data = mysqli_query($con,$query);

	class Genre{

		function Genre($idchude,$tenchude,$mieuta,$hinhchude){
			$this->MATHELOAI = $idchude;
			$this->TENTHELOAI = $tenchude;
			$this->MIEUTA = $mieuta;
			$this->HINHTHELOAI = $hinhchude;
		}	
	}
	$topicarray = array();
	while ($row = mysqli_fetch_assoc($data)) {
		array_push($topicarray, new Genre($row['MATHELOAI'],$row['TENTHELOAI'],$row['MIEUTA'],
												$row['HINHTHELOAI']));
		
		# code...
	}
	echo json_encode($topicarray);

?>