package org.example.adapterlayerpoc.dto;

import lombok.Builder;
import lombok.Data;
import org.example.adapterlayerpoc.controller.Attributes;


/*
create a java object using
{
   "relationship_id": "string", (Optional & only for CREATE)
   "first_entity_id": "string",
   "second_entity_id": "string",
   "relationship_type": "string",
   "status": "APPROVED",
   "enabled": true,
   "attributes": {
   	"METADATA": {
       	"instance_list": [
           		{
              	  "key": "string",
               	  "value": "Object"
           		}
       	]
   	}
  }
}
and use attributes class
and no getter setter or constructor
 */

@Data
public class PmRelationship {
    private String relationship_id;
    private String first_entity_id;
    private String second_entity_id;
    private String relationship_type;
    private String status;
    private boolean enabled;
    public Attributes attributes;

}
