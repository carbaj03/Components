package com.acv.components.infrastructure.persistence.retrofit.mapper;


import com.acv.components.domain.model.Picture;
import com.acv.components.infrastructure.domain.mapper.Mapper;
import com.acv.components.infrastructure.persistence.retrofit.model.PictureDataModel;

public class PictureMapper implements Mapper<PictureDataModel, Picture> {

    @Override
    public Picture map(PictureDataModel pictureDataModel) {
        if (pictureDataModel == null) {
            return null;
        }

        return new Picture(
                pictureDataModel.getMedium(),
                pictureDataModel.getThumbnail()
        );
    }
}
