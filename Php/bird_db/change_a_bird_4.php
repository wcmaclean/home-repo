<html>
<head>
<title>Change a bird</title>
</head>

<body>
<h1>Change a Bird</h1>

<?php

	$bird_id=$_POST['bird_id'];
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

/*
	@ $db = new mysqli('localhost', 'bird_db', 'bird_db', 'bird_db');
*/
	@ $db = new mysqli('localhost', 'dbmaster', 'edEaU5GWRyCQCyXy', 'Bird_DB');

	if (mysqli_connect_errno())
	{
		echo 'Could not connect to db - try again.';
		exit;
	}


	$query="update bird set bird_name='".$bird_name."' ".
					"where bird_id='".$bird_id."' ";
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - ".$query." - executed ok."."<br/>";
	}
	else
	{
		echo "An error has occurred during - ".$query."<br/>";
	}	

	$query="update bird set bird_species='".$bird_species."' ".
					"where bird_id='".$bird_id."' ";
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - ".$query." - executed ok."."<br/>";
	}
	else
	{
		echo "An error has occurred during - ".$query."<br/>";
	}	
	

	$query="update bird set bird_subspecies='".$bird_subspecies."' ".
					"where bird_id='".$bird_id."' ";
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - ".$query." - executed ok."."<br/>";
	}
	else
	{
		echo "An error has occurred during - ".$query."<br/>";
	}	


	$query="update bird set sex='".$sex."' ".
					"where bird_id='".$bird_id."' ";
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - ".$query." - executed ok."."<br/>";
	}
	else
	{
		echo "An error has occurred during - ".$query."<br/>";
	}	


	$query="update bird set sex_determined='".$sex_determined."' ".
					"where bird_id='".$bird_id."' ";
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - ".$query." - executed ok."."<br/>";
	}
	else
	{
		echo "An error has occurred during - ".$query."<br/>";
	}	


	$query="update bird set date_of_birth='".$birth_year."-".$birth_month."-".$birth_day."' ".
					"where bird_id='".$bird_id."' ";
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - ".$query." - executed ok."."<br/>";
	}
	else
	{
		echo "An error has occurred during - ".$query."<br/>";
	}	


	$query="update bird set date_in='".$turned_in_year."-".$turned_in_month."-".$turned_in_day."' ".
					"where bird_id='".$bird_id."' ";
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - ".$query." - executed ok."."<br/>";
	}
	else
	{
		echo "An error has occurred during - ".$query."<br/>";
	}	


	$query="update bird set vet_date='".$last_vet_year."-".$last_vet_month."-".$last_vet_day."' ".
					"where bird_id='".$bird_id."' ";
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - ".$query." - executed ok."."<br/>";
	}
	else
	{
		echo "An error has occurred during - ".$query."<br/>";
	}	


	$query="update bird set next_vet_date='".$next_vet_year."-".$next_vet_month."-".$next_vet_day."' ".
					"where bird_id='".$bird_id."' ";
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - ".$query." - executed ok."."<br/>";
	}
	else
	{
		echo "An error has occurred during - ".$query."<br/>";
	}	


	$query="update bird set bird_status='".$bird_status."' ".
					"where bird_id='".$bird_id."' ";
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - ".$query." - executed ok."."<br/>";
	}
	else
	{
		echo "An error has occurred during - ".$query."<br/>";
	}	


	$query="update bird set microchip='".$microchip."' ".
					"where bird_id='".$bird_id."' ";
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - ".$query." - executed ok."."<br/>";
	}
	else
	{
		echo "An error has occurred during - ".$query."<br/>";
	}	

	$query="update bird set turned_in_by='".$turned_in_by."' ".
					"where bird_id='".$bird_id."' ";
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - ".$query." - executed ok."."<br/>";
	}
	else
	{
		echo "An error has occurred during - ".$query."<br/>";
	}	


	$query="update bird set adopted_by='".$adopted_by."' ".
					"where bird_id='".$bird_id."' ";
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - ".$query." - executed ok."."<br/>";
	}
	else
	{
		echo "An error has occurred during - ".$query."<br/>";
	}	

	$bird_likes = str_replace("'", "&#39;", $bird_likes);
	$query="update bird set bird_likes='".$bird_likes."' ".
					"where bird_id='".$bird_id."' ";
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - ".$query." - executed ok."."<br/>";
	}
	else
	{
		echo "An error has occurred during - ".$query."<br/>";
	}	

	str_replace("'", "&#39;", $bird_dislikes);
	$query="update bird set bird_dislikes='".$bird_dislikes."' ".
					"where bird_id='".$bird_id."' ";
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - ".$query." - executed ok."."<br/>";
	}
	else
	{
		echo "An error has occurred during - ".$query."<br/>";
	}	

	str_replace("'", "&#39;", $bird_notes);
	$query="update bird set bird_notes='".$bird_notes."' ";
					"where bird_id='".$bird_id."' ";
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - ".$query." - executed ok."."<br/>";
	}
	else
	{
		echo "An error has occurred during - ".$query."<br/>";
	}	


?>

<form name='main_menu' action='index.php' method='post'>
<input type='submit' value='Main Menu' />
</form> 


<?php
	$result->free();
	$db->close();
?>

</body>
</html>