package org.example.adapterlayerpoc.controller;

import org.example.adapterlayerpoc.dto.PmParty;
import org.example.adapterlayerpoc.dto.PmPartyResp;
import org.example.adapterlayerpoc.dto.PmRelationship;
import org.example.adapterlayerpoc.dto.PmRelationshipResp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pm")
public class PmController {
    @PostMapping("/create")
    public String createParty() {
        System.out.println("Party created");
        return "Party created";
    }

   /* @GetMapping("/createParty")
    public void createParty1(@RequestBody PmParty pmParty) {
        System.out.println(pmParty.getName());
        System.out.println("Party created in pm");
    }*/

    @PostMapping("/createParty")
    public ResponseEntity<PmPartyResp> createParty1(@RequestBody PmParty pmParty) {
        System.out.println(pmParty.getName());
        System.out.println("Party created in pm");
        PmPartyResp response = PmPartyResp.builder()
                .refId("randomRefId")
                .requestId("randomRequestId")
                .version(1)
                .error("No error")
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/createRelationship")
    public ResponseEntity<PmRelationshipResp> createRealtionship(@RequestBody PmRelationship pmParty) {
        System.out.println("Relationship created in pm");
        PmRelationshipResp response = PmRelationshipResp.builder()
                .refId("randomRefId")
                .requestId("randomRequestId")
                .version(1)
                .error("No error")
                .build();
        return ResponseEntity.ok(response);
    }


}
