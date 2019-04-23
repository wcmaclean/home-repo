# portreader.py
#
# Will MacLean
# CSPP 51060

class my_reader(object):
	import string

	# constructor
	def __init__(self, filename):
		self.filename = filename

	# reading
	def read(self):
		import string

		# Return an int from string if it is one - False if not
		def isIntReturn(str):
			try: return int(str)
			except (ValueError, TypeError), e: return False

		# Return a float from a string if it is one - False if not
		def isFloatReturn(str):
			try: return float(str)
			except (ValueError, TypeError), e: return False

		# Parse data out according to file type
		file = open(self.filename, "r")
		parsedFile = []
                if(string.count(self.filename, ".csv")==True):
                        for line in file:
				fields = line.split(",")
				newLine = []
				for column in fields:
					newLine.append(column)
				parsedFile.append(newLine)
                elif(string.count(self.filename, ".rec")==True):
			newLine = []
			for line in file:
				if(string.count(line, "=")==True):
					tmp = string.rstrip(line)
					fields = tmp.split("=")
					newLine.append(fields[1])
				else:
					if (len(newLine) > 0):
						parsedFile.append(newLine)
					newLine = []
                else:
                        return "For more file types"
		# Return results
		return parsedFile
