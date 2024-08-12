package controller;

import model.Bank;
import model.BankPaymentAccount;
import model.BankSavingsAccount;
import repository.IBankRepository;
import repository.BankRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class BankController {
    private IBankRepository bankRepository = new BankRepository();
    private Scanner sc = new Scanner(System.in);

    public void displayBanks() {
        List<Bank> banks = bankRepository.getAllBanks();
        if (banks.isEmpty()) {
            System.out.println("Danh sách tài khoản ngân hàng trống.");
        } else {
            for (Bank bank : banks) {
                System.out.println(bank);
            }
        }
    }

    public void editBank() {
        System.out.print("Nhập mã tài khoản cần chỉnh sửa: ");
        double accountCode = Double.parseDouble(sc.nextLine());

        Bank existingBank = bankRepository.findBankById(accountCode);
        if (existingBank == null) {
            System.out.println("Không tìm thấy tài khoản ngân hàng với mã số " + accountCode);
            return;
        }
        System.out.println("Thông tin tài khoản cần chỉnh sửa:");
        System.out.println(existingBank);

        int choice;
        do {
            System.out.println("Chọn thông tin cần chỉnh sửa: \n" +
                    "1. Tên. \n" +
                    "2. Ngày tạo tài khoản. \n" +
                    "3. Hoàn thành. \n"
            );
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Tên mới:");
                    String newName = sc.nextLine();
                    existingBank.setName(newName);
                    break;
                case 2:
                    System.out.println("Ngày tạo tài khoản mới (yyyy-MM-dd):");
                    try {
                        LocalDate newCreationDate = LocalDate.parse(sc.nextLine());
                        existingBank.setAccountCreationDate(newCreationDate.atStartOfDay());
                    } catch (DateTimeParseException e) {
                        System.out.println("Định dạng ngày tạo tài khoản không hợp lệ. Vui lòng nhập theo định dạng YYYY-MM-DD.");
                    }
                    break;
            }
        } while (choice != 3);
        bankRepository.updateBank(accountCode, existingBank);
    }



    public void addBank() {
        System.out.println("Chọn loại tài khoản ngân hàng: \n" +
                "1. Tài khoản tiết kiệm. \n" +
                "2. Tài khoản thanh toán. \n" +
                "Xin chọn:");
        int type = Integer.parseInt(sc.nextLine());

        System.out.println("Nhập mã tài khoản:");
        double accountCode = Double.parseDouble(sc.nextLine());
        System.out.println("Nhập tên chủ tài khoản:");
        String name = sc.nextLine();
        LocalDateTime creationDate = null;
        do {
            try {
                System.out.println("Nhập ngày tạo tài khoản (yyyy-MM-dd):");
                creationDate = LocalDate.parse(sc.nextLine()).atStartOfDay();
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Định dạng ngày tạo tài khoản không hợp lệ. Vui lòng nhập theo định dạng YYYY-MM-DD.");
            }
        } while (true);

        Bank newBank = null;
        switch (type) {
            case 1:
                System.out.println("Nhập số tài khoản tiết kiệm:");
                String savingsAccountNumber = sc.nextLine();
                System.out.println("Nhập ngày gửi tiền (yyyy-MM-dd):");
                LocalDateTime depositDate = LocalDate.parse(sc.nextLine()).atStartOfDay();
                System.out.println("Nhập số tài khoản thanh toán:");
                String paymentAccount = sc.nextLine();
                System.out.println("Nhập số tiền gửi:");
                double depositAmount = Double.parseDouble(sc.nextLine());
                System.out.println("Nhập lãi suất:");
                double interestRate = Double.parseDouble(sc.nextLine());
                System.out.println("Nhập kỳ hạn:");
                int term = Integer.parseInt(sc.nextLine());

                newBank = new BankSavingsAccount(
                        "", accountCode, name, creationDate,
                        savingsAccountNumber, depositDate, paymentAccount,
                        depositAmount, depositDate, interestRate, term
                );
                break;
            case 2:
                System.out.println("Nhập số thẻ:");
                String cardNumber = sc.nextLine();
                System.out.println("Nhập số dư tài khoản:");
                double accountBalance = Double.parseDouble(sc.nextLine());

                newBank = new BankPaymentAccount("", accountCode, name, creationDate, cardNumber, accountBalance);
                break;
        }

        if (newBank != null) {
            bankRepository.addBank(newBank);
        }
    }


    public void deleteBank() {
        System.out.print("Nhập mã tài khoản cần xóa: ");
        double accountCode = Double.parseDouble(sc.nextLine());

        Bank existingBank = bankRepository.findBankById(accountCode);
        if (existingBank == null) {
            System.out.println("Không tìm thấy tài khoản ngân hàng với mã số " + accountCode);
            return;
        }
        System.out.println("Thông tin tài khoản cần xóa:");
        System.out.println(existingBank);
        if (bankRepository.deleteBank(accountCode)) {
            System.out.println("Xóa thành công");
        }
    }

    public Bank findBankById(double accountCode) {
        return bankRepository.findBankById(accountCode);
    }

}



