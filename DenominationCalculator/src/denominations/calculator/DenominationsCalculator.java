package denominations.calculator;
import java.util.Arrays;
public class DenominationsCalculator {
	
	public static Integer[] denominations;
	public int paymentAmount;	
	
	//constructor for denominations list and payment amount
	
	public DenominationsCalculator (Integer[] denominations, int paymentAmount) {
		
		DenominationsCalculator.denominations = denominations;
		this.paymentAmount = paymentAmount;
		
	}
 
	    static void bubbleSort() {  
	        int n = denominations.length;  
	        int temp = 0;  
	         for(int i=0; i < n; i++){  
	                 for(int j=1; j < (n-i); j++){  
	                          if(denominations[j-1] < denominations[j]){  
	                                 //swap elements  
	                                 temp = denominations[j-1];  
	                                 denominations[j-1] = denominations[j];  
	                                 denominations[j] = temp;  
	                         }  
	                          
	                 }  
	         }  
	  
	    }  

	
	//core method
	
	public void calculate() {
		
		bubbleSort();
		
		int denominationIndex = 0;
		
		int workingPaymentAmount = paymentAmount;
		
		//total
//		int total = 0;
		
		while (denominationIndex < denominations.length) {
			
			int denomination = denominations[denominationIndex];
			int noOfDenominations = workingPaymentAmount / denomination;
			
			//balance amount
			int balanceAmount = workingPaymentAmount % denomination;
			
			//if denomination can be used or not
			if(noOfDenominations != 0) {
				
				
				//print the denomination value and its count
				System.out.printf("Denomination value : %d , Count : %d \r\n", 
						denomination, noOfDenominations);
				
//				System.out.println("Previous total " +total);
				//update total with value from this iteration
				
//				total = total + (denomination * noOfDenominations);
				
//				System.out.println("Current total " + total);
				
			}
			
			//set pending balance for next iteration
			workingPaymentAmount = balanceAmount;
			
			//when no more balance remaining, break from loop
			if(workingPaymentAmount == 0) {
				break;
			}
			
			denominationIndex++;
		}
		
		if(workingPaymentAmount != 0) {
			
			System.out.println("Unable to provide the exact denominations");
			System.out.println("Remaining amount : " + workingPaymentAmount);
		} 
		
	}
 
}

