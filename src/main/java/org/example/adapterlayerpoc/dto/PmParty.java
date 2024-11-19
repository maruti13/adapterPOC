package org.example.adapterlayerpoc.dto;

/*

Write code to create a PmParty object from the JSON data below. Use the values provided, taking into account that party_id is optional and only required for CREATE operations. Convert nested JSON objects as appropriate, and map each field to the corresponding properties in the PmParty class.

{
   "party_id": "string", (Optional & only for CREATE)
   "name": "string",
   "type": "string",
   "country_of_origin": "string",
   "legal_term": "string",
   "status": "APPROVED",
   "enabled": true,
   "onboarded_at": "2023-04-13 14:51:16",
   "attributes": {
   	"METADATA": {
       	"instance_list": [
           		{
              	  "key": "string",
               	  "value": "Object"
           		}
       	]
   	},
	"PREFERENCE": {
       	"instance_list": [
           		{
               "key": "string",
               "value": "Object"
           		}
       	]
   	}
  }
}
 */

import lombok.Data;
import org.example.adapterlayerpoc.controller.Attributes;

@Data
public class PmParty {
    private String party_id;
    private String name;
    private String type;
    private String country_of_origin;
    private String legal_term;
    private String status;
    private boolean enabled;
    private String onboarded_at;
    public Attributes attributes;
}
