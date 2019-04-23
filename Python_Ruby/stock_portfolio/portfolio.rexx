/* portfolio.cmd */
/* Will MacLean */

total = 0

say " "
say "Name  Shares  Price"
say "----  ------  -----"

myFile = "portfolio.txt";
rc = stream( myFile, "c", "open" );

do while( lines( myFile ) )
	rec = linein( myFile )
	/* say rec */
	parse var rec name " " shares " " price
	say name format(shares, 5, 0) format(price, 5, 2)
	total = total + shares * price
end

say " "
say "Total Cost: " total
rc = stream(myFile, "c", "close");


