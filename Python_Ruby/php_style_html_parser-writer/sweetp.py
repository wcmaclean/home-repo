# sweetp.py
#
# Will MacLean
# CSPP 51060

import csv
import copy
import sys # for getting command line args
filename = sys.argv[1] # getting filename from command line

code = ""		# for code read from input file
codeMode = "off"	# toggles between storing code or text
globals = {}
locals = {}

# open input and output files
fileIn = open( filename, "r" ) # open file for reading
fileOut = open( filename + ".html", "w" ) # open file for writing

# read each line from input file
for line in fileIn:
	line.strip() 				# kill extra spaces
	fields = line.split()			# split line to array

	# process line if it has something	
	if (len(fields) > 0):			
		if fields[0]=="<?": 		# code in input starts here
			codeMode = "on"
		elif fields[0]=="?>": 		# code in input ends here
			codeMode = "off"
			codeObj = compile(code, '<string>', 'exec')
			#exec(codeObj, globals, locals) # executing code from input
			a = eval(codeObj, globals, locals)
			print a 	
			#exec(code, globals, locals)
			#fileOut.write( str( eval(codeObj, globals, locals) ) )
			#print locals
			#fileOut.write( str(locals) )
			code = [] 		# reset code
		else:				
			if codeMode == "on":	# build code string if code
				code = code + line
			if codeMode == "off":	# write to file if text
				# looking for variables in "${...}" format
				for word in fields:
					start = word.find("${") # start of var
					end = word.find("}")	# end of var
					if (start == 0):
						variable = "" 	# build var 
						for i in range(start+2, end):
							variable = variable + word[i]
						print variable
						var = locals[variable]
						fileOut.write( str(var) + " " )
					else:
						fileOut.write( word + " " )

#print globals
#print locals
fileIn.close()
fileOut.close()