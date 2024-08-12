package model;

import java.time.LocalDateTime;

public class BankPaymentAccount extends Bank{
    private String cardNumber;
    private double accountBalance;


    public BankPaymentAccount(String id, double accountCode, String name, LocalDateTime accountCreationDate, String cardNumber, double accountBalance) {
        super(id, accountCode, name, accountCreationDate);
        this.cardNumber = cardNumber;
        this.accountBalance = accountBalance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return "BankPaymentAccount{" +
                "cardNumber='" + cardNumber + '\'' +
                ", accountBalance=" + accountBalance +
                "} " + super.toString();
    }

    @Override
    public String getInfoToCSV() {
        return String.format("%s,%f,%s,%s,,,%s,%f,,,%f",
                getId(), getAccountCode(), getName(), getAccountCreationDate().toLocalDate(),
                cardNumber, accountBalance);
    }

}
