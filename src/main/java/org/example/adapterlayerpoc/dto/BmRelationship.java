package org.example.adapterlayerpoc.dto;

import lombok.Data;

/*
create BmRelationship project using below json
[
  {
    "buyer": "string",
    "seller": "string",
    "type": "string",
    "additionalProp1": "string",
    "additionalProp2": "string",
    "additionalProp3": "string",
    "relationshipId": 0,
    "enabled": true
  }
]
create inner classes also and annotate with lombok data

 */
@Data
public class BmRelationship {
    private String buyer;
    private String seller;
    private String type;
    private int relationshipId;
    private boolean enabled;
    private String additionalProp1;
    private String additionalProp2;
    private String additionalProp3;
}
