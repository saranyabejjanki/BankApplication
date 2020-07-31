package com.ns.bank.mapper;

import com.ns.bank.entity.Eligibility;
import com.ns.bank.model.EligibilityModel;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class EligibilityMapper {

    public Eligibility convertModelToEntity(EligibilityModel eligibilityModel){
        Eligibility eligibility = new Eligibility();
        eligibility.setMaxAge(eligibilityModel.getMaxAge());
        eligibility.setMinAge(eligibilityModel.getMinAge());
        if(Objects.nonNull(eligibilityModel.getId()))
            eligibility.setId(eligibilityModel.getId());
        return eligibility;
    }

    public EligibilityModel convertEntityToModel(Eligibility eligibility){
        EligibilityModel eligibilityModel = new EligibilityModel();
        if(Objects.nonNull(eligibility.getId()))
            eligibilityModel.setId(eligibility.getId());
        eligibilityModel.setMaxAge(eligibility.getMaxAge());
        eligibilityModel.setMinAge(eligibility.getMinAge());
        return eligibilityModel;
    }
}
