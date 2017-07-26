package com.acv.components.infrastructure.persistence.retrofit.mapper;


import com.acv.components.domain.model.Name;
import com.acv.components.infrastructure.domain.mapper.Mapper;
import com.acv.components.infrastructure.persistence.retrofit.model.NameDataModel;

public class NameMapper implements Mapper<NameDataModel, Name> {

    @Override
    public Name map(NameDataModel nameDataModel) {
        if (nameDataModel == null) {
            return null;
        }

        return new Name(
                nameDataModel.getFirst(),
                nameDataModel.getLast()
        );
    }
}
