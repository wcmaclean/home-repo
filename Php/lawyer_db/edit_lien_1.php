<html>
<head>
<title>Edit a Lien</title>
</head>

<body>
<h1>Edit a Lien</h1>

<?php

	$logFile = "lawyer_db_log.txt";
	$log = fopen($logFile, 'a') or die("can't open file");


	$lien_stuff=$_POST['lien_stuff'];
	$case=$_POST['case'];
echo $lien_stuff;
	@ $db = new mysqli('localhost', 'lawyer_db_admin', 'password', 'lawyer_db');

	if (mysqli_connect_errno())
	{
		echo 'Could not connect to db - try again.';
		exit;
	}

	$lien_stuff_array = split("-", $lien_stuff);
	$lien_id=$lien_stuff_array[0];


	$query="select * from lien where lien_id=".$lien_id;
echo $query;



	$lien_name=null;
	$lien_amount=null;
	$comments=null;

	$result = $db->query($query);
	$num_results = $result->num_rows;


	for ($i=0; $i < $num_results; $i++)
	{
		$row = $result->fetch_assoc();	
		$lien_name=$row['lien_name'];
		$lien_amount=$row['lien_amount'];
		$comments=$row['comments'];
	}

	echo "<form name='edit_lien_1' action='edit_lien_2.php' method='post'>";
	echo "<input type='hidden' id='case' name='case' value='".$case."' />";
	echo "<input type='hidden' id='lien_id' name='lien_id' value='".$lien_id."' />";

	echo "<h2>Lien</h2>";

	echo "Lien name:<input type='text' name='lien_name' value='".$lien_name."'/><br/>";
	echo "Lien amount:<input type='text' name='lien_amount'  value='".$lien_amount."'/><br/>";
	echo "Comments:<input type='text' name='comments'  value='".$comments."'/><br/>";

	echo "<br/><input type='submit' value='Make Changes' />";


	fclose($log);
	$result->free();
	$db->close();


?>

</body>
</html>