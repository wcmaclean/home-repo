<html>
<head>
<title>Change bird</title>
</head>

<body>
<h1>Change a Bird</h1>
<?php

	$bird_species=$_POST['bird_species'];
	$bird_subspecies=$_POST['bird_subspecies'];

	if (($bird_species=="") && ($bird_subspecies!=""))
	{
		echo "You can only select a subspecies if you select a species. Please go back and try again.";
		exit;
	}


/*
	@ $db = new mysqli('localhost', 'bird_db', 'bird_db', 'bird_db');
*/
	@ $db = new mysqli('localhost', 'dbmaster', 'edEaU5GWRyCQCyXy', 'Bird_DB');


	if (mysqli_connect_errno())
	{
		echo 'Could not connect to db - try again.';
		exit;
	}

	$query="select * from bird ";
	if ($bird_species!="")
	{
		$query=$query." where bird_species='".$bird_species."' ";
	}
	if ($bird_subspecies!="")
	{
		$query=$query." and bird_subspecies='".$bird_subspecies."' ";
	}
	$result = $db->query($query);
	$num_results = $result->num_rows;

	echo "<form name='change_a_bird_2' action='change_a_bird_3.php' method='post'>";

	echo "<p>Pick a bird - any bird...</p>";
	for ($i=0; $i < $num_results; $i++)
	{
		$row = $result->fetch_assoc();
		echo "<input type='radio' name='bird_id' value='".$row['bird_id']."'>".$row['bird_name']."</><br/>";
	}
	echo "</select><br/>";

	echo "<br/><input type='submit' value='Select this bird' />";

	echo "</form>";

	$result->free();
	$db->close();
?>


</body>
</html>