abstract class BasicReportData{

/**
BasicReportData is an abstract class containing only
those elements universal to report formats. It is
extended by instantiable report data objects.
*/

	private long tradeID;
	private String currency;
	private int numOfLinesPerTrade;


// accessors
	public long getTradeID(){
		return this.tradeID;
	}//close getTradeID()

	public String getCurrency(){
		return this.currency;
	}
	public int getNumOfLinesPerTrade(){
		return this.numOfLinesPerTrade;
	}

	

//mutator
	public void setTradeID(long tradeID){
		this.tradeID = tradeID;
	}//close setTradeID(long TradeID)

	public void setCurrency(String currency){
		this.currency = currency;
	}// close setCurrency(String currency)
	public void setNumOfLinesPerTrade(int numOfLinesPerTrade){
		this.numOfLinesPerTrade = numOfLinesPerTrade;
	}


}