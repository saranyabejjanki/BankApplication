package com.ns.bank.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class CustomerModel implements Serializable {

    private Long accountNo;
    private String name;
    private Date dob;
    private AddressModel addressModel;
    private String email;
    private String password;
    private String confirmPassword;
    private BranchModel branchModel;
    private StatusModel statusModel;
    private Date accountCreatedDate;
    private AccountTypeModel accountTypeModel;
    private Double balance;
   /* private Set<DepositModel> depositModels;
    private Set<WithdrawModel> withdrawModels;
    private Set<TransferModel> transferModels;
    private Set<LoanModel> loanModels;*/

    public CustomerModel() {
    }

    public CustomerModel( String name, Date dob, AddressModel addressModel, String email, Long accountNo, String password, String confirmPassword, BranchModel branchModel, StatusModel statusModel, Date accountCreatedDate, AccountTypeModel accountTypeModel,Double balance /* Set<DepositModel> depositModels, Set<WithdrawModel> withdrawModels, Set<TransferModel> transferModels, Set<LoanModel> loanModels*/) {

        this.name = name;
        this.dob = dob;
        this.addressModel = addressModel;
        this.email = email;
        this.accountNo = accountNo;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.branchModel = branchModel;
        this.statusModel = statusModel;
        this.accountCreatedDate = accountCreatedDate;
        this.accountTypeModel = accountTypeModel;
        this.balance=balance;
      /*  this.depositModels = depositModels;
        this.withdrawModels = withdrawModels;
        this.transferModels = transferModels;
        this.loanModels = loanModels;*/
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public AddressModel getAddressModel() {
        return addressModel;
    }

    public void setAddressModel(AddressModel addressModel) {
        this.addressModel = addressModel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Long accountNo) {
        this.accountNo = accountNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public BranchModel getBranchModel() {
        return branchModel;
    }

    public void setBranchModel(BranchModel branchModel) {
        this.branchModel = branchModel;
    }

    public StatusModel getStatusModel() {
        return statusModel;
    }

    public void setStatusModel(StatusModel statusModel) {
        this.statusModel = statusModel;
    }

    public Date getAccountCreatedDate() {
        return accountCreatedDate;
    }

    public void setAccountCreatedDate(Date accountCreatedDate) {
        this.accountCreatedDate = accountCreatedDate;
    }

    public AccountTypeModel getAccountTypeModel() {
        return accountTypeModel;
    }

    public void setAccountTypeModel(AccountTypeModel accountTypeModel) {
        this.accountTypeModel = accountTypeModel;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

/* public Set<DepositModel> getDepositModels() {
        return depositModels;
    }

    public void setDepositModels(Set<DepositModel> depositModels) {
        this.depositModels = depositModels;
    }

    public Set<WithdrawModel> getWithdrawModels() {
        return withdrawModels;
    }

    public void setWithdrawModels(Set<WithdrawModel> withdrawModels) {
        this.withdrawModels = withdrawModels;
    }

    public Set<TransferModel> getTransferModels() {
        return transferModels;
    }

    public void setTransferModels(Set<TransferModel> transferModels) {
        this.transferModels = transferModels;
    }

    public Set<LoanModel> getLoanModels() {
        return loanModels;
    }

    public void setLoanModels(Set<LoanModel> loanModels) {
        this.loanModels = loanModels;
    }*/

    @Override
    public String toString() {
        return "CustomerModel{" +
                "name='" + name + '\'' +
                ", dob=" + dob +
                ", addressModel=" + addressModel +
                ", email='" + email + '\'' +
                ", accountNo=" + accountNo +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", branchModel=" + branchModel +
                ", statusModel=" + statusModel +
                ", accountCreatedDate=" + accountCreatedDate +
                ", accountTypeModel=" + accountTypeModel +
                '}';
    }
}