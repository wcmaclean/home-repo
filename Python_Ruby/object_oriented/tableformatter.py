# tableformatter.py
#
# Will MacLean
# CSPP 51060

class TableFormatter(object):
	# the base class prints text tables
	def __init__(self, headers, rowdata):	# constructor
		self.headers = headers
		self.rowdata = rowdata
	def headings(self, headers):		# print heads
		newStr = ''
		print '\n'				# skip line
		for heading in self.headers:		# walk thru heads
			newStr = newStr + heading + '\t'
		newStr = newStr + '\n'
		for i in range(0, len(headers)):	# print lines
			newStr = newStr + '----- \t'
		newStr = newStr + '\n'
		return newStr
	def row(self, rowdata):			# print rows
		import testmod
		newStr = ''
		for row in self.rowdata:		# grab a row
			for field in row:		# grab 	 field
				temp = str(field)
				newStr = newStr + temp + '\t'
			newStr = newStr + '\n'
		return newStr
	def endtable(self):			# not needed in text
		pass
	def buildtable(self, headers, rowdata):
		newStr = self.headings(self.headers)
		newStr = newStr + self.row(self.rowdata)
		self.writetable(newStr, 'table.txt')
		return newStr
	def writetable(self, table, filename):
		fileOut = open(filename, "w")
		fileOut.write(table)
		fileOut.close()

class HtmlTableFormatter(TableFormatter):
	def headings(self, headers):
		newStr = '<html><table><tr>'
		for heading in self.headers:
			newStr = newStr + '<td><b>' + heading + '</b></td>'
		newStr = newStr + '</tr>'
		return newStr
	def row(self, rowdata):
		newStr = ''
		for row in self.rowdata:
			newStr = newStr + '<tr>'
			for field in row:
				newStr = newStr + '<td>' + str(field) + '</td>'
			newStr = newStr + '</tr>'
		return newStr
	def endtable(self):
		return '</table></html>'
	def buildtable(self, headers, rowdata):
		newStr = self.headings(self.headers)
		newStr = newStr + self.row(self.rowdata)
		newStr = newStr + self.endtable()
		self.writetable(newStr, 'table.html')
		return newStr

class CsvTableFormatter(TableFormatter):
	def headings(self, headers):
		newStr = ''
		for heading in self.headers:
			newStr = newStr + heading + ','
		return newStr.rstrip(',') + '\n'
	def row(self, rowdata):
		newStr = ''
		for row in self.rowdata:
			for field in row:
				newStr = newStr + str(field) + ','
			newStr = newStr.rstrip(',') + '\n'
		return newStr
	def buildtable(self, headers, rowdata):
		newStr = self.headings(self.headers)
		newStr = newStr + self.row(self.rowdata)
		self.writetable(newStr, 'table.csv')
		return newStr

heads = [ "name", "shares", "price", "change" ]
rows = [ ["MSFT", 10, 26.00, -1.20],  ["ORCL", 20, 32.00, -2.20],  ["DDT", 30, 2.00, -0.20] ]

test = CsvTableFormatter( heads, rows )
#print test.headings( heads )
#print test.row( rows )
table = test.buildtable(heads, rows)
print table


