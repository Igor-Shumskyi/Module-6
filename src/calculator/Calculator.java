package calculator;
import java.math.BigDecimal;
import java.util.Scanner;


public class Calculator {
BigDecimal operatorOne;

BigDecimal operatorTwo;

Integer operationType;

public final static Integer ADD = 0;
public final static Integer SUB = 1;
public final static Integer DIV = 2;
public final static Integer MULT = 3;

boolean parseString(String s) {
	String[] operators = s.split(" ");
	try {
		operatorOne = new BigDecimal(operators[0]);
	
		operatorTwo = new BigDecimal(operators[2]);
	
		operationType = determineOperationType(operators[1]);
	
		return true;
	
		} catch (NumberFormatException e) {
		System.err.println("\"ERROR: Invalid operator.\"");
	
		return false;
	
		} catch (ArrayIndexOutOfBoundsException e) {
		System.err.println("\"ERROR: Invalid number of arguments : \"" + operators.length);
	
		return false;
	
		
		}

}

private Integer determineOperationType(String s) throws NumberFormatException {
if (s.equals("+")) return ADD;

else if (s.equals("-")) return SUB;

else if (s.equals("/")) return DIV;

else if (s.equals("*")) return MULT;

else throw new NumberFormatException();

}

BigDecimal performCalculation() {
try {
if (operationType == ADD) {
return operatorOne.add(operatorTwo);

} else if (operationType == SUB) {
return operatorOne.subtract(operatorTwo);

} else if (operationType == MULT) {
return operatorOne.multiply(operatorTwo);

} else if (operationType == DIV) {
return operatorOne.divide(operatorTwo);

} else return new BigDecimal(0);

} catch (ArithmeticException e) {
System.err.println("\"Arithmetic Exception occured. Most likely this is a division by zero.\"");

return new BigDecimal(0);

}
}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator c = new Calculator();
		
		System.out.println("\"Enter a string to represent the calculation being performed. Place a space between each token. For example: \\\"2 + 2\\\" and not \\\"2+2\\\"\"");
		
		Scanner scan = new Scanner(System.in);
		
		String s = scan.nextLine();
	

		boolean noError = c.parseString(s);
	
		if (noError) {
		BigDecimal bd = c.performCalculation();
	
		System.out.println(bd.toPlainString());
	
		}
		}




	}


