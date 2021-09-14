<?php
	 require "connect.php";
    	$luotnghe = $_POST['luotnghe'];
    	$idbaihat = $_POST['idbaihat'];
    	$query ="SELECT * FROM baihat WHERE MABAIHAT = '$idbaihat'";
    	$data = mysqli_query($con,$query);
    	$row = mysqli_fetch_assoc($data);
    	$tongluotnghe = $row['LUOTNGHE'];
    	 if(isset($luotnghe)){
            $tongluotnghe =  $tongluotnghe + $luotnghe;
            
            $querysum="UPDATE baihat SET LUOTNGHE = '$tongluotnghe',TIMEUPDATE = CURRENT_TIME WHERE MABAIHAT = '$idbaihat'";
		 	$dataupdate = mysqli_query($con,$querysum);
		 	if ($dataupdate) {
		 		echo "Success";
		 	}
		 	else{
		 		echo "Fail";
		 	}
		 }

?>