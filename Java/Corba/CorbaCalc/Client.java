// Will MacLean
// CSPP 51024
//
// mutated from the Bank example
//
// Client.java

public class Client {

	// variables
	int val1;
	int val2;
	int answer;
	String operator;
	String input = " ";
	String[] tokens;


  public static void main(String[] args) {

    // Initialize the ORB.
    org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

    // Get the manager Id
//    byte[] managerId = "BankManager".getBytes();
	byte[] calculatorId = "CalculatorManager".getBytes();

    // Locate an account manager. Give the full POA name and the servant ID.
//    Bank.AccountManager manager = 
//	Bank.AccountManagerHelper.bind(orb, "/bank_agent_poa", managerId);
	CorbaCalc.Calculator aCalculator = 
		CorbaCalc.CalculatorHelper.bind(orb, "/CorbaCalc_agent_poa", calculatorId);

/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++OLD CODE
    // use args[0] as the account name, or a default.
    String name = args.length > 0 ? args[0] : "Jack B. Quick";

    // Request the account manager to open a named account.
    Bank.Account account = manager.open(name);

    // Get the balance of the account.
    float balance = account.balance();

    // Print out the balance.
    System.out.println
      ("The balance in " + name + "'s account is $" + balance);
*/



	while(true){
		while(!input.equalsIgnoreCase"exit")){
			System.out.println
				("Enter a math problem using the following syntax: ");
			System.out.println
				("<integer> <+,-,*,/,%> <integer>");
			System.out.print("Your math problem?>> "):
			input = ParserUtils.getKeyInput();
			tokens = ParserUtils.getTokens(input);

			// check for too many params
			if(Array.getLength(args) != 3){
				System.out.println("Incorrect number of arguments. Please reenter.");
			}else{
				// parse out the variables
				val1 = Integer.parseInt(tokens[0]);
				operator = tokens[1];
				val2 = Integer.parseInt(tokens[2]);

				// call CalcServer to get math done
				answer = aCalculator.compute(val1, val2, operator);
// answer = CorbaCalc.aCalculator.compute(val1, val2, operator);

				// print the answer
				System.out.println("The answer is: " + answer);
			}
		}
	}
  }
}
