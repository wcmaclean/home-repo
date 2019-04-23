# domains.py
#
# Will MacLean
# CSPP51060

import subprocess
import sys
import re

# grab coche directory from command-line input
if (len(sys.argv) == 2):
	cache_dir = sys.argv[1]
else:
	print "Usage: python domains.py <cache filepath>"
	sys.exit(0)

# read all filenames in directory
find_files = subprocess.Popen(['ls'], stdout = subprocess.PIPE, cwd = cache_dir)
data = find_files.stdout.read()
file_names = data.split()

# pull out all domain names
re_cache = re.compile('_CACHE_')
re_clean = re.compile('HTTP:(.*).com{1}')
domains_data = []
for file in file_names:
	if (re_cache.search(file)):
		file_path = cache_dir + file
		file_open = open(file_path, "r")
		for line in file_open:
			if (re_clean.search(line)):
				domain = re_clean.search(line)
				fields = domain.group().split('/')
				domain = fields[2].lstrip('www.')
				domains_data.append(domain)

# sort alpha
domains_data.sort()

# sort unique
def unique(s):
	u = []
	for x in s:
		if x not in u:
			u.append(x)
	return u
domains_data = unique(domains_data)

# write to output
domains = ''
for value in domains_data:
	domains = domains + value
	print value
		
# write to file
# save to a file
file_out = open('domains_data', 'w')
file_out.write(domains)
file_out.close()

