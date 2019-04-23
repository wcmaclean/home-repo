# storagejars.py
#
# Will MacLean
# CSPP 51060
# Final Project

import subprocess
import sys
import re
import struct
import os
import time
import gzip

# variables, for ease of editing
main_dir = "/Users"
cache_stash = "/cache_stash"

# create a directory for unzipping things
work_dir = os.getcwd()
cache_dir = work_dir + cache_stash
try:
	os.mkdir(cache_dir)
except:
	print "directory exists: ", cache_stash

# attempt to read directories from entire system
find_dir = subprocess.Popen(['find', '.', '-print'], stdout = subprocess.PIPE, cwd = main_dir)
dirs = find_dir.stdout.read()

# split data into paths and check to see if they have "_CACHE_MAP_" 
file_paths = dirs.split()
reg_cache = re.compile('_CACHE_MAP_')
cache_paths = []
for path in file_paths:
	if (reg_cache.search(path)):
		if (path == '2/_CACHE_MAP_'): # dunno where this is coming from
			pass
		else:
			temp = path.rstrip('_CACHE_MAP_')
			temp = main_dir + temp.lstrip('.')
			cache_paths.append(temp)

# function to save files
def save(file, data):
	f_out = open(file, 'w')
	f_out.write(data)
	f_out.close()


# start some html pages for output data
storagejars_name = "storage_jars.html"
storagejars_page = "<html><head><title>Storage Jars</title></head><body><h1>Storage Jars (_CACHE_ File Contents)</h1>"
cachestash_name = "cache_stash.html"
cachestash_page = "<html><head><title>Cache Stash</title></head><body><h1>Cache Stash (stored files)</h1>"

# traverse the filepaths, get filenames and paths
full_paths = []
short_names = []
for path in cache_paths:
	find_files = subprocess.Popen(['ls'], stdout = subprocess.PIPE, cwd = path)
	file_split = find_files.stdout.read()
	file_names = file_split.split()
	for file in file_names:
		full_paths.append(path + file)
		short_names.append(file)

# format into html string
def format_req_html(key, fetchcount, fetchtime, modifytime, datasize):
	temp = "<table border='1'>"
	key = key.lstrip("HTTP:")
	key = key.rstrip("^@")
	key_href = "<a href=\'" + str(key) + "\'>" + str(key) + "</a>"
	temp = temp + "<tr><td><b>key: </b></td><td>" + key_href + "</td></tr>"
	temp = temp + "<tr><td><b>fetch count: </b></td><td>" + str(fetchcount) + "</td></tr>"
	temp = temp + "<tr><td><b>last fetched: </b></td><td>" + fetchtime + "</td></tr>"
	temp = temp + "<tr><td><b>last modified: </b></td><td>" + modifytime + "</td></tr>"
	temp = temp + "<tr><td><b>data size: </b></td><td>" + str(datasize) + "</td></tr>"
	temp = temp + "</table><br/>"
	return temp
	

# check all files and get all info we can
re_cache = re.compile('_CACHE_00')
re_cache_001 = re.compile('_CACHE_001_')
re_cache_002 = re.compile('_CACHE_002_')
re_cache_003 = re.compile('_CACHE_003_')
magic_num = 65544
f_index = 0
for file in full_paths:
	if (re_cache.search(file)): # for _CACHE_00x_ files
		storagejars_page = storagejars_page + "<h2>From " + file + "</h2>"
		pos = 4096
		block = 0
		f_open = open(file, 'r')
		f_size = os.path.getsize(file)
		# get block size
		if (re_cache_001.search(file)): # for _CACHE_001_
			block = 256
		if (re_cache_002.search(file)): # for _CACHE_002_
			block = 1024
		if (re_cache_003.search(file)): # for _CACHE_003_
			block = 4096
		while (pos < f_size):
			f_open.seek(pos)
			head = f_open.read(36)
			fields = struct.unpack(">9I", head)
			if (magic_num == int(fields[0])): # test for metadata block
				location = int(fields[1])
				fetchcount = int(fields[2])
				fetchtime = time.ctime(float(fields[3]))
				modifytime = time.ctime(float(fields[4]))
				#expiretime = time.ctime(float(fields[5]))
				datasize = int(fields[6])
				reqsize = int(fields[7])
				infosize = int(fields[8])
				# get key (URL)
				f_open.seek(pos + 36)
				req_url = str(f_open.read(reqsize-1))
				# get info_string
				f_open.seek(pos + 36 + reqsize)
				info_string = str(f_open.read(infosize))
				# get html formatting in page
				temp = format_req_html(req_url, fetchcount, fetchtime, modifytime, datasize)
				storagejars_page = storagejars_page + temp 
			pos = pos + block
	else: # for obscure files
		#print file
		#print short_names[f_index]
		# trying unzipping files
		try:
			this_file = gzip.open(file, "rb").read()
		except IOError:
			this_file = open(file, "rb").read()
		# try getting a filename
		this_f_name = "None"
		if "PNG" in this_file[:20]:
			this_f_name = short_names[f_index] + ".png"
		elif "PNG-8" in this_file[:20]:
			this_f_name = short_names[f_index] + ".png"
		elif "IHDR" in this_file[:20]:
			this_f_name = short_names[f_index] + ".png"
		elif "GIF89a" in this_file[:20]:
			this_f_name = short_names[f_index] + ".gif"
		elif "GIF87a" in this_file[:20]:
			this_f_name = short_names[f_index] + ".gif"
		elif "JFIF" in this_file[:20]:
			this_f_name = short_names[f_index] + ".jpg"
		elif "html" in this_file[:20]:
			this_f_name = short_names[f_index] + ".html"
		elif "HTML" in this_file[:20]:
			this_f_name = short_names[f_index] + ".html"
		elif "<!--" in this_file[:20]:
			this_f_name = short_names[f_index] + ".html"
		else:
			pass
		# save file if we know it's type
		if this_f_name != "None":
			this_path = cache_stash + "/" + this_f_name
			os.chdir(cache_dir)
			#f_out = open(this_f_name, "w")
			#f_out.write(this_file)
			#f_out.close()
			save(this_f_name, this_file)
			file_href = "<a href=\'" + this_path + "\'>" + this_f_name + "</a><br/>"
			cachestash_page = cachestash_page + file_href
	f_index = f_index + 1
		
# create the html files for cache browsing
os.chdir(work_dir)
html_end = "</body></html>"
save(storagejars_name, storagejars_page + html_end)
save(cachestash_name, cachestash_page + html_end)

# start the webservice
print "\nRunning the Storage Jars / Cache Stash Web Service."
print "To view the cache contents, open a browser and access the following URL:"
print "  http://localhost:56565/"
os.system("python sj_webserv.py")





