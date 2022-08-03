public class BankAccountTest{
    public static void main(String[] args){
        
        System.out.println("--- Bank Accounts #1 ---");
        BankAccount account1 = new BankAccount();
        account1.setChecking(100);
        account1.setSavings(300.98);
        account1.setWithdrawalSavings(99.97);
        account1.setWithdrawalChecking(33.10);
        account1.displayInfo();

        System.out.println("--- Bank Accounts #2 ---");
        BankAccount account2 = new BankAccount();
        account2.setChecking(1200.50);
        account2.setWithdrawalChecking(200);
        account2.setSavings(675.75);
        account2.displayInfo();

        System.out.println("--- Bank Info ---");
        System.out.println("Total Number of Accounts: " + BankAccount.getTotalAccounts());
        System.out.println("Total Amount: $" + BankAccount.getTotalAmount());
    }
}