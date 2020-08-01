package com.ns.bank.model;

import java.io.Serializable;
import java.util.Set;


public class StatusModel implements Serializable {

    private Integer id;
    private String name;
   /* private Set<WithdrawModel> withdrawModels;
    private Set<TransferModel> transferModels;
    private Set<DepositModel> depositModels;
    private Set<ComplaintModel> complaintModels;
    private Set<LoanModel> loanModels;*/

    public StatusModel() {
    }

    public StatusModel(Integer id, String name) {
        this.id = id;
        this.name = name;
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

}