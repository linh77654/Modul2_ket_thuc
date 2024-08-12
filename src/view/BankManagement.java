package view;


import controller.BankController;
import model.Bank;

import java.util.Scanner;

public class BankManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankController bankController = new BankController();

        int choice;
        do {
            System.out.println("Quản lý Bank: \n" +
                    "1. Thêm mới. \n" +
                    "2. Xóa. \n" +
                    "3. Xem danh sách các tài khoản ngân hàng. \n" +
                    "4. Tìm kiếm. \n" +
                    "5. Thoát. \n" +
                    "Xin chọn:");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    bankController.addBank();
                    break;
                case 2:
                    bankController.deleteBank();
                    break;
                case 3:
                    bankController.displayBanks();
                    break;
                case 4:
                    System.out.println("Tìm kiếm theo mã tài khoản ngân hàng:");
                    double accountCode = Double.parseDouble(scanner.nextLine());
                    Bank bank = bankController.findBankById(accountCode);
                    if (bank != null) {
                        System.out.println("Tài khoản ngân hàng tìm thấy: ");
                        System.out.println(bank);
                    } else {
                        System.out.println("Không tìm thấy tài khoản ngân hàng với mã số " + accountCode);
                    }
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng thử lại.");
            }
        } while (choice != 5);
    }
}
