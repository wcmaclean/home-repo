# testmod.py
#
# Will MacLean
# CSPP 51060
#
# a module for a couple test functions

def isIntReturn(str):
	try: return int(str) or True
	except (ValueError, TypeError), e: return False

def isFloatReturn(str):
	try: return float(str) or True
	except (ValueError, TypeError), e: return False



