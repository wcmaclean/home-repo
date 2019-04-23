<html>
<head>
<title>Search for a Case</title>
</head>

<body>
<h1>Search for a Case</h1>

<?php


	$logFile = "lawyer_db_log.txt";
	$log = fopen($logFile, 'a') or die("can't open file");

	/* get the search string */
	$search_string=$_POST['search_string'];

	@ $db = new mysqli('localhost', 'lawyer_db_admin', 'password', 'lawyer_db');

	if (mysqli_connect_errno())
	{
		echo 'Could not connect to db - try again.';
		exit;
	}


	echo "<form name='input' action='view_a_case.php' method='post'>";

	if($search_string)
	{
		$query="select * from client where client_last_name regexp '^".$search_string."'";
	}
	else
	{
		$query="select * from client";
	}
	$result = $db->query($query);
	$num_results = $result->num_rows;

	for ($i=0; $i < $num_results; $i++)
	{
		$row = $result->fetch_assoc();
		echo "<input type='radio' name='default_case' value='".$row['client_id']."' >".$row['client_last_name'].", ".$row['client_first_name']."</><br/>";
	}

	echo "</select><br/>";

	echo "<br/><input type='submit' value='Select this Case' />";
	echo "</form>";

	$result->free();
	$db->close();



?>

</body>
</html> 