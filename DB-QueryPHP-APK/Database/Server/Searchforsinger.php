<?php
	require "connect.php";
	class Singer{
		function Singer($MACASI, $TENCASI, $TIEUSU, $URLCASI){
			$this -> MACASI = $MACASI;
			$this -> TENCASI = $TENCASI;
			$this -> TIEUSU = $TIEUSU;
			$this -> URLCASI = $URLCASI;
		}
	}
	$arraysinger = array();
	if(isset($_POST['tukhoa'])){
            $tukhoa = $_POST['tukhoa'];
		    $query = "SELECT * FROM casi WHERE lower(TENCASI) LIKE '%$tukhoa%'";
		    $data = mysqli_query($con, $query);
	while ($row = mysqli_fetch_assoc($data)) {
	array_push($arraysinger, new Singer($row['MACASI'] 
										,$row['TENCASI']
										,$row['TIEUSU']
										,$row['URLCASI']));
	}
	echo json_encode($arraysinger);
  }
?>