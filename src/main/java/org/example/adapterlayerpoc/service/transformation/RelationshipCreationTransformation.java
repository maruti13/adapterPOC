package org.example.adapterlayerpoc.service.transformation;

import org.apache.logging.log4j.CloseableThreadContext;
import org.example.adapterlayerpoc.controller.Attributes;
import org.example.adapterlayerpoc.controller.InstanceList;
import org.example.adapterlayerpoc.controller.Metadata;

import java.util.List;
import java.util.Map;

import org.example.adapterlayerpoc.dto.BmRelationship;
import org.example.adapterlayerpoc.dto.PmRelationship;
import org.example.adapterlayerpoc.dto.PmRelationshipResp;
import org.example.adapterlayerpoc.dto.BmRelationshipResp;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import java.util.Map;
/*
create a relationshipCreationTransformation class same as PartyCreationTransformation but it takes input as bmRelationship object and convert that into PmRelationship Object and map additionalProp1, additionalProp2 to attribute.metadata.instances as key value pair and additionalProp3 to attribute.prefences as key value pair. in value give "string", do it similar to partyCreationTransformation like instance_list part. return the transformed request calling URI : "/pm/createRelationship/" and POST api
 */
@Component
public class RelationshipCreationTransformation implements Transformation<BmRelationship, TransformedRequest, PmRelationshipResp, BmRelationshipResp> {

    @Override
    public TransformedRequest transformRequest(BmRelationship inputRequest, Map<String, String> pathParams, Map<String, String> queryParams, Map<String, String> headers) {
        PmRelationship pmRelationship = new PmRelationship();
        pmRelationship.setFirst_entity_id(inputRequest.getBuyer());
        pmRelationship.setSecond_entity_id(inputRequest.getSeller());
        pmRelationship.setRelationship_type(inputRequest.getType());
        pmRelationship.setStatus("APPROVED");
        pmRelationship.setEnabled(inputRequest.isEnabled());

        Attributes attributes = new Attributes();
        attributes.setMetadata(new Metadata());
        attributes.setPreference(new Metadata());

        attributes.getMetadata().setInstance_list(List.of(
                new InstanceList("additionalProp1", "string"),
                new InstanceList("additionalProp2", "string")
        ).toArray(new InstanceList[0]));

        attributes.getPreference().setInstance_list(List.of(
                new InstanceList("additionalProp3", "string")
        ).toArray(new InstanceList[0]));

        pmRelationship.setAttributes(attributes);

        TransformedRequest transformedRequest = new TransformedRequest();
        transformedRequest.setUrl("http://localhost:8082/pm/createRelationship");
        transformedRequest.setMethod(HttpMethod.POST);
        transformedRequest.setHeaders(headers);
        transformedRequest.setQueryParams(queryParams);
        transformedRequest.setBody(pmRelationship);
        transformedRequest.setResponseType(PmRelationshipResp.class);
        return transformedRequest;
    }

    @Override
    public BmRelationshipResp transformResponse(PmRelationshipResp pmRelationshipResp) {
        BmRelationshipResp bmRelationshipResp = new BmRelationshipResp();
        bmRelationshipResp.setRefId(pmRelationshipResp.getRefId());
        bmRelationshipResp.setRequestId(pmRelationshipResp.getRequestId());
        bmRelationshipResp.setVersion(pmRelationshipResp.getVersion());
        bmRelationshipResp.setError(pmRelationshipResp.getError());
        return bmRelationshipResp;
    }
}