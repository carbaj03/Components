package com.acv.components.infrastructure.persistence.retrofit.mapper;


import com.acv.components.domain.model.Location;
import com.acv.components.infrastructure.domain.mapper.Mapper;
import com.acv.components.infrastructure.persistence.retrofit.model.LocationDataModel;

public class LocationMapper implements Mapper<LocationDataModel, Location> {
    @Override
    public Location map(LocationDataModel locationDataModel) {
        if (locationDataModel == null) {
            return null;
        }

        return new Location(
                locationDataModel.getStreet(),
                locationDataModel.getCity(),
                locationDataModel.getState(),
                locationDataModel.getPostcode()
        );
    }
}
