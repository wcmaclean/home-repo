<html>
<head>
<title>Enter an Event</title>
</head>

<body>
<h1>Enter an Event</h1>

<?php

	$logFile = "lawyer_db_log.txt";
	$log = fopen($logFile, 'a') or die("can't open file");

	$case=$_POST['case'];
	$year=$_POST['year'];
	$month=$_POST['month'];
	$day=$_POST['day'];
	$event_name=$_POST['event_name'];
	$location=$_POST['location'];

	@ $db = new mysqli('localhost', 'lawyer_db_admin', 'password', 'lawyer_db');

	if (mysqli_connect_errno())
	{
		echo 'Could not connect to db - try again.';
		exit;
	}

	/* create it */
	$query = "insert into events values(null, ".$case." ,".
		"'".$year."-".$month."-".$day."', ".
		"'".$event_name."', ".
		"'".$location."') ";

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