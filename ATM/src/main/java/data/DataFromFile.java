package data;


import models.BankAccount;
import models.CreditCard;
import models.CurrencyType;
import models.Person;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataFromFile implements DataManager {

    private final String path;

    String[] HEADERS = new String[]{"accountId",
            "id",
            "name",
            "surname",
            "email",
            "nationality",
            "age",
            "cardId",
            "password",
            "currency",
            "amount"};

    public DataFromFile(String path) {
        this.path = path;
    }

    @Override
    public BankAccount getBankAccount(String accountId) {

        ArrayList<BankAccount> accounts = getAllBankAccounts();

        for (BankAccount account : accounts) {

            if (account.getAccountId().equals(accountId)) {

                return account;
            }
        }
        return null;
    }

    @Override
    public void setBankAccount(String accountId, BankAccount account, List<BankAccount> accounts) {
        try {
            for (BankAccount bankAccount : accounts) {
                if (bankAccount.getAccountId().equals(accountId)) {
                    int index = accounts.indexOf(bankAccount);
                    accounts.set(index, account);
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public ArrayList<BankAccount> getAllBankAccounts() {

        Reader reader;
        CSVParser csvParser;

        try {

            ArrayList<BankAccount> accounts = new ArrayList<>();

            reader = new FileReader(path);

            csvParser = CSVParser.parse(Paths.get(path), Charset.defaultCharset(), CSVFormat.DEFAULT.withHeader(HEADERS).withSkipHeaderRecord());

            for (CSVRecord record : csvParser) {
                accounts.add(
                        new BankAccount(
                                record.get("accountId"),
                                new Person(
                                        record.get("id"),
                                        record.get("name"),
                                        record.get("surname"),
                                        record.get("email"),
                                        record.get("nationality"),
                                        Integer.parseInt(record.get("age"))),
                                new CreditCard(record.get("cardId"),
                                        Integer.parseInt(record.get("password"))),
                                CurrencyType.valueOf(record.get("currency")),
                                new BigDecimal(record.get("amount"))
                        ));
            }
            csvParser.close();
            reader.close();
            return accounts;
        } catch (
                Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public void update(List<BankAccount> accounts) throws IOException {

        FileWriter out = new FileWriter(path);

        try {
            CSVPrinter printer = new CSVPrinter(out,
                    CSVFormat.DEFAULT
                            .withHeader(HEADERS));

            accounts.forEach(account -> {
                try {
                    printer.printRecord(account.getAccountId(),
                            account.getPerson().getId(),
                            account.getPerson().getName(),
                            account.getPerson().getSurname(),
                            account.getPerson().getEmail(),
                            account.getPerson().getNationality(),
                            account.getPerson().getAge() + "",
                            account.getCard().getCardId(),
                            account.getCard().getPassword() + "",
                            account.getCurrency(),
                            account.getAmount() + "");

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            printer.close();
            out.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}



