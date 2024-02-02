package service;
import dto.Account;
import exception.AccountCreationException;

import java.util.Collection;

public interface BankService {
    //Create
    Account createAccount(Account newAccount) throws AccountCreationException;

    //Read
    Account getAccountById(Integer accountId)throws AccountCreationException;
    Collection<Account> getAllAccounts()throws AccountCreationException;

    //Update
    Double depositFundsById(Integer accountId, Double amount)throws AccountCreationException;
    Double withdrawFundsById(Integer accountId, Double amount)throws AccountCreationException;
    Boolean updateAccountById(Integer accountId, String newName)throws AccountCreationException;

    //Delete
    Account deleteAccountById(Integer accountId)throws AccountCreationException;//hard delete
    Account disableTheAccount(Integer accountId)throws AccountCreationException;


}
