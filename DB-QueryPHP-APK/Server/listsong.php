<?php
	 require "connect.php";
// 	 $query = "SELECT baihat.*,casi.TENCASI FROM baihat,baihat_casi,casi WHERE baihat.MABAIHAT = baihat_casi.MABAIHAT AND casi.MACASI = baihat_casi.MACASI";
	 
	 class Baihat
	 {
	 	
	 	function Baihat($mabaihat,$tenbaihat,$mieuta, $loibaihat, $urlbaihat,$luotnghe,$urlhinhbaihat, $manhacsi,$matoplist,$maalbum,$ngayphathanh,$urlbanner,$tencasi,$macasi)

	 	{
	 	$this -> MABAIHAT= $mabaihat;
	 	$this -> TENBAIHAT = $tenbaihat;
	 	$this -> MIEUTA = $mieuta;
	 	$this -> LOIBAIHAT = $loibaihat;
	 	$this -> URLBAIHAT= $urlbaihat;
	 	$this -> LUOTNGHE = $luotnghe;
	 	$this -> URLHINHBAIHAT= $urlhinhbaihat;
	 	$this -> MANHACSI = $manhacsi;
	  	$this -> MATOPLIST= $matoplist;
	  	$this -> MAALBUM= $maalbum;
	 	$this -> NGAYPHATHANH = $ngayphathanh;
	 	$this -> URLBANNER = $urlbanner;
	 	$this -> TENCASI = $tencasi;
	 	$this -> MACASI = $macasi;
	  	}
	 }

	$arraylistsong = array();
		$query = "SELECT DISTINCT a.*,d.TENCASI,d.MACASI FROM baihat a , baihat_casi c, casi d WHERE c.MACASI = d.MACASI AND a.MABAIHAT = c.MABAIHAT ";

	
	if(isset($_POST['idtoplist'])){
	 	$idtoplist = $_POST['idtoplist'];
	    $query = "SELECT DISTINCT * FROM baihat,toplist,casi,album WHERE casi.MACASI = album.MACASI AND baihat.MAALBUM = album.MAALBUM AND toplist.MATOPLIST = baihat.MATOPLIST AND FIND_IN_SET('$idtoplist', toplist.MATOPLIST)";

	}
	if(isset($_POST['idbanner'])){
  		$idbanner= $_POST['idbanner'];
		$query = "SELECT * FROM baihat,casi,album,quangcao WHERE casi.MACASI = album.MACASI AND album.MAALBUM = baihat.MAALBUM AND baihat.MABAIHAT = quangcao.MABAIHAT AND FIND_IN_SET('$idbanner',quangcao.MAQUANGCAO) LIMIT 5";
	  
    }
  	if(isset($_POST['idsinger'])){
        $idsinger = $_POST['idsinger'];
		$query = "SELECT DISTINCT * FROM baihat,album,casi WHERE casi.MACASI = album.MACASI AND album.MAALBUM = baihat.MAALBUM AND FIND_IN_SET('$idsinger', casi.MACASI)";
	}
	if(isset($_POST['idplaylistalbum'])){
            $idplaylistalbum = $_POST['idplaylistalbum'];
		    $query ="SELECT * FROM casi,baihat,album WHERE casi.MACASI = album.MACASI AND album.MAALBUM = baihat.MAALBUM AND FIND_IN_SET('$idplaylistalbum', album.MAALBUM)";
	}	
	if(isset($_POST['idgenre'])){
        $idgenre = $_POST['idgenre'];
		$query = "SELECT DISTINCT * FROM baihat,casi,album,theloai WHERE casi.MACASI = album.MACASI AND album.MAALBUM = baihat.MAALBUM AND theloai.MATHELOAI = baihat.MATHELOAI AND FIND_IN_SET('$idgenre', theloai.MATHELOAI)";
	}
	
	
	$data = mysqli_query($con,$query);
	while ($row = mysqli_fetch_assoc($data)) {
 	array_push($arraylistsong, new Baihat(	$row['MABAIHAT'], 
 											$row['TENBAIHAT'],
 											$row['MIEUTA'],
 											$row['LOIBAIHAT'],
 											$row['URLBAIHAT'], 
 											$row['LUOTNGHE'], 
 											$row['URLHINHBAIHAT'], 
 											$row['MANHACSI'],
 											$row['MATOPLIST'],
 											$row['MAALBUM'],
 											$row['NGAYPHATHANH'],
 											$row['URLBANNER'],
 											$row['TENCASI'],
 											$row['MACASI'])); 
  			
  }
    echo json_encode($arraylistsong);
?>