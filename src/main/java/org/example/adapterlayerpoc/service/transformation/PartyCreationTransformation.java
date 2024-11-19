package org.example.adapterlayerpoc.service.transformation;

import org.example.adapterlayerpoc.controller.*;
import org.example.adapterlayerpoc.dto.BmParty;
import org.example.adapterlayerpoc.dto.BmPartyResp;
import org.example.adapterlayerpoc.dto.PmParty;
import org.example.adapterlayerpoc.dto.PmPartyResp;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class PartyCreationTransformation implements Transformation<BmParty, TransformedRequest, PmPartyResp, BmPartyResp> {


    @Override
    public TransformedRequest transformRequest(BmParty inputRequest, Map<String, String> pathParams, Map<String, String> queryParams, Map<String, String> headers) {
        PmParty pmParty = new PmParty();
        pmParty.setName(inputRequest.getName());
        pmParty.setType(inputRequest.getType());
        pmParty.setCountry_of_origin(inputRequest.getCountryOfOrigin());
        pmParty.setLegal_term(inputRequest.getLegalTerm());
        pmParty.setStatus("APPROVED");
        pmParty.setEnabled(inputRequest.isEnabled());
        pmParty.setOnboarded_at("2023-04-13 14:51:16");

        Attributes attributes = new Attributes();
        Metadata metadata = new Metadata();
        Metadata preference =  new Metadata();

        metadata.setInstance_list(List.of(new InstanceList("msmeName", "value")).toArray(new InstanceList[0]));

        attributes.setMetadata(metadata);
        attributes.setPreference(preference);

        pmParty.setAttributes(attributes);
        TransformedRequest transformedRequest = new TransformedRequest();
        transformedRequest.setUrl("http://localhost:8082/pm/createParty");
        transformedRequest.setMethod(HttpMethod.POST);
        transformedRequest.setHeaders(headers);
        transformedRequest.setQueryParams(queryParams);
        transformedRequest.setBody(pmParty);
        transformedRequest.setResponseType(PmPartyResp.class);
        return transformedRequest;
    }



    @Override
    public BmPartyResp transformResponse(PmPartyResp pmPartyResp) {
        System.out.println("Transforming response");
        BmPartyResp bmPartyResp = new BmPartyResp();
        bmPartyResp.setRefId(pmPartyResp.getRefId());
        bmPartyResp.setRequestId(pmPartyResp.getRequestId());
        bmPartyResp.setVersion(pmPartyResp.getVersion());
        bmPartyResp.setError(pmPartyResp.getError());
        return bmPartyResp;
    }
}