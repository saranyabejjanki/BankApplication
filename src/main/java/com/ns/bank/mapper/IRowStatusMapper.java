package com.ns.bank.mapper;

import com.ns.bank.entity.RowStatus;
import com.ns.bank.entity.User;
import com.ns.bank.model.RowStatusModel;
import com.ns.bank.model.UserModel;

public interface IRowStatusMapper {
    RowStatus convertModelToEntity(RowStatusModel rowStatusModel);
    RowStatusModel convertEntityToModel(RowStatus rowStatusEntity);
}
