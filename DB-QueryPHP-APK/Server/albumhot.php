<?php
	require "connect.php";
	$query = "SELECT album.*, casi.TENCASI ,SUM(baihat.LUOTNGHE) AS 'TONGLUOTNGHE' FROM baihat,casi,album WHERE casi.MACASI = album.MACASI AND album.MAALBUM = baihat.MAALBUM GROUP BY album.MAALBUM ORDER BY SUM(baihat.LUOTNGHE) DESC LIMIT 8";

	$dataalbum = mysqli_query($con,$query);
	class Album{
		// dat ten cho tung thuoc tinh trong album
		function Album($maalbum,$tenalbum, $hinhalbum, $tencasi){
			$this -> MAALBUM = $maalbum;
			$this -> TENALBUM = $tenalbum;
			$this -> URLALBUM = $hinhalbum;
			$this -> TENCASI = $tencasi;
			
		}
	}
	// goi du lieu tu database
	$arrayalbum = array();
	while ($row = mysqli_fetch_assoc($dataalbum)){
		array_push($arrayalbum, new Album($row['MAALBUM']
	                                    	,$row['TENALBUM']
	                                    	,$row['URLALBUM']
	                                    	,$row['TENCASI']
	                                    	));
	}
	echo json_encode($arrayalbum);
?>