// Will MacLean
// BatStats.java

public class BatStats{

	////////////////////
	// class variables
	////////////////////
	int ab; 		// at bats
	int r;			// runs
	int h;			// hits
	int dbl;		// doubles
	int trpl;		// triples
	int hr;			// homeruns
	int rbi;		// runs batted in
	int bb;			// base on balls
	int so;			// strikeouts
	int hbp;		// hit by pitch
	int sf;			// sacrifice flies
	int totb;		// total bases
	float avg;		// batting average
	float slg;		// slugging percentage
	float obp;		// on-base percentage
	float rc;		// runs created
	float ops;		// on-base plus slugging
	float ta;		// total average
	float bra;		// batting run average

	//////////////////
	// constructors
	//////////////////
	BatStats(int ab, int r, int h, int dbl, int trpl, int hr, 
			int rbi, int bb, int so, int hbp, int sf){

		// init variables
		this.ab = ab;
		this.r = r;
		this.h = h;
		this.dbl = dbl;
		this.trpl = trpl;
		this.hr = hr;
		this.rbi = rbi;
		this.bb = bb;
		this.so = so;
		this.hbp = hbp;
		this.sf = sf;
		this.avg = calcAvg(h, ab);
		this.totb = calcTotalBases(h, dbl, trpl, hr);
		this.slg = calcSlg(this.totb, ab);
		this.obp = calcOBP(ab, h, bb, this.totb, sf);
		this.rc = calcRC(h, bb, hbp, this.totb, ab);
		this.ops = calcOPS(this.obp, this.slg);
		this.ta = calcTA(this.totb, bb, ab, h);
		this.bra = calcBRA(this.obp, this.slg); 
	}

	//////////////////
	// calculations
	/////////////////

	// batting average
	public float calcAvg(int h, int ab){
		float f_h = (float)h;
		float f_ab = (float)ab;
		return f_h/f_ab;
	}

	// total bases
        public int calcTotalBases(int h, int dbl, int trpl, int hr){
                int sngl = (h - (dbl + trpl + hr));
                return ((1*sngl) + (2*dbl) + (3*trpl) + (4*hr));
        }

	// slugging %
	public float calcSlg(int tb, int ab){
		return ((float)tb / (float)ab); 
	}

	// on base percentage
	public float calcOBP(int ab, int h, int bb, int tb, int sf){
		return ((float)(h+bb+hbp) / (float)(ab+bb+hbp+sf));
	}

	// runs created
	public float calcRC(int h, int bb, int hbp, int tb, int ab){
		return ((float)(tb+bb)) / ((float)(ab-h));
	}

	// on-base plus slugging
	public float calcOPS(float obp, float slg){
		return obp + slg;
	}

	// total average
	public float calcTA(int tb, int bb, int ab, int h){
		return ((float)tb+(float)bb) / ((float)ab - (float)h);
	}

	// batting runs average
	public float calcBRA(float obp, float slg){
		return obp * slg;
	}

        ////////////////////
        // accessors
        ////////////////////
        public int getAB(){ return this.ab; } 		// at bats
        public int getRuns(){ return this.r; }		// runs
        public int getHits(){ return this.h; }		// hits
        public int getDbl(){ return this.dbl; }		// doubles
        public int getTrpl(){ return this.trpl; }	// triples
        public int getHr(){ return this.hr; }		// homeruns
        public int getRBI(){ return this.rbi; }		// runs batted in
        public int getBB(){ return this.bb; }		// base on balls
        public int getSO(){ return this.so; }		// strikeouts
        public int getHBP(){ return this.hbp; }		// hit by pitch
        public int getSF(){ return this.sf; }		// sacrifice flies
        public int getTB(){ return this.totb; }		// total bases
        public float getAVG(){ return this.avg; }	// batting average
        public float getSLG(){ return this.slg; }	// slugging %
        public float getOBP(){ return this.obp; }	// on-base percentage
        public float getRC(){ return this.rc; }		// runs created
        public float getOPS(){ return this.ops; }	// on-base plus slg
        public float getTA(){ return this.ta; }		// total average
        public float getBRA(){ return this.bra; }	// batting run avg

	////////////////////
	// output
	///////////////////
	public void printStats(){
		System.out.println("At bats: " + getAB());
		System.out.println("Runs: " + getRuns());
		System.out.println("Hits: " + getHits());
		System.out.println("Doubles: " + getDbl());
		System.out.println("Triples: " + getTrpl());
		System.out.println("Homeruns: " + getHr());
		System.out.println("RBI: " + getRBI());
		System.out.println("Walks: " + getBB());
		System.out.println("Strikeouts: " + getSO());
		System.out.println("Hit By Pitch: " + getHBP());
		System.out.println("Sacrifice Flies: " + getSF());
		System.out.println("Total Bases: " + getTB());
		System.out.println("Battine Average: " + getAVG());
		System.out.println("Slugging %: " + getSLG());
		System.out.println("On-base %: " + getOBP());
		System.out.println("Runs Created: " + getRC());
		System.out.println("On-base Plus Slugging: " + getOPS());
		System.out.println("Total Average: " + getTA());
		System.out.println("Batting Runs Avg: " + getBRA());
	}

	//////////////
	// main
	//////////////
	public static void main(String[] args){
	        BatStats fThomas2000 = new 
			BatStats(582, 115, 191, 44, 0, 43, 143, 
					112, 94, 5, 13);
		fThomas2000.printStats();	
	}

}


