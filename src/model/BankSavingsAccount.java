package model;

import java.time.LocalDateTime;

public class BankSavingsAccount extends Bank {
    private String savingsAccountNumber;
    private LocalDateTime savingsDate;
    private String paymentAccount;
    private double depositAmount;
    private LocalDateTime depositDate;
    private double interestRate;
    private int term;

    public BankSavingsAccount() {
        super();
    }

    public BankSavingsAccount(String id, double accountCode, String name, LocalDateTime accountCreationDate,
                              String savingsAccountNumber, LocalDateTime savingsDate, String paymentAccount,
                              double depositAmount, LocalDateTime depositDate, double interestRate, int term) {
        super(id, accountCode, name, accountCreationDate);
        this.savingsAccountNumber = savingsAccountNumber;
        this.savingsDate = savingsDate;
        this.paymentAccount = paymentAccount;
        this.depositAmount = depositAmount;
        this.depositDate = depositDate;
        this.interestRate = interestRate;
        this.term = term;
    }

    public String getSavingsAccountNumber() {
        return savingsAccountNumber;
    }

    public void setSavingsAccountNumber(String savingsAccountNumber) {
        this.savingsAccountNumber = savingsAccountNumber;
    }

    public LocalDateTime getSavingsDate() {
        return savingsDate;
    }

    public void setSavingsDate(LocalDateTime savingsDate) {
        this.savingsDate = savingsDate;
    }

    public String getPaymentAccount() {
        return paymentAccount;
    }

    public void setPaymentAccount(String paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public LocalDateTime getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(LocalDateTime depositDate) {
        this.depositDate = depositDate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return "BankSavingsAccount{" +
                "savingsAccountNumber='" + savingsAccountNumber + '\'' +
                ", savingsDate=" + savingsDate +
                ", paymentAccount='" + paymentAccount + '\'' +
                ", depositAmount=" + depositAmount +
                ", depositDate=" + depositDate +
                ", interestRate=" + interestRate +
                ", term=" + term +
                "} " + super.toString();
    }

    @Override
    public String getInfoToCSV() {
        return String.format("%s,%f,%s,%s,%s,%s,%s,%f,%s,%f,%d",
                getId(), getAccountCode(), getName(), getAccountCreationDate().toLocalDate(),
                savingsAccountNumber, savingsDate.toLocalDate(), paymentAccount, depositAmount,
                depositDate.toLocalDate(), interestRate, term
        );
    }
}
