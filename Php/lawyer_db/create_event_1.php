<html>
<head>
<title>Enter an Event</title>
</head>

<body>
<h1>Enter an Event</h1>
<?php



	$case=$_POST['case'];


	echo "<form name='create_event_1' action='create_event_2.php' method='post'>";

	echo "<input type='hidden' id='case' name='case' value='".$case."' />";

	echo "<h2>Event</h2>";

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

	echo "Event name:<input type='text' name='event_name' /><br/>";
	echo "Location:<input type='text' name='location' /><br/>";

	echo "<br/><input type='submit' value='Enter Event' />";
	echo "</form>";


?>


</body>
</html>