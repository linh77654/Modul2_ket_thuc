package service;

import model.Bank;

import java.util.List;

public interface IBankService {
    List<Bank> findAll();
    void addBank(Bank bank);
    void updateBank(double accountCode, Bank updatedBank);
    Bank findBankById(double accountCode);
    boolean deleteBank(double accountCode);
}
