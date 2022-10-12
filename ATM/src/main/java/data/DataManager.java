package data;

import models.BankAccount;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface DataManager {

    BankAccount getBankAccount(String accountId);

    void setBankAccount(String accountId, BankAccount account, List<BankAccount> accounts);

    ArrayList<BankAccount> getAllBankAccounts();

    void update(List<BankAccount> accounts)throws IOException;

}
