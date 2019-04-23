class PNLReportData extends BasicReportData{

/**
PNLReportData extends the abstract class BasicReportData.
*/

	private String Product;
	private double MTMBegin;
	private double MTMEnd;

	// constructor
	PNLReportData(	Long tradeID,
			String Product,
			Double MTMBegin,
			Double MTMEnd,
			String currency
	){
		this.setTradeID(tradeID);
		this.Product = Product;
		this.MTMBegin = MTMBegin;
		this.MTMEnd = MTMEnd;
		this.setCurrency(currency);
		this.setNumOfLinesPerTrade(1);
	}			 

	// accessors
	public String getProduct(){
		return this.Product;
	}
	public Double getMTMBegin(){
		return this.MTMBegin;
	}
	public Double getMTMEnd(){
		return this.MTMEnd;
	}


	public void printReport(){
		System.out.println(	this.getTradeID() + " " +
					this.Product + " " +
					this.MTMBegin + " " +
					this.MTMEnd + " " +
					this.getCurrency()
		);
	}

	public String toString(){
		return (this.getTradeID() + "\t" +
			this.Product + "\t" +
			this.MTMBegin + "\t" +
			this.MTMEnd + "\t" +
			this.getCurrency() + "\n"
		);
	}

}