package com.ns.bank.entity;

import sun.util.resources.Bundles;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="eligibility")
public class Eligibility  implements Serializable {

    private Long id;
    private Set<AccountType> accountTypes;
    private Integer minAge;
    private Integer maxAge;

    public Eligibility() {
    }

    public Eligibility(Long id, Set<AccountType> accountTypes, Integer minAge, Integer maxAge) {
        this.id = id;
        this.accountTypes = accountTypes;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Column(name="minAge")
    public Integer getMinAge() {
        return minAge;
    }
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "eligibility")
    public Set<AccountType> getAccountTypes() {
        return accountTypes;
    }

    public void setAccountTypes(Set<AccountType> accountTypes) {
        this.accountTypes = accountTypes;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    @Column(name="maxAge")
    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }
}
