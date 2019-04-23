# surf_spy_client.py
#
# Will MacLean
# CSPP 51060
# Final Project
#

import socket
import sys

# variables, for ease of editing
host = 'localhost'
port = 56767
backlog = 5
size = 16384

# grab hostname from command-line input
if (len(sys.argv) == 2):
        host = sys.argv[1]
else:
        pass

# create socket
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
s.connect((host, port))
while True:
	data = s.recv(size)
	print "Surfing: ", data
s.close()



