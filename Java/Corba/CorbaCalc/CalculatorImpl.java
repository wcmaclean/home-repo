// Will MacLean
// CSPP 51024
// 
// CalculatorImpl.java

public class Calculator extends CorbaCalc.CalculatorPOA {
    
	public int compute(int op1, int op2, String operation){
		
		int answer = 0;

		// check operator, and do math accordingly
		if(operator=='+'){
			answer = op1 + op2;
		}else if(operator=='-'){
			answer = op1 - op2;
		}else if(operator=='*'){
			answer = op1 * op2;
		}else if(operator=='/'){
			answer = op1 / op2;
		}else  if(operator=='%'){
			answer = op1 % op2;
		}else{ 
			// if the operator didn't show, report error
			System.out.println("Error: No such operator: " + operator);
		}
	
		return answer;				
	}
}