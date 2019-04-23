# portreader.rb
#
# Will MacLean
# CSPP 51060

# creating a my_reader class
class My_Reader

	# constructor
	def initialize(filename)
		@filename = filename
	end

	def read
		parsedFile = []
		if(@filename.include? ".csv")
			File.readlines(@filename). each do |line|
				fields = line.split(",")
				newLine = []
				for column in fields
					newLine.push(column)
				end
				print newLine[1]
				parsedFile.push(newLine)
			end
		elsif(@filename.include? ".rec")
			newLine = []
			File.readlines(@filename). each do |line|
				if(line.length > 1)
					temp = line.rstrip
					fields = temp.split("=")
					newLine.push(fields[1])
				else
					if(newLine.length > 0)
						print newLine
						parsedFile.push(newLine)
					end
					newLine = []
				end
			end
		else
			return "for future development"
		end
		return parsedFile
	end
end

#test = My_Reader.new("dowportfolio.rec")
#print test.read

