// As described task is:

// You have to create a program for ATM Which would have certain defined denominations of notes : 100 ,200, 500, and 2000 INR.

// Now you have to design your ATM in such a way that at any time ATM can be top-up with any required domination like I can add 41000 as (2000 x 20) + (500 x 2) notes

// Your ATM should have a function to withdraw cash , input can be any amount:

// Use cases for withdraw as below:
// 1: if amount is not present show error insufficient balance
// 2: if amount is not in the factor of available denominations show error to ask for multiple of available denomination
// 3: first largest denomination should be used than smaller : like if I opt for 2300 rs, amount dispatched should be (2000 x 1 ) + (200 x 1) + (100 x 1)
// 3.b: if any denomination is not there like suppose you don’t have 2000 notes left in ATM , then, amount dispatched should be (500 x 4) +  (200 x 1) + (100 x 1)


// Next step: it can be done by Modi Ji, that older denomination is not valid in case of demonetization, like 2000 Notes are banned and new 5000 notes are legal , so you code should be like you don’t need to change much of it, 


// Try to achieve OOPS , and SOLID principles as much as you can, 

// Also, we will add new use cases to see whether your system can adapt to those changes. If Not, then your design is bad. (SOLID,TRY,YAGNI,KISS)
// please keep in mind that you have to apply OOPs concepts and Chain of responsibility




import java.util.*;
// Person details
class person{
    String name;
    String dob;
    public person(String name,String dob){
        this.name = name;
        this.dob = dob;
    }
    public void getName(){System.out.print("Name : "+this.name);}
    
    public void getdob(){System.out.print("Date of Birth : "+this.dob);}
}
//Account of person
class account extends person{
    String accountNumber="12345678";
    String accountType;
    long balance;
    long card_credit_debit;
    public account(){
        super("","");
        this.accountNumber = "";
        this.accountType = "";
        this.balance = 0;
        this.card_credit_debit = 0;
    }
    public account(String accountNumber,String accountType,long balance,String name,String dob,long card_credit_debit){
        super(name,dob);
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.card_credit_debit = card_credit_debit;
    }
    public void getAccountNumber(){System.out.println("Account Number : "+this.accountNumber);}
    public void getAccountType(){System.out.println("Account Type : "+this.accountType);}
    public void getAccountBalance(){System.out.println("Account Balance : "+this.balance);}
    
    public void WithdrawBalance(long bal){
        if(this.balance > bal && this.balance-bal>100){
            this.balance -= bal;
            System.out.println("Balance Withdraw succesfully!!!");
        }else
            System.out.println("Incefficent Balance To Withdraw!!!");
    }

    public void depositeBalance(long bal){
        this.balance -= bal;
        System.out.println("Balance deposite succesfully!!!");
    }
}

class Bank{
    HashMap<String,account> customerAccounts = new HashMap<>();

    public Bank(){}

    //Account Opening function
    public void openAccount(){
        Scanner sc = new Scanner(System.in);
        String Name,dob,accountType;
        long accountNumber,balance,card_credit_debit;

        System.out.print("Enter Customer Name : ");
        Name = sc.nextLine();
        System.out.print("Enter Customer Date of birth : ");
        dob = sc.next();
        System.out.print("Enter Customer Account type(Saving/current) : ");
        accountType = sc.next();
        
        System.out.print("Enter Customer opening Balance  : ");
        balance = sc.nextLong();
    
        String accountNumber_temp = accountNumberGenerator();

        while(customerAccounts.containsKey(accountNumber_temp) == true){
            accountNumber_temp = accountNumberGenerator();
        }

        System.out.println("Do you want credit  card or debit card? If yes press y else press n..");
        ch = sc.next().charAt(0))

        if(ch == 'y'|| ch == 'Y'){
            card_credit_debit =  cardNumber_generator();
            for (Map.Entry mapElement : customerAccounts.entrySet()) {                     
                if(mapElement.getValue().card_credit_debit == card_credit_debit){
                    card_credit_debit = generateRandom();
                } 
            } 
        }else{
            card_credit_debit = 0;
        }

        customerAccounts.put(accountNumber_temp,new account(accountNumber_temp,accountType,balance,Name,dob,card_credit_debit));

        System.out.println("Account open sucessfully!!!!1");

        System.out.println("Name : "+Name+"\nAccount Number : "+accountNumber_temp+"\nBalance : "+balance);
    }

    //Random account number generator.
    public String accountNumberGenerator(){
        Random rand = new Random();
        return "52543678"+rand.nextInt(10000);
    }

    //Random Credit or debit card number generator.
    long cardNumber_generator() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        // first not 0 digit
        sb.append(random.nextInt(9) + 1);
        // rest of 11 digits
        for (int i = 0; i < 11; i++) {
            sb.append(random.nextInt(10));
        }
        return Long.valueOf(sb.toString()).longValue();
    }

    public void depositeMoney(){}
    public void withdrawMoney(){}
    public void deleteAccount(){}
}


class ATM extends Bank{
    long noteOf_100;
    long noteOf_200;
    long noteOf_500;
    long noteOf_2000;
    
    public ATM(){
        this.noteOf_100 = 0;
        this.noteOf_200 = 0;
        this.noteOf_500 = 0;
        this.noteOf_2000 = 0;
    }
    //Add Money into ATM..
    public void addMoneyInATM(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Note of 100 : ");
        this.noteOf_100 += sc.nextLong();
        
        System.out.println("Enter Note of 200 : ");
        this.noteOf_200 += sc.nextLong();
        
        System.out.println("Enter Note of 500 : ");
        this.noteOf_500 += sc.nextLong();
        
        System.out.println("Enter Note of 2000 : ");
        this.noteOf_2000 += sc.nextLong();
    }

    //Deposite Money into ATM
    public void deposite(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Account Number : ");
        String accountNumber_temp = sc.next();
        if(customerAccounts.containsKey(accountNumber_temp)==true){
            account temp = customerAccounts.get(accountNumber_temp);
            System.out.println("Account Holder Name : "+temp.name)
            System.out.println("Enter Number of Note 100(if Not press 0) : ");
            int note_100 += sc.nextInt();
            System.out.println("Enter Number of Note 200(if Not press 0) : ");
            int note_200 += sc.nextInt();
            System.out.println("Enter Number of Note 500(if Not press 0) : ");
            int note_500 += sc.nextInt();
            System.out.println("Enter Number of Note 2000(if Not press 0) : ");
            int note_2000 += sc.nextInt();
            temp.balance = note_100*100+note_200*200+note_500*500+note_2000*2000;
            this.noteOf_100 += note_100;
            this.noteOf_200 += note_200;
            this.noteOf_500 += note_500;
            this.noteOf_2000 += note_2000;
            System.out.println("Total Ammount = "+note_100*100+note_200*200+note_500*500+note_2000*2000);
            System.out.println("Total Balance = "+temp.balance);
        }else{
            System.out.println("Wrong Account Number!!!!");
        }
    }

    //Withdraw Money into ATM
    public void withdraw(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Account Number : ");
        long card_credit_debit_temp = sc.nextLong(); // Debit/Credit card scan number
        account temp;
        for (Map.Entry mapElement : customerAccounts.entrySet()) { 
            temp = mapElement.getValue();                   
            if(temp.card_credit_debit == card_credit_debit){
                break;
            } 
        }
        System.out.println("Enter Amount : ");
        long amount = sc.nextLong();
        if(amount <= note_100*100+note_200*200+note_500*500+note_2000*2000)
            findMin(amount);
        else
            System.out.print("Insufficient balance in ATM")
    }

    //Notes required to your amount
    public void countCurrency(int amount){ 
        int[] notes = new int[]{2000, 500, 200, 100}; 
        int[] noteCounter = new int[4]; 
        int[] notesNumber = new int[this.note_2000,this.note_500,this.note_200,this.note_100];

        // count notes using Greedy approach 
        for (int i = 0; i < 4; i++) { 
            if (amount >= notes[i]) { 
                noteCounter[i] = amount / notes[i]; 
                amount = amount - noteCounter[i] * notes[i]; 
            } 
        } 
        // Print notes thats comes through ATM
        System.out.println("Notes are as "); 
        for (int i = 0; i < 4; i++) { 
            if (noteCounter[i] != 0) {
                if(notesNumber[i] == noteCounter[i]){ 
                    System.out.println(notes[i] + " : " + noteCounter[i]);
                    notesNumber[i] = 0;
                }
                if(notesNumber[i] > noteCounter[i]){
                    System.out.print(notes[i] + " : " + noteCounter[i]);
                    notesNumber[i] -= noteCounter[i]; 
                }
                if(notesNumber[i] < noteCounter[i]){
                    System.out.print(notesNumber[i] + " : " + noteCounter[i]);
                    notesNumber[i] = 0;
                    int temp = noteCounter[i]-notesNumber[i];
                    noteCounter[i+1] += (temp*notes[i])%notes[i+1]); 
         .       }
            } 
        } 
    } 
}

class craterZone{
    public static void main(String str[]){
        Bank bank = new Bank();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("\t\t\tWelcome to ######## bank--------");
            System.out.println("\t\t\tChoose option !!!!");
            System.out.println("\t\t\t1.Open Account.");
            System.out.println("\t\t\t2.Desposite Money.");
            System.out.println("\t\t\t3.Withdraw Money.");
            System.out.println("\t\t\t4.Delete Account.");
            System.out.println("\t\t\t5.Exit!!!!");
            System.out.println("Enter your choice!!!");
            
            int ch = sc.nextInt();
            switch(ch){
                case 1:
                    bank.openAccount();
                    break;
                case 2:
                    bank.depositeMoney();
                    break;
                case 3:
                    bank.withdrawMoney();
                    break;
                case 4:
                    bank.deleteAccount();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid Option!!!!");
            }
            if(ch == 5)
                break;
        }

    }
}
        