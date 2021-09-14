<?php
	require "connect.php";
	$query = "SELECT DISTINCT * FROM toplist ORDER BY rand(" . date("Ymd") . ") LIMIT 3";

	// if ($query) {
	// 	echo "ok";
	// 	# code...
	// }else{
	// 	echo "fail";
	// }

	$data = mysqli_query($con,$query);

	class ToplistToday{

		function ToplistToday($idtop,$tentoplist,$hinhtoplist,$icontoplist){
			$this->MATOPLIST = $idtop;
			$this->TENTOPLIST = $tentoplist;
			$this->URLHINHTOPLIST = $hinhtoplist;
			$this->ICONTOPLIST = $icontoplist;
		}	
	}
	$mangtoplist = array();
	while ($row = mysqli_fetch_assoc($data)) {
		array_push($mangtoplist, new ToplistToday($row['MATOPLIST'],$row['TENTOPLIST'],
												$row['URLHINHTOPLIST'],$row['ICONTOPLIST']));
		
		# code...
	}
	echo json_encode($mangtoplist);

?>