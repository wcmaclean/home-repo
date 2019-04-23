<html>
<head>
<title>Edit an Other</title>
</head>

<body>
<h1>Edit an Other</h1>

<?php


	$logFile = "lawyer_db_log.txt";
	$log = fopen($logFile, 'a') or die("can't open file");

	$other_id=$_POST['other_id'];
	$case=$_POST['case'];
	$file_number=$_POST['file_number'];
	$fee_petition_name=$_POST['fee_petition_name'];
	$fee_petition_amount=$_POST['fee_petition_amount'];

	@ $db = new mysqli('localhost', 'lawyer_db_admin', 'password', 'lawyer_db');

	if (mysqli_connect_errno())
	{
		echo 'Could not connect to db - try again.';
		exit;
	}

	$query = "update other set file_number='".$file_number."' where other_id='".$other_id."' ";
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


	$query = "update other set fee_petition_name='".$fee_petition_name."' where other_id='".$other_id."' ";
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

	$query = "update other set fee_petition_amount='".$fee_petition_amount."' where other_id='".$other_id."' ";
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