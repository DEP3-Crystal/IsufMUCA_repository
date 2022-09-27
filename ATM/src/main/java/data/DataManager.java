package data;

import models.BankAccount;

import java.util.ArrayList;

public interface DataManager {

    BankAccount getBankAccount(String accountId);

    void setBankAccount(String accountId,BankAccount account);

    ArrayList<BankAccount> getAllBankAccounts();

}
