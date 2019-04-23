<html>
<head>
<title>Enter a Note</title>
</head>

<body>
<h1>Enter a Note</h1>
<?php



	$case=$_POST['case'];


	echo "<form name='create_note_1' action='create_note_2.php' method='post'>";

	echo "<input type='hidden' id='case' name='case' value='".$case."' />";

	echo "<h2>Note</h2>";

	echo "Date - Year:<select name='year'>";
	echo "<option>0000</option>";
	for ($i=1970; $i < 2100; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select>";
	echo " Month:<select name='month'>";
	echo "<option>00</option>";
	for ($i=1; $i < 12; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select>";
	echo " Day:<select name='day'>";
	echo "<option>00</option>";
	for ($i=1; $i < 31; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select><br/>";

	echo "Notes:<input type='text' name='note' /><br/>";


	echo "<br/><input type='submit' value='Enter Note' />";
	echo "</form>";


?>


</body>
</html>