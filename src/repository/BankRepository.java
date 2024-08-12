package repository;

import model.Bank;
import model.BankPaymentAccount;
import model.BankSavingsAccount;
import ulit.ReadAndWrite;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

public class BankRepository implements IBankRepository {
    public static final String PATH = "src/datal/bank.csv";

    @Override
    public List<Bank> findAll() {
        List<String> stringList = ReadAndWrite.readFileCSVToListString(PATH);
        List<Bank> bankList = new ArrayList<>();
        for (String s : stringList) {
            String[] array = s.split(",");

            Bank bank = null;
            try {
                if (array.length == 12) {
                    LocalDate creationDate = LocalDate.parse(array[3]);
                    LocalDate savingsDate = LocalDate.parse(array[5]);
                    LocalDate depositDate = LocalDate.parse(array[8]);
                    double depositAmount = Double.parseDouble(array[7]);
                    double interestRate = Double.parseDouble(array[9]);
                    int term = Integer.parseInt(array[10]);
                    bank = new BankSavingsAccount(array[0], Double.parseDouble(array[1]), array[2],
                            creationDate.atStartOfDay(), array[4], savingsDate.atStartOfDay(),
                            array[6], depositAmount, depositDate.atStartOfDay(), interestRate, term);
                } else if (array.length == 7) {
                    LocalDate creationDate = LocalDate.parse(array[3]);
                    double accountBalance = Double.parseDouble(array[5]);
                    bank = new BankPaymentAccount(array[0], Double.parseDouble(array[1]), array[2],
                            creationDate.atStartOfDay(), array[4], accountBalance);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (bank != null) {
                bankList.add(bank);
            }
        }
        return bankList;
    }


    @Override
    public void addBank(Bank bank) {
        List<String> stringList = new ArrayList<>();
        stringList.add(bank.getInfoToCSV());
        ReadAndWrite.writeStringListToFile(PATH, stringList, true);
    }

    @Override
    public void updateBank(double accountCode, Bank updatedBank) {
        List<Bank> bankList = findAll();
        boolean updated = false;
        for (int i = 0; i < bankList.size(); i++) {
            if (bankList.get(i).getAccountCode() == accountCode) {
                bankList.set(i, updatedBank);
                updated = true;
                break;
            }
        }
        if (updated) {
            List<String> stringList = new ArrayList<>();
            for (Bank bank : bankList) {
                stringList.add(bank.getInfoToCSV());
            }
            ReadAndWrite.writeStringListToFile(PATH, stringList, false);
        }
    }

    @Override
    public Bank findBankById(double accountCode) {
        List<Bank> bankList = findAll();
        for (Bank bank : bankList) {
            if (bank.getAccountCode() == accountCode) {
                return bank;
            }
        }
        return null;
    }

    @Override
    public boolean deleteBank(double accountCode) {
        List<Bank> bankList = findAll();
        boolean removed = bankList.removeIf(bank -> bank.getAccountCode() == accountCode);
        if (removed) {
            List<String> stringList = new ArrayList<>();
            for (Bank bank : bankList) {
                stringList.add(bank.getInfoToCSV());
            }
            ReadAndWrite.writeStringListToFile(PATH, stringList, false);
        }
        return removed;
    }

    @Override
    public List<Bank> getAllBanks() {
        return null;
    }
}
