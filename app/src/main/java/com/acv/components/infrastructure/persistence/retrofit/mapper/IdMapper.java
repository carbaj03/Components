package com.acv.components.infrastructure.persistence.retrofit.mapper;


import com.acv.components.domain.model.Id;
import com.acv.components.infrastructure.domain.mapper.Mapper;
import com.acv.components.infrastructure.persistence.retrofit.model.IdDataModel;

public class IdMapper implements Mapper<IdDataModel, Id> {
    @Override
    public Id map(IdDataModel idDataModel) {
        if (idDataModel == null) {
            return null;
        }

        return new Id(
                idDataModel.getName(),
                idDataModel.getValue()
        );
    }
}
