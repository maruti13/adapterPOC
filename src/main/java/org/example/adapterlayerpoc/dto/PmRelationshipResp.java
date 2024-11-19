package org.example.adapterlayerpoc.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PmRelationshipResp {
    private String refId;
    private String requestId;
    private int version;
    private String error;
}
