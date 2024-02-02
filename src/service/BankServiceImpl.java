package service;

import dto.Account;
import exception.AccountCreationException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BankServiceImpl implements BankService{
    private Map<Integer,Account> accountMap;

    public BankServiceImpl() {
        this.accountMap = new HashMap<>();
    }

    @Override
    public Account createAccount(Account newAccount) throws AccountCreationException{
        //handle account exception
        if (newAccount==null) throw new AccountCreationException("Account can't be null");
        this.accountMap.put(newAccount.getId(),newAccount);
        return this.accountMap.get(newAccount.getId());
    }

    @Override
    public Account getAccountById(Integer accountId) throws AccountCreationException {
        if(accountId==null || accountId<=0) throw new AccountCreationException("AccountId can't be null or negative");
        return accountMap.get(accountId);
    }

    @Override
    public Collection<Account> getAllAccounts() throws AccountCreationException {
        if (accountMap.isEmpty()) throw new AccountCreationException("There is no account");
        return this.accountMap.values();
    }

    @Override
    public Double depositFundsById(Integer accountId, Double amount) throws AccountCreationException {
        if (accountId==null || accountId<1 ) throw new AccountCreationException("Account can't be Empty");
        if(amount<1) throw new AccountCreationException("Amount must be a positive number");
        Account account=accountMap.get(accountId);
        Double newAmount=account.getBalance()+amount;
        account.setBalance(newAmount);
        return newAmount;
    }

    @Override
    public Double withdrawFundsById(Integer accountId, Double amount) throws AccountCreationException {
        if (accountId==null || accountId<1 ) throw new AccountCreationException("Account can't be Empty");
        if(amount<1) throw new AccountCreationException("Amount must be a positive number");
        Account account=accountMap.get(accountId);
        Double newBalance=account.getBalance()-amount;
        if (newBalance<0) throw new AccountCreationException("Low balance to withdraw the given amount. you can withdraw: "+account.getBalance());
        account.setBalance(newBalance);
        return newBalance;
    }

    @Override
    public Boolean updateAccountById(Integer accountId, String newName) throws AccountCreationException {
        if (accountId==null || accountId<1 ) throw new AccountCreationException("Account can't be Empty");
        if(newName==null) throw new AccountCreationException("Name Should not be null");
        Account account=accountMap.get(accountId);
        account.setName(newName);
        return true;
    }

    @Override
    public Account deleteAccountById(Integer accountId) throws AccountCreationException {
        if (accountId==null || accountId<1 ) throw new AccountCreationException("Account can't be Empty");
        return accountMap.remove(accountId);
    }

    @Override
    public Account disableTheAccount(Integer accountId) throws AccountCreationException {
        if (accountId==null || accountId<1 ) throw new AccountCreationException("Account can't be Empty");
        Account account=accountMap.get(accountId);
        account.setActive(false);
        return account;
    }
}
