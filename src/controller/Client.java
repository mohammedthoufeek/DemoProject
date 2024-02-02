package controller;

import dto.Account;
import exception.AccountCreationException;
import service.BankService;
import service.BankServiceImpl;


public class Client {
    public static void main(String[] args)  {
        BankService bankService=new BankServiceImpl();
        try {

            bankService.createAccount(new Account(12, "Thoufeek", 2340.0));
            bankService.createAccount(new Account(14, "Amar", 5320.0));
            bankService.createAccount(new Account(16, "Bala", 3560.0));
            System.out.println("All Accounts: "+bankService.getAllAccounts());
            bankService.depositFundsById(12,20000.0);
            System.out.println("All Accounts: "+bankService.getAllAccounts());
            bankService.withdrawFundsById(12,9320.0);
            System.out.println("All Accounts: "+bankService.getAllAccounts());

        }catch (AccountCreationException e){
            System.out.println(e.getMessage());
        }



    }
}
