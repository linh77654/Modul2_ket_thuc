package repository;

import model.Bank;

import java.util.List;

public interface IBankRepository {
    List<Bank> findAll();
    void addBank(Bank bank);
    void updateBank(double accountCode, Bank updatedBank);
    Bank findBankById(double accountCode);
    boolean deleteBank(double accountCode);

    List<Bank> getAllBanks();
}
