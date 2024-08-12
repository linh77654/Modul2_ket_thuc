package model;

import java.time.LocalDateTime;

public abstract class Bank {
    private String id;
    private double accountCode;
    private String name;
    private LocalDateTime accountCreationDate;

    public Bank(){}

    public Bank(String id, double accountCode, String name, LocalDateTime accountCreationDate) {
        this.id = id;
        this.accountCode = accountCode;
        this.name = name;
        this.accountCreationDate = accountCreationDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(double accountCode) {
        this.accountCode = accountCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getAccountCreationDate() {
        return accountCreationDate;
    }

    public void setAccountCreationDate(LocalDateTime accountCreationDate) {
        this.accountCreationDate = accountCreationDate;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id='" + id + '\'' +
                ", accountCode=" + accountCode +
                ", name='" + name + '\'' +
                ", accountCreationDate=" + accountCreationDate +
                '}';
    }

    public abstract String getInfoToCSV();
}
