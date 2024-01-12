import java.util.Random;
import java.util.Scanner;

public class bank {
    public static void main(String[] args) {
        Transaction t = new Transaction();
        System.out.println("WELCOME TO Online Banking ");
        System.out.println("=====================");
        t.info();
        t.setaccountnumber(1002124563);
        t.setaccounttitle("Bilal Ahmed");
        t.setbalancer(3000);

        System.out.println("Account Title : " + t.getaccounttitle());
        System.out.println("Account Number : " + t.getaccountnumber());
        System.out.println("Account Blance : " + t.getbalance());
        System.out.println("=====================");

        try {
            t.deposit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class Account {
    Scanner sc=new Scanner(System.in);
    long accountnumber;
    String accounttitle;
    float balance;

    public void setaccountnumber(long myaccountnumber) {
        accountnumber = myaccountnumber;
    }

    public long getaccountnumber() {
        return accountnumber;
    }

    public void setaccounttitle(String myaccounttitle) {
        accounttitle = myaccounttitle;
    }

    public String getaccounttitle() {
        return accounttitle;
    }
    
    public void setbalancer(float mybalance) {
        balance = mybalance;
    }

    public float getbalance() {
        return balance;
    }
public void info(){
    System.out.println("Press 1 to login : ");
    System.out.println("Press 2 to Signup : ");
    int input1=sc.nextInt();
    if(input1==1){
     System.out.println("Enter your Username : ");
     String input2=sc.next();
     System.out.println("Enter password :");
     String input3=sc.next();
    }
    if(input1==2){
     System.out.println("Enter your First name : ");
     String input4=sc.next();
     System.out.println("Enter your Last name : ");
     String input5=sc.next();
     System.out.println("Enter Email :");
     String input6=sc.next();
     System.out.println("Enter your Phone aumber : ");
     String input7=sc.next();
    }
        
}
}


class Transaction extends Account {

    Scanner sc = new Scanner(System.in);
    Random r = new Random();
    int deposit1;
    int deposit2;
    float totalbalance;
    int num3;

    public void deposit() throws insufficientbalanceexception {
        
        System.out.println("Press 1 to deposit");
        System.out.println("Press 2 to withdraw cash");
        int num1 = sc.nextInt();
        if(num1!=1&&num1!=2){
          
           System.out.println("invalid input");      
        }
        if(num1!=1&&num1!=2){
            System.exit(num1);       
         }
        
        if (balance < 500) {
            throw new insufficientbalanceexception();
        }
        if (balance < 500) {
            System.exit(num1);
        }
        
         System.out.println("Here's your OTP: ");

        int otp=0;

        for (int i = 1; i <= 6; i++) {
            otp = otp * 10 + r.nextInt(9);
        }
        
        System.out.println(otp);
        
        System.out.println("Enter your 6-digit OTP: ");
        int num = sc.nextInt();
        
        
        if (num==otp && num1 == 1 && balance >= 500) {
            System.out.println("OTP Verification Successful!");
            System.out.print("Enter amount for deposit: ");
            deposit1 = sc.nextInt();
            totalbalance = balance -= deposit1;
            System.out.println("Successfully deposit");
        }
        
        if (num==otp && num1 == 2 && balance >=500) {
            System.out.println("OTP Verification Successful!");
            System.out.print("Enter amount to withdraw cash : ");
            deposit2 = sc.nextInt();
            totalbalance = balance -= deposit2;
            System.out.println("Successfully withdraw");
        }
        
        if (num!=otp) {
            System.out.println("Incorrect OTP. Please try again.");
          for(int i=1;i<=2;i++){
                System.out.println("Enter your 6-digit OTP: ");
             num3 = sc.nextInt();
             System.out.println("Incorrect OTP. Please try again.");
          }
          System.out.println("OTP limit reached....Try again in 24 hours");
          System.exit(num3);
        }

        System.out.println("=============================");
        System.out.println("press 3 for balance inquiry and 4 to exit: ");
        int num2 = sc.nextInt();
        if (num2 == 3) {
            System.out.println("Total balance after Transactions : " + totalbalance);
        }
        else if(num2== 4) {
            System.out.println("Thanks for using ATM ");
        }
        else{
            System.out.println("invalid choice");
        }

    }}

class insufficientbalanceexception extends Exception {
    public String getMessage() {
        return " insufficient balance to deposit";
    }
}
