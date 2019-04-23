# content.py
#
# Will MacLean
# CSPP 51060

import subprocess
import sys
import re
import codecs
import mimetypes
import gzip
import os

# grab src and dest directories from command-line arguments
if (len(sys.argv) == 3):
	dest_dir = sys.argv[1]
	src_dir = sys.argv[2]
else:
	print "Usage: python contents.py <dest_directory> <source_directory>"
	sys.exit(0)

# create destination directory
print "Making directory ", dest_dir
work_dir = os.getcwd()
try:
	os.mkdir(work_dir + "/" + dest_dir)
except:
	print "Directory exists: ", dest_dir

# a bunch of tests and decodings
def is_ascii(data):
	try:
		temp = data.decode("ascii")
		#return temp
		return "ascii"
	except UnicodeError:
		return False
def is_latin_1(data):
	try:
		temp = data.decode("latin-1")
		#return temp
		return "latin-1"
	except UnicodeError:
		return False
def is_iso_8859_1(data):
	try:
		temp = data.decode("iso-8859-1")
		#return temp
		return "iso-8859-1"
	except UnicodeError:
		return False
def is_utf_8(data):
	try:
		temp = data.decode("utf-8")
		#return temp
		return "utf-8"
	except UnicodeError:
		return False
def is_utf_16(data):
	try:
		temp = data.decode("utf-16")
		#return temp
		return "utf-16"
	except UnicodeError:
		return False
def is_utf_16_le(data):
	try:
		temp = data.decode("utf-16-le")
		#return temp
		return "utf-16-le"
	except UnicodeError:
		return False
def is_utf_16_be(data):
	try:
		temp = data.decode("utf-16-be")
		#return temp
		return "utf-16-be"
	except UnicodeError:
		return False
def is_unicode_escape(data):
	try:
		temp = data.decode("unicode-escape")
		#return temp
		return "unicode-escqpe"
	except UnicodeError:
		return False

# codec tests
def is_base64(data):
	try:
		temp = data.decode("base64")
		print "is base64"
		return temp
	except UnicodeError:
		return False
def is_hex(data):
	try:
		temp = data.decode("hex")
		print "is hex"
		return temp
	except UnicodeError:
		return False
def is_bz2(data):
	try:
		temp = data.decode("bz2")
		print "is bz2"
		return temp
	except UnicodeError:
		return False
def is_quopri(data):
	try:
		temp = data.decode("quopri")
		print "is mime"
		return temp
	except UnicodeError:
		return False
def is_string_escape(data):
	try:
		temp = data.decode("string_escape")
		print "is string_escape"
		return temp
	except UnicodeError:
		return False
def is_zlib(data):
	try:
		temp = data.decode("zlib")
		print "is zlib"
		return temp
	except UnicodeError:
		return False

# read all filenames in directory
find_files = subprocess.Popen(['ls'], stdout = subprocess.PIPE, cwd = src_dir)
data = find_files.stdout.read()
file_names = data.split()

# open all non-_CACHE_ files
re_cache = re.compile('_CACHE_')
for file in file_names:
	if (re_cache.search(file)):
		pass # skip non-cryptic names
	else:
		test = ''
		file_path = src_dir + file
		try:
			data = gzip.open(file_path, "rb").read()
			test = gzip.open(file_path, "rb").read()
		except IOError:
			data = open(file_path, "rb").read()
			test = open(file_path, "rb").read()

		# find encoding, and get decoded data
		decoded_data = None
		if(is_ascii(data)!=False):
			decoded_data = is_ascii(data)
		elif(is_latin_1(data)!=False):
			decoded_data = is_latin_1(data)
		elif(is_iso_8859_1(data)!=False):
			decoded_data = is_iso_8859_1(data)
		elif(is_utf_8(data)!=False):
			decoded_data = is_utf_8(data)
		elif(is_utf_16(data)!=False):
			decoded_data = is_utf(data)
		elif(is_utf_16_le(data)!=False):
			decoded_data = is_utf_16_le(data)
		elif(is_utf_16_be(data)!=False):
			decoded_data = is_utf_be(data)
		elif(is_unicode_escape(data)!=False):
			decoded_data = is_unicode_escape(data)
		else:
			print "We may never get here"

		# try finding the file type
		content = ''
		if "PNG" in data[:20]:
			content = "png"
		elif "PNG-8" in data[:20]:
			content = "png"
		elif "IHDR" in data[:20]:
			content = "png"
		elif "GIF89a" in data[:20]:
			content = "gif"
		elif "GIF87a" in data[:20]:
			content = "gif"
		elif "JFIF" in data[:20]:
			content = "jpg"
		elif "html" in data[:20]:
			content = "html"
		elif "HTML" in data[:20]:
			content = "html"
		elif "<!--" in data[:20]:
			content = "html"
		elif "CWS" in data[:20]:
			content = "cws"
		elif "CW" in data:
			content = "cw"
		elif "FLV" in data[:20]:
			content = "flv"
		else:
			content = "unknown"

		print file
		print decoded_data
		print content
		print "--"

		# decode the next layer, if there is one
		#decoded_data2 = None
		#if (is_base64(decoded_data)!=False):
		#	decoded_data2 = is_base64(decoded_data)
		#elif (is_hex(decoded_data)!=False):
		#	decoded_data2 = is_hex(decoded_data)
		#elif (is_bz2(decoded_data)!=False):
		#	decoded_data2 = is_bz2(decoded_data)
		#elif (is_string_escape(decoded_data)!=False):
		#	decoded_data2 = is_string_escape(decoded_data)
		#elif (is_zlib(decoded_data)!=False):
		#	decoded_data2 = is_zlib(decoded_data)
		#else:
		#	print "no third layer"
		#	decoded_data2 = decoded_data
		
		# find a file extension, and write file
		#file_out = open('/' + dest_dir + '/' + file + ext, 'w')
		os.chdir(work_dir + "/" + dest_dir)
		file_out = open(file + "." + content, "wb")
		file_out.write(data)
		file_out.close()



	







