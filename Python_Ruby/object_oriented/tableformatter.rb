# tableformatter.rb
#
# Will MacLean
# CSPP 51060

class TableFormatter
	attr_reader :headers, :rowdata
	attr_writer :headers, :rowdata
	def initialize(headers, rowdata)
		@headers = headers
		@rowdata = rowdata
	end
	def headings(headers)
		newStr = ''
		for heading in @headers
			newStr = newStr + heading + '\t'
		end
		return newStr + '\n'
	end
	def row(rowdata)
		newStr = ''
		for row in @rowdata
			for field in row
				newStr = newStr + field.to_s + '\t'
			end
			newStr = newStr + '\n'
		end
		return newStr
	end
	def buildtable
		newStr = headings(@headers)
		newStr = newStr + row(@rowdata)
		writetable(newStr, 'table.txt')
		return newStr
	end
	def writetable(aTable, filename)
		fileOut = File.open(filename, 'w')
		fileOut.puts(aTable)
		fileOut.close
	end
end

class HtmlTableFormatter <TableFormatter
	def headings(headers)
		newStr = '<html><table><tr>'
		for heading in @headers
			newStr = newStr + '<td><b>' + heading + '</b></td>'
		end
		return newStr + '</tr>'
	end
	def row(rowdata)
		newStr = ''
		for row in @rowdata
			newStr = newStr + '<tr>'
			for field in row
				newStr = newStr + '<td>' + field.to_s + '</td>'
			end
			newStr = newStr + '</tr>'
		end
		return newStr
	end
	def endtable
		return '</table></html>'
	end
	def buildtable
		newStr = headings(@headers)
		newStr = newStr + row(@rowdata) + endtable
		writetable(newStr, 'table.html')
		return newStr
	end
end

class CsvTableFormatter <TableFormatter
        def headings(headers)
                newStr = ''
                for heading in @headers
                        newStr = newStr + heading + ','
                end
                return newStr.chomp(',') + '\n'
        end
        def row(rowdata)
                newStr = ''
                for row in @rowdata
                        for field in row
                                newStr = newStr + field.to_s + ','                        end
                        newStr = newStr.chomp(',') + '\n'
                end
                return newStr
        end
        def buildtable
                newStr = headings(@headers)
                newStr = newStr + row(@rowdata)
                writetable(newStr, 'table.csv')
                return newStr
        end
end

# test stuff
#heads = [ "name", "shares", "price", "change" ]
#rows = [ ["MSFT", 10, 26.00, -1.20],  ["ORCL", 20, 32.00, -2.20],  ["DDT", 30, 2.00, -0.20] ]

#test = CsvTableFormatter.new(heads, rows)
#print test.headings(heads)
#print test.row(rows)
#print test.buildtable



# this is just to move the prompt to the next line when done
printf "\n"

