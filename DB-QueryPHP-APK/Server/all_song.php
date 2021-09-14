<?php
	 require "connect.php";
	$arraylistsong = array();
	 class Baihat
	 {
	 	
	 	function Baihat($mabaihat,$tenbaihat,$mieuta, $loibaihat, $luotnghe,$urlhinhbaihat,$urlbaihat, $tencasi)

	 	{
	 	$this -> MABAIHAT= $mabaihat;
	 	$this -> TENBAIHAT = $tenbaihat;
	 	$this -> MIEUTA = $mieuta;
	 	$this -> LOIBAIHAT = $loibaihat;
	 	$this -> LUOTNGHE = $luotnghe;
	  	$this -> URLHINHBAIHAT= $urlhinhbaihat;
	  	$this -> URLBAIHAT= $urlbaihat;
	 	$this -> TENCASI = $tencasi;
	  	}
	 }
	     	 $query ="SELECT DISTINCT * FROM baihat,album,casi WHERE casi.MACASI = album.MACASI AND album.MAALBUM = baihat.MAALBUM ORDER BY `baihat`.`TENBAIHAT` ASC";
	       	$data = mysqli_query($con,$query);
		 	while ($row = mysqli_fetch_assoc($data)) {
 			array_push($arraylistsong, new Baihat($row['MABAIHAT'], $row['TENBAIHAT'], $row['MIEUTA'],$row['LOIBAIHAT'],$row['LUOTNGHE'], $row['URLHINHBAIHAT'], $row['URLBAIHAT'], $row['TENCASI'])); 
	 		}
	   echo json_encode($arraylistsong);
?>