package org.example.adapterlayerpoc.dto;


/*complete this BmParty object taking reference from
{
  "name": "string",
  "type": "string",
  "countryOfOrigin": "string",
  "registrationId": "string",
  "registrationNumber": "string",
  "legalTerm": "string",
  "taxation": "string",
  "taxIdentifier": "string",
  "taxNumber": "string",
  "tdsComplaint": true,
  "msmeName": "string",
  "msmeEndDate": "2024-11-13T09:08:14.633Z",
  "msmeCommunicationDate": "2024-11-13T09:08:14.633Z",
  "msmeEnterpriseType": "string",
  "companyStatus": "string",
  "msmeNumber": "string",
  "msmeStartDate": "2024-11-13T09:08:14.633Z",
  "onboardingFlow": "string",
  "enabled": true,
  "tcsCompliant": true,
  "leiNumber": "string",
  "leiExpiryDate": "2024-11-13T09:08:14.633Z"
}
 */

import lombok.Data;


@Data
public class BmParty {
    private String name;
    private String type;
    private String countryOfOrigin;
    private String registrationId;
    private String registrationNumber;
    private String legalTerm;
    private String taxation;
    private String taxIdentifier;
    private String taxNumber;
    private boolean tdsComplaint;
    private String msmeName;
    private String msmeEndDate;
    private String msmeCommunicationDate;
    private String msmeEnterpriseType;
    private String companyStatus;
    private String msmeNumber;
    private String msmeStartDate;
    private String onboardingFlow;
    private boolean enabled;
    private boolean tcsCompliant;
    private String leiNumber;
    private String leiExpiryDate;

}
