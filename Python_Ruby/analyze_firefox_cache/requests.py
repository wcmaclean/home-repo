# requests.py
#
# Will MacLean
# CSPP 51060

import subprocess
import sys
import re
import struct
import os
import time

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
re_cache = re.compile('_CACHE_00')
re_cache_001 = re.compile('_CACHE_001_')
re_cache_002 = re.compile('_CACHE_002_')
re_cache_003 = re.compile('_CACHE_003_')
request_data = ''
magic_num = 65544
for file in file_names: 
	pos = 4096
	block = 0
	file_open = open(cache_dir + file, "r")
	file_size = os.path.getsize(cache_dir + file)
	if(re_cache.search(file)): # see if filename contains "CACHE"
		print file
		if (re_cache_001.search(file)):	# for blocks of 256
			block = 256
		if (re_cache_002.search(file)): # for blocks of 1024
			block = 1024
		if (re_cache_003.search(file)): # for blocks of 4096
			block = 4096
		while (pos < file_size):	# read blocks until EOF
			file_open.seek(pos)				# getting metadata block
			head = file_open.read(36)
			fields = struct.unpack(">9I", head)
			# compare to 0x00010008 and 0x00010005?
			#if(magic_num==0):				# getting magic number
			#	magic_num = int(fields[0])
			if(magic_num == int(fields[0])):			# test if magic number
				req_time = time.ctime(float(fields[3]))		# getting request time
				req_size = int(fields[7])			# getting request URL
				file_open.seek(pos + 36)
				req_url = str(file_open.read(req_size))
				#print magic_num
				print req_time
				print req_url
				print "--"
				request_data = request_data + req_time + req_url + "\n"
			pos = pos + block

# save to a file
file_out = open('request_data', 'w')
file_out.write(request_data)
file_out.close()






