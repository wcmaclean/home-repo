# Will MacLean
# CSPP 51060
# portfolio.py

filename = "portfolio.txt"
total = 0
shares = 0
price = 0

print
print "Name \tShares \t Price"
print "---- \t------ \t -----"

file = open( filename, "r" )
for line in file:
	fields = line.split()
	shares = int(fields[1])
	price = float(fields[2])
	# print fields[0], "\t", shares, "\t", price
	print "%s \t%5.0f \t%6.2f" % (fields[0], shares, price) 
	total = total + shares * price

print "\nTotal cost: ", total, "\n"



	


