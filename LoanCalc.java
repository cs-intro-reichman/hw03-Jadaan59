/**
* Computes the periodical payment necessary to re-pay a given loan.
*/
public class LoanCalc {
	
	static double epsilon = 0.001;  // The computation tolerance (estimation error)
	static int iterationCounter = 0;
	static int iterationCounter1 = 0;// Monitors the efficiency of the calculation
	
    /** 
     * Gets the loan data and computes the periodical payment.
     * Expects to get three command-line arguments: sum of the loan (double),
     * interest rate (double, as a percentage), and number of payments (int).  
     */
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = 100000;
		double rate = 5;
		int n = 10;
		System.out.println("Loan sum = " + loan + ", interest rate = " + rate + "%, periods = " + n);
		
		// Computes the periodical payment using brute force search
		System.out.print("Periodical payment, using brute force: ");
		System.out.printf("%.2f", bruteForceSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search

		System.out.print("Periodical payment, using bi-section search: ");
		System.out.printf("%.2f", bisectionSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter1);


	}
	
	/**
	* Uses a sequential search method  ("brute force") to compute an approximation
	* of the periodical payment that will bring the ending balance of a loan close to 0.
	* Given: the sum of the loan, the periodical interest rate (as a percentage),
	* the number of periods (n), and epsilon, a tolerance level.
	*/
	// Side effect: modifies the class variable iterationCounter.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {  
    	double payment = (loan * (rate /100));
		double increment = 0.0001;
		while (endBalance(loan, rate, n, payment) >= epsilon){
			payment += increment;
			iterationCounter++;
		}
    	return payment;
    }
    
    /**
	* Uses bisection search to compute an approximation of the periodical payment 
	* that will bring the ending balance of a loan close to 0.
	* Given: the sum of theloan, the periodical interest rate (as a percentage),
	* the number of periods (n), and epsilon, a tolerance level.
	*/
	// Side effect: modifies the class variable iterationCounter.

	public static double bisectionSolver(double loan, double rate, int n, double epsilon) {
		double L = 1, H = (loan);
		double payment = (L + H) / 2 ;
		while (Math.abs(endBalance(loan, rate, n, payment)) >= epsilon){
			if (endBalance(loan, rate, n, payment) < epsilon){
				H = payment;
			}else {
				L = payment;
			}
			payment = (L + H) / 2 ;
			iterationCounter1++;
		}
    	return payment;
    }


	/**
	* Computes the ending balance of a loan, given the sum of the loan, the periodical
	* interest rate (as a percentage), the number of periods (n), and the periodical payment.
	*/
	private static double endBalance(double loan, double rate, int n, double payment) {
       double updatedloan = loan ;
        for (int i = 0; i < n; i++) {
			updatedloan = ((updatedloan - payment) * (1 + (rate / 100)));
		}
		return updatedloan;
	}
}