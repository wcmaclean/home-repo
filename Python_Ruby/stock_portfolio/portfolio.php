<?php

// Will MacLean
// CSPP 51060
// portfolio.php

$filename = "portfolio.txt";
$total = (float)0;
$shares = (float)0;
$price = (float)0;

echo "\nName \tShares \t  Price \n";
echo "---- \t------ \t  -----\n";

$file = fopen($filename, 'r') or die('goofed');
while(!feof($file))
{
	$line = fgets($file);
	//echo $line;

	list($name, $shares, $price) = split(" ", $line, 3);
	printf("%s \t %5.0f \t %6.2f \n", $name, $shares, $price);
	$total = $total + $shares * $price;

}

// report and close
echo "\nTotal Cost: ".$total." \n"; 
fclose($file);

?>

