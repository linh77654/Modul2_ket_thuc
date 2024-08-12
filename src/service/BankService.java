package service;

import model.Bank;
import repository.BankRepository;
import repository.IBankRepository;

import java.util.List;

public class BankService implements IBankService {
    private IBankRepository bankRepository = new BankRepository();

    @Override
    public List<Bank> findAll() {
        return bankRepository.findAll();
    }

    @Override
    public void addBank(Bank bank) {
         bankRepository.addBank(bank);
    }

    @Override
    public void updateBank(double accountCode, Bank updatedBank) {
        bankRepository.updateBank(accountCode,updatedBank);
    }

    @Override
    public Bank findBankById(double accountCode) {
        return bankRepository.findBankById(accountCode);
    }

    @Override
    public boolean deleteBank(double accountCode) {
        return bankRepository.deleteBank(accountCode);
    }
}

