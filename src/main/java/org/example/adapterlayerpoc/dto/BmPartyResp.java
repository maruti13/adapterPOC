package org.example.adapterlayerpoc.dto;

import lombok.Data;

@Data
public class BmPartyResp {
    private String refId;
    private String requestId;
    private int version;
    private String error;
}
