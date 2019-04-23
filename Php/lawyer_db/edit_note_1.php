<html>
<head>
<title>Edit a Note</title>
</head>

<body>
<h1>Edit a Note</h1>

<?php

	$logFile = "lawyer_db_log.txt";
	$log = fopen($logFile, 'a') or die("can't open file");


	$note_stuff=$_POST['note_stuff'];
	$case=$_POST['case'];
echo $note_stuff;
	@ $db = new mysqli('localhost', 'lawyer_db_admin', 'password', 'lawyer_db');

	if (mysqli_connect_errno())
	{
		echo 'Could not connect to db - try again.';
		exit;
	}

	$note_stuff_array = split("-", $note_stuff);
	$note_id=$note_stuff_array[0];


	$query="select * from notes where note_id=".$note_id;
echo $query;



	$note_date=null;
	$note=null;

	$result = $db->query($query);
	$num_results = $result->num_rows;


	for ($i=0; $i < $num_results; $i++)
	{
		$row = $result->fetch_assoc();	
		$note_date=$row['note_date'];
		$note=$row['note'];
	}



	echo "<form name='edit_note_1' action='edit_note_2.php' method='post'>";
	echo "<input type='hidden' id='case' name='case' value='".$case."' />";
	echo "<input type='hidden' id='note_id' name='note_id' value='".$note_id."' />";

	echo "<h2>Note</h2>";

	echo "Date - Year:<select name='year'>";
	$date_array = split("-", $note_date);
	echo "<option>".$date_array[0]."</option>";
	for ($i=1970; $i < 2100; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select>";
	echo " Month:<select name='month'>";
	echo "<option>".$date_array[1]."</option>";
	for ($i=1; $i < 12; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select>";
	echo " Day:<select name='day'>";
	echo "<option>".$date_array[2]."</option>";
	for ($i=1; $i < 31; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select><br/>";


	echo "Note:<input type='text' name='note'  value='".$note."'/><br/>";

	echo "<br/><input type='submit' value='Make Changes' />";


	fclose($log);
	$result->free();
	$db->close();


?>

</body>
</html>