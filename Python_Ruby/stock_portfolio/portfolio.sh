#! /bin/sh

# Will MacLean
# CSPP 51060
# portfolio.sh

echo "\nName \tShares \tPrice "
echo "---- \t------ \t----- "

exec 3< portfolio.txt
while read line <&3
do
	set -- $line
	echo $1 "\t" $2 "\t" $3
	set total exp '$2' '*' '$3'
	# echo "$total"
done

echo "\nTotal Cost: " $total "\n"

