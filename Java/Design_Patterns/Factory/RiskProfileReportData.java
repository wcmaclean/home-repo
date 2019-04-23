class RiskProfileReportData extends BasicReportData{

/**
RiskProfileReportData defines the information basic to a 
Rick Profile report. It extends BasicReportData. It contains
methods for accessing, printing, and stringing data.
*/

	private String bucket;
	private double delta1;
	private double delta2;
	private double delta3;
	private double delta4;


	// constructor
	RiskProfileReportData(	Long tradeID,
				Double delta1,
				Double delta2,
				Double delta3,
				Double delta4,
				String currency
	){
		this.setTradeID(tradeID);
		this.delta1 = delta1;
		this.delta2 = delta2;
		this.delta3 = delta3;
		this.delta4 = delta4;
		this.setCurrency(currency);
		this.setNumOfLinesPerTrade(4);
	}	

	// accessors
	public String getBucket(){
		return this.bucket;
	}
	public Double getDelta1(){
		return this.delta1;
	}
	public Double getDelta2(){
		return this.delta2;
	}
	public Double getDelta3(){
		return this.delta3;
	}
	public Double getDelta4(){
		return this.delta4;
	}


	// methods
	public void printReport(){
		System.out.println(	this.getTradeID() + " " +
					this.delta1 + " " +
					this.delta2 + " " +
					this.delta3 + " " +
					this.delta4 + " " +
					this.getCurrency()
		);
	}

	public String toString(){
		return (this.getTradeID() + "\t" +
			this.delta1 + "\t" +
			this.delta2 + "\t" +
			this.delta3 + "\t" +
			this.delta4 + "\t" +
			this.getCurrency()  + "\n"
		);
	}

}