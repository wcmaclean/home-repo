#Will MacLean
#!/usr/bin/gawk -f

#Based on the sample in the lab.

BEGIN {
	FS = "\t"
}

#$2 == state {
#	count++
#	rain += $(3 + mont)
#	print rain
#}

{
	if($2=="CA"){
		CaliforniaCount = CaliforniaCount + 1;
		CaliforniaTotal = CaliforniaTotal + $4;
	}
	if($2=="TX"){
		TexasCount = TexasCount + 1;
		TexasTotal = TexasTotal + $4;
	}
	if($2=="AK"){
		AlaskaCount = AlaskaCount + 1;
		AlaskaTotal = AlaskaTotal + $4;
	}
}

#END {
#	avg = rain/count
#	printf"%s for %s: %4.2f\n", state, month, avg
#}

END {
	print "The average for California rain is " CaliforniaTotal / CaliforniaCount " inches.";
	print "The average for Texas rain is " TexasTotal / TexasCount " inches."
	print "The average for Alaskan rain is " AlaskaTotal / AlaskaCount " inches."

}
	
