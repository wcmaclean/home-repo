# Will MacLean
# CSPP 51060
# portfolio.rb

total = 0

puts "\nName \tShares \tPrice \n"
puts "---- \t------ \t----- \n"

File.readlines('portfolio.txt').each do |line|
	fields = line.split(" ", 3)
	puts fields[0] + "\t" + fields[1].to_s + "\t" + fields[2].to_s
	shares = fields[1].to_f
	price = fields[2].to_f
	total = total + shares * price
end

puts "\nTotal Cost: " + total.to_s + "\n"

