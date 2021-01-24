
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