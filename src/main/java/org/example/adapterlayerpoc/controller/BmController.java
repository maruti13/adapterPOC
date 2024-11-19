package org.example.adapterlayerpoc.controller;

import org.example.adapterlayerpoc.constants.ApiName;
import org.example.adapterlayerpoc.dto.BmParty;
import org.example.adapterlayerpoc.dto.BmRelationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.adapterlayerpoc.service.PartyMasterService;

import java.util.Map;

@RestController
@RequestMapping("/bm")
public class BmController {

    @Autowired
    PartyMasterService partyMasterService;

    @GetMapping("/getParty")
    public ResponseEntity<?> getParty(
            //@PathVariable String partyId,
            @RequestParam Map<String, String> queryParams,
            @RequestHeader Map<String, String> headers,
            @RequestBody BmParty requestBody) {
        try {
            Map<String, String> pathParams = Map.of("partyId", "party1"); // Include partyId in pathParams
            return partyMasterService.processApiRequest(ApiName.CREATE_PARTY, pathParams, queryParams, headers, requestBody);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/getRelationship")
    public ResponseEntity<?> getRelationship(
            //@PathVariable String partyId,
            @RequestParam Map<String, String> queryParams,
            @RequestHeader Map<String, String> headers,
            @RequestBody BmRelationship requestBody) {
        try {
            Map<String, String> pathParams = Map.of("partyId", "party1"); // Include partyId in pathParams
            return partyMasterService.processApiRequest(ApiName.CREATE_RELATIONSHIP, pathParams, queryParams, headers, requestBody);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/gm")
    public void getme(){
        System.out.println("Hello");
    }

//   @PostMapping("/bm/party")
//    public String createParty(BmParty bmParty) throws Exception {
//       System.out.println("Party created");
//       Map<String, Object> bmPartyMap = new HashMap<>();
//       for (Field field : BmParty.class.getDeclaredFields()) {
//           field.setAccessible(true);
//           try {
//               bmPartyMap.put(field.getName(), field.get(bmParty));
//           } catch (IllegalAccessException e) {
//               e.printStackTrace();
//           }
//       }
//
//       adapterLayer.processRequest("createOrUpdateParty", bmPartyMap);        return "Party created";
//    }



}
