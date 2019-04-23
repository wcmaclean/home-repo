<html>
<head>
<title>Change bird</title>
</head>

<body>
<h1>Change a Bird</h1>
<?php

/*
	@ $db = new mysqli('localhost', 'bird_db', 'bird_db', 'bird_db');
*/
	@ $db = new mysqli('localhost', 'dbmaster', 'edEaU5GWRyCQCyXy', 'Bird_DB');

	if (mysqli_connect_errno())
	{
		echo 'Could not connect to db - try again.';
		exit;
	}

	$query="select distinct bird_species from bird_species order by bird_species";
	$result = $db->query($query);
	$num_results = $result->num_rows;

	echo "<form name='change_a_bird_1' action='change_a_bird_2.php' method='post'>";

	echo "Species:<select name='bird_species'>";
	echo "<option></option>";
	for ($i=0; $i < $num_results; $i++)
	{
		$row = $result->fetch_assoc();
		echo "<option>".$row['bird_species']."</option>";
	}
	echo "</select><br/>";


	$query="select distinct bird_subspecies from bird_species order by bird_subspecies";
	$result = $db->query($query);
	$num_results = $result->num_rows;

	echo "Subspecies:<select name='bird_subspecies'>";
	echo "<option></option>";
	for ($i=0; $i < $num_results; $i++)
	{
		$row = $result->fetch_assoc();
		echo "<option>".$row['bird_subspecies']."</option>";
	}
	echo "</select><br/>";



	echo "<br/><input type='submit' value='Search birds of this species' />";

	echo "</form>";

	$result->free();
	$db->close();
?>


</body>
</html>