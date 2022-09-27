package data;

import models.BankAccount;
import models.CreditCard;
import models.Person;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

public class DataFromFileManager implements DataManager {

    private final Properties accountsFile;

    private FileOutputStream out;


    public DataFromFileManager(String path) throws IOException {
        accountsFile = new Properties();
        accountsFile.load(new FileInputStream(path));
        out = new FileOutputStream(path);
    }

    @Override
    public BankAccount getBankAccount(String accountId) {

        BankAccount bankAccount;

        if (accountsFile.containsKey(accountId)) {
            String[] values = accountsFile.get(accountId).toString().split(" ");
            Person person = new Person(values[0], values[1], values[2], values[3], values[4], Integer.parseInt(values[5]));
            CreditCard creditCard = new CreditCard(values[6], Integer.parseInt(values[7]));
            bankAccount = new BankAccount(accountId, person, creditCard, new BigDecimal(values[8]), new BigDecimal(values[9]));
        } else {
            throw new RuntimeException("There isn't any registered account with the provided id");
        }

        return bankAccount;
    }

    @Override
    public void setBankAccount(String accountId, BankAccount account) {
        String value = accountId + " ";
        value += account.getPerson().getId() + " ";
        value += account.getPerson().getName() + " ";
        value += account.getPerson().getSurname() + " ";
        value += account.getPerson().getEmail() + " ";
        value += account.getPerson().getNationality() + " ";
        value += account.getPerson().getAge() + " ";
        value += account.getCard().getCardId() + " ";
        value += account.getCard().getPassword() + " ";
        value += account.getDepositInEuro() + " ";
        value += account.getDepositInDollars();
        accountsFile.setProperty(accountId, value);
        try {
            accountsFile.store(out, "");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @Override
    public ArrayList<BankAccount> getAllBankAccounts() {

        ArrayList<BankAccount> allAccounts = new ArrayList<>();

        Set<Object> keys = accountsFile.keySet();
        for (Object key : keys) {
            String accountInfo = accountsFile.get(key).toString();
            String[] values = accountInfo.split(" ");
            Person person = new Person(values[0], values[1], values[2], values[3], values[4], Integer.parseInt(values[5]));
            CreditCard creditCard = new CreditCard(values[6], Integer.parseInt(values[7]));
            BankAccount bankAccount = new BankAccount(key.toString(), person, creditCard, new BigDecimal(values[8]), new BigDecimal(values[9]));
            allAccounts.add(bankAccount);
        }
        return allAccounts;
    }
}
