<html>
<head>
<title>Edit an Event</title>
</head>

<body>
<h1>Edit an Event</h1>

<?php


	$logFile = "lawyer_db_log.txt";
	$log = fopen($logFile, 'a') or die("can't open file");

	$event_id=$_POST['event_id'];
	$case=$_POST['case'];
	$year=$_POST['year'];
	$month=$_POST['month'];
	$day=$_POST['day'];
	$event=$_POST['event'];
	$location=$_POST['location'];

	@ $db = new mysqli('localhost', 'lawyer_db_admin', 'password', 'lawyer_db');

	if (mysqli_connect_errno())
	{
		echo 'Could not connect to db - try again.';
		exit;
	}

	$query = "update events set event_date='".$year."-".$month."-".$day."' where event_id='".$event_id."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}


	$query = "update events set event='".$event."' where event_id='".$event_id."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}

	$query = "update events set location='".$location."' where event_id='".$event_id."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}


	echo "<form name='back_to_main_screen' action='view_a_case.php' method='post'>";
	echo "<input type='hidden' id='default_case' name='default_case' value='".$case."' />";
	echo "<input type='submit' value='Back to the Case' />";
	echo "</form>";



	fclose($log);
	$db->close();






?>

</body>
</html>