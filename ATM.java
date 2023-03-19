import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.SQLOutput;
import java.util.*;
class accountofbank{
    static  void registers(){
        Scanner sc=new Scanner(System.in);
        System.out.println("---------------");
        System.out.println("your  name  :");
        ATM.name=sc.nextLine();
        System.out.println("Enter username :");
        String username=sc.nextLine();
        System.out.println("register your password :");
        String password=sc.nextLine();
        System.out.println("press your Account number :");
        ATM.accnumber=sc.nextLine();
        System.out.println("SUCCESSFULLY REGISTERED!");
        System.out.println("---------------");
        ATM.promptDetails();
        while(true){
            display(ATM.name);
            int choices=sc.nextInt();
            if(choices==1){
                login(username,password);
                break;
            }
            else {
                if(choices==2){
                    System.exit(0);
                }
                else{
                    System.out.println("value is invalid ! Press again!");
                }
            }
        }
    }
    static void display(String name){}
    static void login(String user,String pass){}
}
class transactions{
    static void withdraw(){
        Scanner sc=new Scanner(System.in);
        System.out.println("----------------");
        System.out.println("Enter amount to withdraw :");
        int wcash=sc.nextInt();
        if(wcash<=ATM.balance){
            ATM.balance=ATM.balance-wcash;
            ATM.history.add(Integer.toString(wcash));
            ATM.history.add("Withdraw");
            System.out.println("Amount Rs"+wcash+"/-withdraw successfully");
            System.out.println("---------------------------");
        }
        else{
            System.out.println("insufficient balance to withdraw the cash");
            System.out.println("---------------------------");
        }
        ATM.promptDetails();
    }
    static void deposit(){
        Scanner sc=new Scanner(System.in);
        System.out.println("----------------");
        System.out.print("Enter amount to deposit :");
        int dcash=sc.nextInt();
        ATM.updatebalance(dcash);
        ATM.history.add(Integer.toString(dcash));
        ATM.history.add("Deposit");
        System.out.println("Amount Rs."+dcash+"/- deposit successful!");
        System.out.println("---------------------------");
        ATM.promptDetails();
    }
    static void transfer(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the receiving body:");
        String s=sc.nextLine();
        System.out.println("receiving body account number");
        int num=sc.nextInt();
        System.out.println("Transferred amount is:");
        int tcash=sc.nextInt();
        if(tcash<=ATM.balance){
            ATM.balance=ATM.balance-tcash;
            ATM.history.add(Integer.toString(tcash));
            ATM.history.add("transferred");
            System.out.println("cash rupees."+tcash+"/-  successfully it got transferred");
            System.out.println("---------------------------");
        }
        else{
            System.out.println("Balance is insufficient...so no transferring");
            System.out.println("---------------------------");
        }
    }
}
class checking{
    static void checkbalance(){
        System.out.println("------------------");
        System.out.println(" bank account available balance:");
        ATM.showbalance();
        System.out.println("---------------------------");
        ATM.promptDetails();
    }
}
class his{
    static void historyOfTransaction(){
            System.out.println("---------------------");
            System.out.println("Transaction History :");
            int p=0;
            if(ATM.balance>0){
            for(int i=0;i<(ATM.history.size()/2);i++)
            {
                for(int j=0;j<2;j++)
                {
                    System.out.print(ATM.history.get(p)+" ");
                    p++;
                }
                System.out.println("---------------------");
            }
            }
            else {
                System.out.println("your account is empty");
            }
            ATM.promptDetails();
    }
}


public class ATM{
    public static String name;
    public static int balance=0;
    public static String accnumber;
    public static ArrayList<String> history=new ArrayList<String>();

    static void updatebalance(int dcash){
        balance=balance+dcash;
    }
    static void showbalance(){
        System.out.println(balance);
    }
    public static void homepage(){
        System.out.println("\033[H\033[2J");
        Scanner sc=new Scanner(System.in);
        System.out.println("WELCOME TO ATM INTERFACE");
        System.out.println("--------------------------");
        System.out.println("select option :");
        System.out.println("1. Register");
        System.out.println("2. Exit");
        System.out.println("Enter choice");
        int choice =sc.nextInt();
        if (choice==1){
            accountofbank.registers();
        }
        else {
            if(choice==2){
                System.exit(0);
            }
            else{
                System.out.println("select a value only from the given options :");
                homepage();
            }
        }
    }
    static void promptDetails(){
        Scanner sc=new Scanner(System.in);
        System.out.println("WELCOME "+ATM.name+"! TO ATM SYSTEM");
        System.out.println("---------------------");
        System.out.println("Select option : ");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Transfer");
        System.out.println("4. Check balance");
        System.out.println("5. Transaction History");
        System.out.println("6. Exit");
        System.out.print("Enter your choice : ");
        int choice=sc.nextInt();
        switch (choice) {
            case 1:
                transactions.withdraw();
            case 2:
                transactions.deposit();
            case 3:
                transactions.transfer();
            case 4:
                checking.checkbalance();
            case 5:
                his.historyOfTransaction();
            case 6:
                System.exit(0);
        }
    }

    public static void main(String[] args) {
        homepage();
    }
}