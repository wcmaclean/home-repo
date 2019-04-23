<html>
<head>
<title>Change a bird</title>
</head>

<body>
<h1>Change a Bird</h1>
<?php
	$bird_id=$_POST['bird_id'];

	if(!$bird_id)
	{
		echo "Please go back and select a bird.";
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

	$query="select distinct * from bird where bird_id=".$bird_id;

	$result = $db->query($query);
	$num_results = $result->num_rows;
/*
echo $query."<br/>";
echo $num_results."<br/>";
*/

	for ($i=0; $i < $num_results; $i++)
	{
		$row = $result->fetch_assoc();	
		$bird_name=$row['bird_name'];
		$bird_species=$row['bird_species'];
		$bird_subspecies=$row['bird_subspecies'];
		$sex=$row['sex'];
		$sex_determined=$row['sex_determined'];
		$date_of_birth=$row['date_of_birth'];
		$date_in=$row['date_in'];
		$vet_date=$row['vet_date'];
		$next_vet_date=$row['next_vet_date'];
		$bird_status=$row['bird_status'];
		$microchip=$row['microchip'];
		$turned_in_by=$row['turned_in_by'];
		$adopted_by=$row['adopted_by'];
		$bird_likes=$row['bird_likes'];
		$bird_dislikes=$row['bird_dislikes'];
		$bird_notes=$row['bird_notes'];		
	}

/*
echo $bird_name;
echo $bird_species;
echo $bird_subspecies;
echo $sex;
echo $sex_determined;
echo $date_of_birth;
echo $date_in;
echo $vet_date;
echo $next_vet_date;
echo $bird_status;
echo $microchip;
echo $turned_in_by;
echo $adopted_by;
echo $bird_likes;
echo $bird_notes;
*/

	echo "<form name='change_a_bird_3' action='change_a_bird_4.php' method='post'>";

	echo "<input type='hidden' name='bird_id' value=".$bird_id." />";

	echo "Bird name:<input type='text' name='bird_name' value='".$bird_name."' /><br/>";

	echo "Species:<select name='bird_species'>";
	echo "<option>".$bird_species."</option>";
	for ($i=0; $i < $num_results; $i++)
	{
		$row = $result->fetch_assoc();
		echo "<option>".$row['bird_species']."</option>";
	}
	echo "</select><br/>";


	$query="select distinct bird_subspecies from bird_species";
	$result = $db->query($query);
	$num_results = $result->num_rows;

	echo "Subspecies:<select name='bird_subspecies'>";
	echo "<option>".$bird_subspecies."</option>";
	for ($i=0; $i < $num_results; $i++)
	{
		$row = $result->fetch_assoc();
		echo "<option>".$row['bird_subspecies']."</option>";
	}
	echo "</select><br/>";

	echo "Sex:<select name='sex'>";
	echo "<option>".$sex."</option>";
	echo "<option>unknown</option>";
	echo "<option>male</option>";
	echo "<option>female</option>";
	echo "</select><br/>";

	echo "How was sex determined: <select name='sex_determined'>";
	echo "<option>".$sex_determined."</option>";
	echo "<option>not_determined</option>";
	echo "<option>laid_an_egg</option>";
	echo "<option>surgically</option>";
	echo "<option>dna</option>";
	echo "<option>tattoo - left wing web</option>";
	echo "<option>tattoo - right wing web</option>";
	echo "</select></br>";

	echo "Birth Date - Year:<select name='birth_year'>";
	$date_array = split("-", $date_of_birth);
	echo "<option>".$date_array[0]."</option>";
	for ($i=1970; $i < 2100; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select>";
	echo " Month:<select name='birth_month'>";
	echo "<option>".$date_array[1]."</option>";
	for ($i=1; $i < 12; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select>";
	echo " Day:<select name='birth_day'>";
	echo "<option>".$date_array[2]."</option>";
	for ($i=1; $i < 31; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select><br/>";

	echo "Date Turned In- Year:<select name='turned_in_year'>";
	$date_array = split("-", $date_in);
	echo "<option>".$date_array[0]."</option>";
	for ($i=1970; $i < 2100; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select>";
	echo " Month:<select name='turned_in_month'>";
	echo "<option>".$date_array[1]."</option>";
	for ($i=1; $i < 12; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select>";
	echo " Day:<select name='turned_in_day'>";
	echo "<option>".$date_array[2]."</option>";
	for ($i=1; $i < 31; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select><br/>";

	echo "Last vet Date - Year:<select name='last_vet_year'>";
	$date_array = split("-", $vet_date);
	echo "<option>".$date_array[0]."</option>";
	for ($i=1970; $i < 2100; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select>";
	echo " Month:<select name='last_vet_month'>";
	echo "<option>".$date_array[1]."</option>";
	for ($i=1; $i < 12; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select>";
	echo " Day:<select name='last_vet_day'>";
	echo "<option>".$date_array[2]."</option>";
	for ($i=1; $i < 31; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select><br/>";

	echo "Next Vet Date - Year:<select name='next_vet_year'>";
	$date_array = split("-", $next_vet_date);
	echo "<option>".$date_array[0]."</option>";
	for ($i=1970; $i < 2100; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select>";
	echo " Month:<select name='next_vet_month'>";
	echo "<option>".$date_array[1]."</option>";
	for ($i=1; $i < 12; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select>";
	echo " Day:<select name='next_vet_day'>";
	echo "<option>".$date_array[2]."</option>";
	for ($i=1; $i < 31; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select><br/>";



	echo "Bird status: <select name='bird_status'>";
	echo "<option>".$bird_status."</option>";
	echo "<option>resident</option>";
	echo "<option>permanent_resident</option>";
	echo "<option>adopted</option>";
	echo "<option>pending_adoption</option>";
	echo "<option>fostering</option>";
	echo "<option>euthanized</option>";
	echo "<option>deceased</option>";
	echo "</select></br>";

	echo "Microchip:<input type='text' name='microchip' value='".$microchip."' /><br/>";

	echo "Turned in by:<input type='text' name='turned_in_by' value='".$turned_in_by."' /><br/>";

	echo "Adopted by:<input type='text' name='adopted_by' value='".$adopted_by."'/><br/>";


	echo "Bird likes:<textarea name='bird_likes' rows='3' columns='100'>".$bird_likes."</textarea><br/>";

	echo "Bird dislikes:<textarea name='bird_dislikes' rows='3' columns='100'>".$bird_dislikes."</textarea><br/>";

	echo "Bird notes:<textarea name='bird_notes' rows='3' columns='100'>".$bird_notes."</textarea><br/>";


	echo "<br/><input type='submit' value='Change' />";

	echo "</form>";

?>


</body>
</html>