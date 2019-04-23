<html>
<head>
<title>Enter a new bird</title>
</head>

<body>
<h1>Enter a New Bird</h1>
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

	echo "<form name='enter_new_bird_1' action='enter_new_bird_2.php' method='post'>";

	echo "Bird name:<input type='text' name='bird_name' /><br/>";

	echo "Species:<select name='bird_species'>";
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
	for ($i=0; $i < $num_results; $i++)
	{
		$row = $result->fetch_assoc();
		echo "<option>".$row['bird_subspecies']."</option>";
	}
	echo "</select><br/>";

	echo "Sex:<input type='radio' name='sex' value='unknown' checked>unknown</>";
	echo "<input type='radio' name='sex' value='male'>male</>";
	echo "<input type='radio' name='sex' value='female'>female</><br/>";

	echo "How was sex determined: <select name='sex_determined'>";
	echo "<option>not_determined</option>";
	echo "<option>laid_an_egg</option>";
	echo "<option>surgically</option>";
	echo "<option>dna</option>";
	echo "<option>tattoo - left wing web</option>";
	echo "<option>tattoo - right wing web</option>";
	echo "</select></br>";

	echo "Birth Date - Year:<select name='birth_year'>";
	echo "<option>0000</option>";
	for ($i=1970; $i < 2100; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select>";
	echo " Month:<select name='birth_month'>";
	echo "<option>00</option>";
	for ($i=1; $i < 12; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select>";
	echo " Day:<select name='birth_day'>";
	echo "<option>00</option>";
	for ($i=1; $i < 31; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select><br/>";

	echo "Date Turned In- Year:<select name='turned_in_year'>";
	echo "<option>0000</option>";
	for ($i=1970; $i < 2100; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select>";
	echo " Month:<select name='turned_in_month'>";
	echo "<option>00</option>";
	for ($i=1; $i < 12; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select>";
	echo " Day:<select name='turned_in_day'>";
	echo "<option>00</option>";
	for ($i=1; $i < 31; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select><br/>";

	echo "Last vet Date - Year:<select name='last_vet_year'>";
	echo "<option>0000</option>";
	for ($i=1970; $i < 2100; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select>";
	echo " Month:<select name='last_vet_month'>";
	echo "<option>00</option>";
	for ($i=1; $i < 12; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select>";
	echo " Day:<select name='last_vet_day'>";
	echo "<option>00</option>";
	for ($i=1; $i < 31; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select><br/>";

	echo "Next Vet Date - Year:<select name='next_vet_year'>";
	echo "<option>0000</option>";
	for ($i=1970; $i < 2100; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select>";
	echo " Month:<select name='next_vet_month'>";
	echo "<option>00</option>";
	for ($i=1; $i < 12; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select>";
	echo " Day:<select name='next_vet_day'>";
	echo "<option>00</option>";
	for ($i=1; $i < 31; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select><br/>";



	echo "Bird status: <select name='bird_status'>";
	echo "<option>resident</option>";
	echo "<option>permanent_resident</option>";
	echo "<option>adopted</option>";
	echo "<option>pending_adoption</option>";
	echo "<option>fostering</option>";
	echo "<option>euthanized</option>";
	echo "<option>deceased</option>";
	echo "</select></br>";

	echo "Microchip:<input type='text' name='microchip' /><br/>";

	echo "Turned in by:<input type='text' name='turned_in_by' /><br/>";

	echo "Adopted by:<input type='text' name='adopted_by' /><br/>";

	echo "Bird likes:<textarea name='bird_likes' rows='3' columns='100'></textarea><br/>";

	echo "Bird dislikes:<textarea name='bird_dislikes' rows='3' columns='100'></textarea><br/>";

	echo "Bird notes:<textarea name='bird_notes' rows='3' columns='100'></textarea><br/>";

	echo "<br/><input type='submit' value='Enter the bird' />";

	echo "</form>";

	$result->free();
	$db->close();
?>


</body>
</html>