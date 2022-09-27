package models;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<BankAccount> allAccounts;

    public Bank(String name, ArrayList<BankAccount> allAccounts) {
        this.name = name;
        this.allAccounts = allAccounts;
    }

    public String getName() {
        return name;
    }

    public ArrayList<BankAccount> getAllAccounts() {
        return allAccounts;
    }

    public void addAccount(BankAccount account) {
        allAccounts.add(account);
    }
}
