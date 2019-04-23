#! /usr/bin/env tclsh

puts "\nName \tShares \tPrice"
puts "---- \t------ \t-----"

set total 0

set file [open "portfolio.txt"]
set content [read $file]
close $file

set records [split $content "\n"]

foreach rec $records {
	set fields [split $rec " "]
	set name [lindex $rec 0]
	set shares [lindex $rec 1]
	set price [lindex $rec 2]
	puts "$name \t$shares \t$price"
	# if [ $shares -gt 0 ] set total [expr {$total + $shares * $price}]
}

puts "\nTotal Cost: $total"
