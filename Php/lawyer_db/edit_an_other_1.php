<html>
<head>
<title>Edit an Other</title>
</head>

<body>
<h1>Edit an Other</h1>

<?php

	$logFile = "lawyer_db_log.txt";
	$log = fopen($logFile, 'a') or die("can't open file");


	$other_stuff=$_POST['other_id'];
	$case=$_POST['case'];

	@ $db = new mysqli('localhost', 'lawyer_db_admin', 'password', 'lawyer_db');

	if (mysqli_connect_errno())
	{
		echo 'Could not connect to db - try again.';
		exit;
	}

	$other_stuff_array = split("-", $other_stuff);
	$other_id=$other_stuff_array[0];

	$query="select * from other where other_id=".$other_id;


	$file_number=null;
	$fee_petition_name=null;
	$fee_petition_amount=null;

	$result = $db->query($query);
	$num_results = $result->num_rows;


	for ($i=0; $i < $num_results; $i++)
	{
		$row = $result->fetch_assoc();	
		$file_number=$row['file_number'];
		$fee_petition_name=$row['fee_petition_name'];
		$fee_petition_amount=$row['fee_petition_amount'];
	}

	echo "<form name='edit_an_other_1' action='edit_an_other_2.php' method='post'>";
	echo "<input type='hidden' id='case' name='case' value='".$case."' />";
	echo "<input type='hidden' id='other_id' name='other_id' value='".$other_id."' />";

	echo "<h2>Other</h2>";

	echo "File number:<input type='text' name='file_number' value='".$file_number."'/><br/>";
	echo "Fee petition name:<input type='text' name='fee_petition_name'  value='".$fee_petition_name."'/><br/>";
	echo "Fee petition amount:<input type='text' name='fee_petition_amount'  value='".$fee_petition_amount."'/><br/>";

	echo "<br/><input type='submit' value='Make Changes' />";


	fclose($log);
	$result->free();
	$db->close();


?>

</body>
</html>