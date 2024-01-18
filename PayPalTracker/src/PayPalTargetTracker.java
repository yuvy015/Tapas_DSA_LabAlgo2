import java.util.Scanner;
public class PayPalTargetTracker {
	Integer[] trans;
	Scanner input;
	public PayPalTargetTracker()	{
		
		input = new Scanner(System.in);
		
	}
	public void collectTransactionList() {
		System.out.println("Transactionlist: ");
		System.out.println("Enter the number of transactions: ");
		int numberOfTransactions = input.nextInt();
		trans = new Integer[numberOfTransactions];
		for(int i=0 ;i < numberOfTransactions ;i++)
		{
			System.out.printf("Enter the transaction value:%d / %d", (i+1), numberOfTransactions);   
			trans[i] = input.nextInt();
			
		}
		
		
	}
	public void determine() 
	{
		collectTransactionList();
		
		targetCheck();
		}
	public void targetCheck() 
	{
		System.out.println("Enter the daily target: ");
		int dailyTarget = input.nextInt();
		int currentSum=0;
		int counter=0;
		boolean targetStatus = false;
		for(int j=0; j < trans.length ; j++) 
		{
			currentSum = currentSum+trans[j];
			counter++;
	if (currentSum >= dailyTarget)
	{
		targetStatus = true;
	    break;
	}  
		}
		if(targetStatus) {
			
			System.out.printf("Daily target of %d achieved after %d transactions",
					dailyTarget,counter);
			System.out.println();
			
		} else {
			
			System.out.printf("Daily target of %d not achieved", targetStatus);
			System.out.println();
		}
		
	}
}

