<html>
<head>
<title>Enter an Other</title>
</head>

<body>
<h1>Enter an Other</h1>
<?php



	$case=$_POST['case'];


	echo "<form name='create_other_1' action='create_other_2.php' method='post'>";

	echo "<input type='hidden' id='case' name='case' value='".$case."' />";

	echo "<h2>Other</h2>";

	echo "File number:<input type='text' name='file_number' /><br/>";
	echo "Fee petition name:<input type='text' name='fee_petition_name' /><br/>";
	echo "Fee petition amount:<input type='text' name='fee_petition_amount' /><br/>";

	echo "<br/><input type='submit' value='Enter Other' />";
	echo "</form>";


?>


</body>
</html>