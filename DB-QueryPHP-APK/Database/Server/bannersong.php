<?php
	require "connect.php";
	$query ="SELECT * FROM baihat,casi,album, quangcao WHERE casi.MACASI = album.MACASI AND baihat.MAALBUM = album.MAALBUM AND quangcao.MABAIHAT = baihat.MABAIHAT ORDER BY baihat.NGAYPHATHANH";

	$data = mysqli_query($con,$query);

	class Quangcao{

		function Quangcao($MAQUANGCAO ,$URLHINHQUANGCAO,$MIEUTA,$MABAIHAT){ 
		    
		    $this->MAQUANGCAO = $MAQUANGCAO;
            $this->URLHINHQUANGCAO = $URLHINHQUANGCAO;
			$this->MIEUTA = $MIEUTA;
			$this->MABAIHAT = $MABAIHAT;
		}	
	}
	$mangquangcao = array();
	while ($row = mysqli_fetch_assoc($data)) {
		array_push($mangquangcao, new Quangcao(	$row['MAQUANGCAO'],$row['URLHINHQUANGCAO'],
												$row['MIEUTA'],
												$row['MABAIHAT']));
		
		# code...
	}
	echo json_encode($mangquangcao);

?>