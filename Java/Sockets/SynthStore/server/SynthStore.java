// Will MacLean
// CSPP 51037
// Homework 1
// SynthStore class

import java.io.*;
import java.net.*;

public class SynthStore{

	// stuff for connection - this moved to SynthStoreServer class
//	private int portNum;
//	private ServerSocket servSocket;
//	private Socket	clientSocket;
//	private InputStream streamIn;
//	private OutputStream streamOut;

	// stuff for products	
	private Product[] synthProducts = new Product[5];
	private String prodName;
	private int totalProdType;


	// constructor
	SynthStore(String nameIn, int prodTypeIn){
		prodName = nameIn;
		totalProdType = prodTypeIn;

		// stocking the store - 	NAME		PRICE		STOCK		DESCRIPTION
		synthProducts[0] = new Product("Minimoog", 	1500,		2, 		"Monophonic" );
		synthProducts[1] = new Product("OB8",	 	1200,		3, 		"Polyphonic" );
		synthProducts[2] = new Product("Micromoog", 	500,		5, 		"Monophonic" );
		synthProducts[3] = new Product("Prophet-5", 	1500,		1, 		"Polyphonic" );
		synthProducts[4] = new Product("MonoPoly", 	500,		3, 		"Poly/Mono" );

	} // end constructor




	// constructor - redone above to remove port
//	SynthStore(int port){
//		portNum = port;
//
		// stocking the store - 	NAME		PRICE		STOCK		DESCRIPTION
//		synthProducts[0] = new Product("Minimoog", 	1500,		2, 		"Monophonic" );
//		synthProducts[1] = new Product("OB8",	 	1200,		3, 		"Polyphonic" );
//		synthProducts[2] = new Product("Micromoog", 	500,		5, 		"Monophonic" );
//		synthProducts[3] = new Product("Prophet-5", 	1500,		1, 		"Polyphonic" );
//		synthProducts[4] = new Product("MonoPoly", 	500,		3, 		"Poly/Mono" );
//
//	} // end constructor


/* moved this to SynthStoreServer
	public static void main(String[] args){
		SynthStore mySynthStore = new SynthStore(1492);
		
		try{
			mySynthStore.letsDoThis();
		}catch(Exception e){
			System.out.println("Connection failed: " + e);			
		}

// Couldn't figure out how to get it to work this way...
//		try{
//			mySynthStore.servSocket = new ServerSocket(mySynthStore.getPort());
//			System.out.println("SynthStore is listening on port" + mySynthStore.getPort());
//		}catch(Exception e){
//			System.out.println("Error connecting to " + mySynthStore.servSocket);			
//		}

	
	} // end main
*/


// moved to SynthStoreServer
//	public void letsDoThis() throws Exception{
//		servSocket = new ServerSocket(portNum);
//		System.out.println("SynthStore is listening on port #" + portNum);
//		
//		while(true){
//			Socket clientSocket = servSocket.accept();
//			new SynthClientThread(clientSocket, this).start();
//		}
//
//	}// end letsDoThis

	public String showSynths(){
		
		return "duh";
	} // end showSynths

	public int buySynth(String prodName){
		
		return 0;
	} // end buySynth


//	public String[] displaySynths(){
//		
//	}

//	public int getPort(){
//		return portNum;
//	}

	

} // end SynthStore



class Product{

	// attributes
	String prodName;
	float prodPrice;
	int inStock;
	String prodDesc;

	// constructor
	Product(String name, float price, int stock, String desc){
		prodName = name;
		prodPrice = price;
		inStock = stock;
		prodDesc = desc;
	}

	// accessors
	public void setProdName(String name){
		prodName = name;
	}

	public String getProdName(){
		return prodName;
	}

	public void setProdPrice(float price){
		prodPrice = price;
	}

	public float getProdPrice(){
		return prodPrice;
	}

	public void setInStock(int stock){
		inStock = stock;
	}

	public int getInStock(){
		return inStock;
	}

	public void setProdDesc(String desc){
		prodDesc = desc;
	}

	public String getProdDesc(){
		return prodDesc;
	}

	public String makeStringOfSynths(){
		return	"Product Name: " + prodName +
			"Price: " + prodPrice +
			"In Stock: " + inStock + 
			"Description: " + prodDesc;
	}
} // end Product

/* moved this to SynthStoreServer
class SynthClientThread extends Thread{
	private InputStream streamIn;
	private OutputStream streamOut;
	private Socket clientSocket;
	private SynthStore mySynthStore;

	SynthClientThread(Socket clientSockIn, SynthStore synthStoreIn){
		mySynthStore = synthStoreIn;
		clientSocket = clientSockIn;
		try{
			streamIn = clientSocket.getInputStream();
			streamOut = clientSocket.getOutputStream();
		}catch(Exception e){
			System.out.println("Error connecting: " + e);
		}
	} // end constructor

	public void run(){ 
		String stuffIn, stuffOut;
		try{
			BufferedReader thingsIn = new BufferedReader (new InputStreamReader(streamIn));
			PrintWriter printOut = new PrintWriter(streamOut);
			while(true){
				stuffIn = thingsIn.readLine();
				String[] tokens = ParserUtils.getTokens(stuffIn);
				String doingSomething = tokens[0];

				if (doingSomething.equals("show")){
					stuffOut = mySynthStore.showSynths();
				}
				else if (doingSomething.equals("buy")){
					String arg = tokens[1];
					int tmp = mySynthStore.buySynth(arg);
					stuffOut = new Integer(tmp).toString();
				}
				else{
					stuffOut = "can't do that";
				}
				printOut.println(stuffOut);
				printOut.flush();
				if(stuffIn.equalsIgnoreCase("end")) break;
			}
			System.out.println("killing client softly with this song");
			clientSocket.close();
		}catch (Exception e){
			System.out.println(e);
		}

	} // end run

} // end SynthClientThread
*/


