# Will MacLean
# CSPP 51060
# portfolio.pl

$filename = "portfolio.txt";
$total = 0;
$shares = 0;
$price = 0;

print "\n";
print "Name \tShares \t Price\n";
print "---- \t------ \t -----\n";

open file, $filename or die $!;
while ($record = <file>) {
	# print $record;
	@fields = split(/ /, $record, 3);
	printf "%s \t%5.0f \t%6.2f \n", @fields[0], @fields[1], @fields[2];
	$total = $total + @fields[1] * @fields[2];
}

print "\nTotal cost: ", $total, "\n\n";
close(file);
