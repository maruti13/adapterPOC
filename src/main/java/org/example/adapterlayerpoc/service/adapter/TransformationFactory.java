package org.example.adapterlayerpoc.service.adapter;

import org.example.adapterlayerpoc.service.transformation.PartyCreationTransformation;
import org.example.adapterlayerpoc.service.transformation.RelationshipCreationTransformation;
import org.example.adapterlayerpoc.service.transformation.Transformation;
import org.springframework.stereotype.Component;
import org.example.adapterlayerpoc.constants.ApiName;

@Component
public class TransformationFactory {


    public Transformation<?, ?, ?, ?> getTransformation(String apiName) {
        switch (apiName) {
            case ApiName.CREATE_PARTY:
                return new PartyCreationTransformation();
            case ApiName.CREATE_RELATIONSHIP:
                return new RelationshipCreationTransformation();
            default:
                throw new IllegalArgumentException("Unknown API name: " + apiName);
        }
    }
}