# sj_webserv.py
#
# Will MacLean
# CSPP 51060
#
# Borrowing Beazley's basic web server for this.

from BaseHTTPServer import HTTPServer
from CGIHTTPServer import CGIHTTPRequestHandler

server = HTTPServer(("", 56565), CGIHTTPRequestHandler)
server.serve_forever()

