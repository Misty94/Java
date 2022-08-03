public class BankAccount{
    private double checkingBalance;
    private double savingsBalance;

    private static int totalAccounts;
    private static double totalAmount;


    public BankAccount(){
        this.checkingBalance = 0.00;
        this.savingsBalance = 0.00;
        totalAccounts++;
        totalAmount += (this.checkingBalance + this.savingsBalance);
    }

    public void displayInfo(){
        System.out.println("Checking Account Amount: $" + this.checkingBalance);
        System.out.println("Savings Account Amount: $" + this.savingsBalance);
    }

    public double getChecking(){
        return this.checkingBalance;
    }

    public void setChecking(double checkingBalance){
        this.checkingBalance = checkingBalance;
        totalAmount += this.checkingBalance;
    }

    public void setWithdrawalChecking(double checkingBalance){
        if (this.checkingBalance > checkingBalance){
            this.checkingBalance -= checkingBalance;
            totalAmount -= checkingBalance;
        }
        else {
            System.out.println("Insufficent Funds in your Checking Account");
        }
    }

    public double getSavings(){
        return this.savingsBalance;
    }

    public void setSavings(double savingsBalance){
        this.savingsBalance = savingsBalance;
        totalAmount += this.savingsBalance;
    }

    public void setWithdrawalSavings(double savingsBalance){
        if (this.savingsBalance > savingsBalance){
            this.savingsBalance -= savingsBalance;
            totalAmount -= savingsBalance;
        }
        else {
            System.out.println("Insufficent Funds in your Savings Account");
        }
    }

    public static int getTotalAccounts(){
        return totalAccounts;
    }

    public static double getTotalAmount(){
        return totalAmount;
    }
}