<?php
	require "connect.php";
	$query = "SELECT DISTINCT * FROM theloai";
	$data = mysqli_query($con,$query);

	class Topic{

		function Topic($idchude,$tenchude,$mieuta,$hinhchude){
			$this->MATHELOAI = $idchude;
			$this->TENTHELOAI = $tenchude;
			$this->MIEUTA = $mieuta;
			$this->HINHTHELOAI = $hinhchude;
		}	
	}
	$topicarray = array();
	while ($row = mysqli_fetch_assoc($data)) {
		array_push($topicarray, new Topic($row['MATHELOAI'],$row['TENTHELOAI'],$row['MIEUTA'],
												$row['HINHTHELOAI']));
		
		# code...
	}
	echo json_encode($topicarray);

?>