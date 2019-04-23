# findcache.py
#
# Will MacLean
# CSPP51060

import subprocess
import sys
import re

# grab main directory from command-line input
if (len(sys.argv) == 2):
	main_dir = sys.argv[1]
else:
	print "Usage: python findcache.py <filepath>"
	sys.exit(0)

# recursive read of all subdirectories into memory
find_dir = subprocess.Popen(['find', '.', '-print'], stdout = subprocess.PIPE, cwd = main_dir)
data = find_dir.stdout.read()

# split data into distinct paths and check against regex, store if match 
file_paths = data.split()
regex = re.compile('_CACHE_MAP_')
cache_paths = ''
for path in file_paths:
	if (regex.search(path)):
		temp = path.rstrip('_CACHE_MAP_')
		temp2 = temp.lstrip('.')
		cache_paths = cache_paths + main_dir + temp2 + '\n'
		print main_dir + temp2

# save to a file to make available for other programs
file_out = open('cache_paths', 'w')
file_out.write(cache_paths)
file_out.close()


