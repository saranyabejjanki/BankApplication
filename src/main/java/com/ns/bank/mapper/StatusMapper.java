package com.ns.bank.mapper;

import com.ns.bank.entity.Status;
import com.ns.bank.model.StatusModel;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class StatusMapper {
    public Status convertModelToEntity(StatusModel statusModel) {
        Status status = new Status();
        if (Objects.nonNull(statusModel)) {
            status.setName(statusModel.getName());
            if (Objects.nonNull(statusModel.getId()))
                status.setId(statusModel.getId());
        }
        return status;
    }

    public StatusModel convertEntityToModel(Status status) {
        StatusModel statusModel = new StatusModel();
        if (Objects.nonNull(status)) {
            if (Objects.nonNull(status.getId()))
                statusModel.setId(status.getId());
            statusModel.setName(status.getName());
        }
        return statusModel;
    }
}
