<html>
<head>
<title>Enter a Lien</title>
</head>

<body>
<h1>Enter a Lien</h1>
<?php



	$case=$_POST['case'];


	echo "<form name='create_lien_1' action='create_lien_2.php' method='post'>";

	echo "<input type='hidden' id='case' name='case' value='".$case."' />";

	echo "<h2>Lien</h2>";

	echo "Lien name:<input type='text' name='lien_name' /><br/>";
	echo "Lien amount:<input type='text' name='lien_amount' /><br/>";
	echo "Comments:<input type='text' name='comments' /><br/>";

	echo "<br/><input type='submit' value='Enter Other' />";
	echo "</form>";


?>


</body>
</html>