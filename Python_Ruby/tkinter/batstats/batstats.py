# batstats.py

def new():
	stats = { 'class' : 'batstats' }
	return stats

def init(stat, ab, r, h, dbl, trpl, hr, rbi, bb, so, hbp, sf):
	#stat['ab'] = int(ab)
	#stat['r'] = int(r)
	#stat['h'] = int(h)
	#stat['dbl'] = int(dbl)
	#stat['trpl'] = int(trpl)
	#stat['hr'] = int(hr)
	#stat['rbi'] = int(rbi)
	#stat['bb'] = int(bb)
	#stat['so'] = int(so)
	#stat['hbp'] = int(hbp)
	#stat['sf'] = int(sf)
	#tb = int(totb(int(h), int(dbl), int(trpl), int(hr)))
	#stat['tb'] = tb
	#avg = float(average(h, ab))
	#stat['avg'] = avg
	#slg = float(slug(tb, ab))
	#stat['slg'] = slg
	#obp = float(onbase(ab, h, bb, hbp, sf))
	#stat['obp'] = obp
	#rc = float(runscreated(h, bb, hbp, tb, ab))
	#stat['rc'] = rc
	#ops = float(obplslg(obp, slg))
	#stat['ops'] = ops
	#ta = totavg(tb, bb, ab, h)
	#stat['ta'] = ta
	#bra = float(batrunavg(obp, slg))
	#stat['bra'] = bra
        stat['ab'] = ab
        stat['r'] = r
        stat['h'] = h
        stat['dbl'] = dbl
        stat['trpl'] = trpl
        stat['hr'] = hr
        stat['rbi'] = rbi
        stat['bb'] = bb
        stat['so'] = so
        stat['hbp'] = hbp
        stat['sf'] = sf
        tb = int(totb(int(h), int(dbl), int(trpl), int(hr)))
        stat['tb'] = tb
        avg = float(average(h, ab))
        stat['avg'] = avg
        slg = float(slug(tb, ab))
        stat['slg'] = slg
        obp = float(onbase(ab, h, bb, hbp, sf))
        stat['obp'] = obp
        rc = float(runscreated(h, bb, hbp, tb, ab))
        stat['rc'] = rc
        ops = float(obplslg(obp, slg))
        stat['ops'] = ops
        ta = totavg(tb, bb, ab, h)
        stat['ta'] = ta
        bra = float(batrunavg(obp, slg))
        stat['bra'] = bra



def average(h, ab):
	return float(h) / float(ab)

def totb(h, dbl, trpl, hr):
	return (h - (dbl + trpl + hr)) + (2*dbl) + (3*trpl) + (4*hr)

def slug(tb, ab):
	return float(tb) / float(ab)

def onbase(ab, h, bb, hbp, sf):
	return (float((h + bb + hbp)) / float((ab + bb + hbp + sf)))

def runscreated(h, bb, hbp, tb, ab):
	return float(((h+bb) * int(tb))) / float(ab+bb)

def obplslg(obp, slg):
	return obp + slg

def totavg(tb, bb, ab, h):
	return float((float(tb)+float(bb))) / float((float(ab)-float(h)))

def batrunavg(obp, slg):
	return obp * slg

#import batstats
#fthomas2000 = batstats.new()
#batstats.init(fthomas2000,582,115,191,44,0,43,143,112,94,5,8)
#print fthomas2000

def gettb():
        return str(stat['tb'])

def getavg():
        return '%.2f' % (stat['avg'])

def getslg():
        return '%.2f' % (stat['slg'])

def getobp():
        return '%.3f' % (stat['obp'])

def getrc():
        return str(stat['rc'])

def getops():
        return '%.3' % (stat['ops'])

def getta():
        return str(stat['ta'])

def getbra():
        return str(stat['bra'])

 
