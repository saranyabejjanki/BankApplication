package com.ns.bank.model;

import java.io.Serializable;
import java.util.Set;


public class StatusModel implements Serializable {

    private Integer id;
    private String name;
    private Set<WithdrawModel> withdrawModels;
    private Set<TransferModel> transferModels;
    private Set<DepositModel> depositModels;
    private Set<ComplaintModel> complaintModels;
    private Set<LoanModel> loanModels;

    public StatusModel() {
    }

    public StatusModel(Integer id, String name, Set<WithdrawModel> withdrawModels, Set<TransferModel> transferModels, Set<DepositModel> depositModels, Set<ComplaintModel> complaintModels, Set<LoanModel> loanModels) {
        this.id = id;
        this.name = name;
        this.withdrawModels = withdrawModels;
        this.transferModels = transferModels;
        this.depositModels = depositModels;
        this.complaintModels = complaintModels;
        this.loanModels = loanModels;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Set<DepositModel> getDepositModels() {
        return depositModels;
    }

    public void setDepositModels(Set<DepositModel> depositModels) {
        this.depositModels = depositModels;
    }

    public Set<ComplaintModel> getComplaintModels() {
        return complaintModels;
    }

    public void setComplaintModels(Set<ComplaintModel> complaintModels) {
        this.complaintModels = complaintModels;
    }

    public Set<LoanModel> getLoanModels() {
        return loanModels;
    }

    public void setLoanModels(Set<LoanModel> loanModels) {
        this.loanModels = loanModels;
    }
}