package org.example.adapterlayerpoc.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PmPartyResp {
    private String refId;
    private String requestId;
    private int version;
    private String error;
}
