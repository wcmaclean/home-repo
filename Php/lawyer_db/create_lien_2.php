<html>
<head>
<title>Enter a Lien</title>
</head>

<body>
<h1>Enter a Lien</h1>

<?php


	$logFile = "lawyer_db_log.txt";
	$log = fopen($logFile, 'a') or die("can't open file");

	$case=$_POST['case'];
	$lien_name=$_POST['lien_name'];
	$lien_amount=$_POST['lien_amount'];
	$comment=$_POST['comment'];

	@ $db = new mysqli('localhost', 'lawyer_db_admin', 'password', 'lawyer_db');

	if (mysqli_connect_errno())
	{
		echo 'Could not connect to db - try again.';
		exit;
	}

	/* create it */
	$query = "insert into lien values(null,".$case." ,".
		"'".$lien_name."', ".
		"'".$lien_amount."', ".
		"'".$comment."') ";

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