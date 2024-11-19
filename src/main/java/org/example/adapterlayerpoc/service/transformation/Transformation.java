package org.example.adapterlayerpoc.service.transformation;

import org.example.adapterlayerpoc.dto.BmPartyResp;
import org.example.adapterlayerpoc.dto.PmPartyResp;

import java.util.Map;

public interface Transformation<I, T, R , S> {
    T transformRequest(I inputRequest, Map<String, String> pathParams, Map<String, String> queryParams, Map<String, String> headers);
    S transformResponse(R outputResponse);
}