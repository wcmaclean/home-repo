# requests.py
#
# Will MacLean
# CSPP 51060

import subprocess
import sys
import re

# grab cache directory from command-line input
if (len(sys.argv) == 2):
	cache_dir = sys.argv[1]
else:
	print "Usage: python requests <cache filepath>"
	sys.exit(0)

# read all filenames in directory
find_files = subprocess.Popen(['ls'], stdout = subprocess.PIPE, cwd = cache_dir)
data = find_files.stdout.read()

# split data into filenames
file_names = data.split()

# check against regex, open if true, and collect request data
re_cache = re.compile('_CACHE_')
re_date = re.compile('Date:')
re_http = re.compile('HTTP:')
re_clean = re.compile('HTTP:(.*)')
request_data = ''
for file in file_names:
	if (re_cache.search(file)):
		file_path = cache_dir + file
		file_open = open(file_path, "r")
		for line in file_open:
			if (re_date.search(line)):
				print line
				request_data = request_data + line
			if (re_http.search(line)):
				temp = re_clean.search(line)
				print temp.group()
				request_data = request_data + temp.group()

# save to a file
file_out = open('request_data', 'w')
file_out.write(request_data)
file_out.close()









