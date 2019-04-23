<html>
<head>
<title>Edit an Event</title>
</head>

<body>
<h1>Edit an Event</h1>

<?php

	$logFile = "lawyer_db_log.txt";
	$log = fopen($logFile, 'a') or die("can't open file");


	$event_stuff=$_POST['event_stuff'];
	$case=$_POST['case'];
echo $event_stuff;
	@ $db = new mysqli('localhost', 'lawyer_db_admin', 'password', 'lawyer_db');

	if (mysqli_connect_errno())
	{
		echo 'Could not connect to db - try again.';
		exit;
	}

	$event_stuff_array = split("-", $event_stuff);
	$event_id=$event_stuff_array[0];


	$query="select * from events where event_id=".$event_id;
echo $query;



	$event_date=null;
	$event=null;
	$location=null;

	$result = $db->query($query);
	$num_results = $result->num_rows;


	for ($i=0; $i < $num_results; $i++)
	{
		$row = $result->fetch_assoc();	
		$event_date=$row['event_date'];
		$event=$row['event'];
		$location=$row['location'];
	}



	echo "<form name='edit_event_1' action='edit_event_2.php' method='post'>";
	echo "<input type='hidden' id='case' name='case' value='".$case."' />";
	echo "<input type='hidden' id='event_id' name='event_id' value='".$event_id."' />";

	echo "<h2>Event</h2>";

	echo "Date - Year:<select name='year'>";
	$date_array = split("-", $event_date);
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


	echo "Event:<input type='text' name='event'  value='".$event."'/><br/>";
	echo "Location:<input type='text' name='location'  value='".$location."'/><br/>";


	echo "<br/><input type='submit' value='Make Changes' />";


	fclose($log);
	$result->free();
	$db->close();



?>

</body>
</html>