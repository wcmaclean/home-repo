<html>
<head>
<title>Edit a Lien</title>
</head>

<body>
<h1>Edit a Lien</h1>

<?php


	$logFile = "lawyer_db_log.txt";
	$log = fopen($logFile, 'a') or die("can't open file");

	$lien_id=$_POST['lien_id'];
	$case=$_POST['case'];
	$lien_name=$_POST['lien_name'];
	$lien_amount=$_POST['lien_amount'];
	$comments=$_POST['comments'];

	@ $db = new mysqli('localhost', 'lawyer_db_admin', 'password', 'lawyer_db');

	if (mysqli_connect_errno())
	{
		echo 'Could not connect to db - try again.';
		exit;
	}

	$query = "update lien set lien_name='".$lien_name."' where lien_id='".$lien_id."' ";
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


	$query = "update lien set lien_amount='".$lien_amount."' where lien_id='".$lien_id."' ";
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

	$query = "update lien set comments='".$comments."' where lien_id='".$lien_id."' ";
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