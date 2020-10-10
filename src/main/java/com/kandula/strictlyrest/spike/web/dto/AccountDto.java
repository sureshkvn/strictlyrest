package com.kandula.strictlyrest.spike.web.dto;

public class AccountDto {
    private int id;
    private String accountType;
    private float accountBalance;

    public AccountDto(int id, String accountType, float accountBalance) {
        this.id = id;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return "AccountDto{" +
                "id=" + id +
                ", accountType='" + accountType + '\'' +
                ", accountBalance=" + accountBalance +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public float getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }
}
