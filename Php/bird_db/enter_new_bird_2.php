<html>
<head>
<title>Enter a new bird</title>
</head>

<body>
<h1>Enter a New Bird</h1>

<?php


	$bird_name=$_POST['bird_name'];
	$bird_species=$_POST['bird_species'];
	$bird_subspecies=$_POST['bird_subspecies'];
	$sex=$_POST['sex'];
	$sex_determined=$_POST['sex_determined'];
	$birth_year=$_POST['birth_year'];
	$birth_month=$_POST['birth_month'];
	$birth_day=$_POST['birth_day'];
	$turned_in_year=$_POST['turned_in_year'];
	$turned_in_month=$_POST['turned_in_month'];
	$turned_in_day=$_POST['turned_in_day'];
	$last_vet_year=$_POST['last_vet_year'];
	$last_vet_month=$_POST['last_vet_month'];
	$last_vet_day=$_POST['last_vet_day'];
	$next_vet_year=$_POST['next_vet_year'];
	$next_vet_month=$_POST['next_vet_month'];
	$next_vet_day=$_POST['next_vet_day'];
	$bird_status=$_POST['bird_status'];
	$microchip=$_POST['microchip'];
	$turned_in_by=$_POST['turned_in_by'];
	$adopted_by=$_POST['adopted_by'];
	$bird_likes=$_POST['bird_likes'];
	$bird_dislikes=$_POST['bird_dislikes'];
	$bird_notes=$_POST['bird_notes'];

	if (!bird_name)
	{
		echo "You must enter a bird name. Please go back and try again.";
		exit;
	}

	str_replace("'", "&#39;", $bird_likes);
	str_replace("'", "&#39;", $bird_notes);


	$query="insert into bird values(null, ".
					"'".$bird_name."', ".
					"'".$bird_species."', ".
					"'".$bird_subspecies."', ".
					"'".$sex."', ".
					"'".$sex_determined."', ".
					"'".$birth_year."-".$birth_month."-".$birth_day."', ".
					"'".$turned_in_year."-".$turned_in_month."-".$turned_in_day."', ".
					"'".$last_vet_year."-".$last_vet_month."-".$last_vet_day."', ".
					"'".$next_vet_year."-".$next_vet_month."-".$next_vet_day."', ".
					"'".$bird_status."', ".
					"'".$microchip."', ".
					"'".$turned_in_by."', ".
					"'".$adopted_by."', ".
					"'".$bird_likes."', ".
					"'".$bird_dislikes."', ".
					"'".$bird_notes."') ";
	echo $query;



/*
	@ $db = new mysqli('localhost', 'bird_db', 'bird_db', 'bird_db');
*/
	@ $db = new mysqli('localhost', 'dbmaster', 'edEaU5GWRyCQCyXy', 'Bird_DB');

	if (mysqli_connect_errno())
	{
		echo 'Could not connect to db - try again.';
		exit;
	}



	$result = $db->query($query);

	if ($result)
	{
		echo $db->affected_rows." - The bird has been entered into the database.";
	}
	else
	{
		echo "An error has occurred, and the bird was not entered into the database.";
	}	


	$result->free();
	$db->close();


?>

</body>
</html>