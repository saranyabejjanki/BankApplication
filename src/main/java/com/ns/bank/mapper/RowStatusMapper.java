package com.ns.bank.mapper;

import com.ns.bank.entity.RowStatus;
import com.ns.bank.model.RowStatusModel;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class RowStatusMapper implements IRowStatusMapper {
    @Override
    public RowStatus convertModelToEntity(RowStatusModel rowStatusModel) {

            RowStatus rowStatus =new RowStatus();
            if(Objects.nonNull(rowStatusModel.getId())){
                rowStatus.setId(rowStatusModel.getId());
            }
            rowStatus.setName(rowStatusModel.getName());
            return rowStatus;
    }

    @Override
    public RowStatusModel convertEntityToModel(RowStatus rowStatus) {
        RowStatusModel rowStatusModel = new RowStatusModel();
        if(Objects.nonNull(rowStatus)){
            if(Objects.nonNull(rowStatus.getId())){
                rowStatusModel.setId(rowStatus.getId());
            }
            rowStatusModel.setName(rowStatus.getName());
        }
        return rowStatusModel;
    }
}