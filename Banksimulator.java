import java.util.Scanner;
import java.io.*;
public class Banksimulator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Bank Simulator");
System.out.print("Enter Account Number: ");
int accountNumber = sc.nextInt();
double balance = 0;
sc.nextLine();
System.out.print("Enter account Holder Name: ");
String accountName = sc.nextLine();
System.out.println("Account Created Successfully!");
System.out.println("Account Number: " + accountNumber);
System.out.println("Account Holder: " + accountName);

System.out.println("\n===== BANK MENU =====");
System.out.println("1. Deposit Money");
System.out.println("2. Withdraw Money");
System.out.println("3. Check Balance");
System.out.println("4. Transaction History");
System.out.println("5. Exit");
while(true) {
System.out.print("Enter Choice: ");
int choice = sc.nextInt();
switch(choice) {
case 1:
	System.out.print("Enter Depost Amount: ");
	double deposit = sc.nextDouble();
	balance = balance + deposit;
	try {
	    FileWriter fw = new FileWriter("transactions.txt", true);
	    fw.write("Deposit: " + deposit + "\n");
	    fw.close();
	}
	catch(Exception e) {
	    System.out.println("File Error");
	}
	System.out.println("Money Deposited Successfully!");
	System.out.println("Current Balance: " + balance);
	break;
case 2:
	System.out.print("Enter Withdraw amount: ");
	double withdraw = sc.nextDouble();
	if(withdraw > balance) { 
		System.out.println("Insufficient Balance!");
	} else {
		balance = balance - withdraw;
		try {
		    FileWriter fw = new FileWriter("transactions.txt", true);
		    fw.write("Withdraw: " + withdraw + "\n");
		    fw.close();
		}
		catch(Exception e) {
		    System.out.println("File Error");
		}
		System.out.println("Withdrawal Successful!");
		System.out.println("Current Balance: " + balance);
	}
	break;
case 3:
	System.out.println("Current Balance: " + balance);
	break;
case 4:

    try {

        BufferedReader br =
            new BufferedReader(
                new FileReader("transactions.txt"));

        String line;

        System.out.println("\n===== TRANSACTION HISTORY =====");

        while((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();

    }
    catch(Exception e) {

        System.out.println("No Transaction Found!");
    }

    break;
case 5:
	System.out.println("Thank You!");
 System.exit(0);
	break;
	default:
	    System.out.println("Invalid Choice!");
} 
}
	}
	
}
