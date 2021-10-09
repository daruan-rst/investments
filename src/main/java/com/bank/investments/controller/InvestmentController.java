package com.bank.investments.controller;

import com.bank.investments.domain.Investment;
import com.bank.investments.request.InvestmentRequest;
import com.bank.investments.response.InvestmentResponse;
import com.bank.investments.service.InvestmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/investments")
@AllArgsConstructor
public class InvestmentController {

    InvestmentService investmentService;

    @PostMapping("/new-investment")
    public ResponseEntity<InvestmentResponse> newInvestment(
        @RequestBody InvestmentRequest investmentRequest,
        UriComponentsBuilder uriComponentsBuilder
        ){
        Investment newInvestment = investmentService
                .createInvestment(investmentRequest);
        URI uri = uriComponentsBuilder.path("/investments/{id}")
                .buildAndExpand(newInvestment.getInvestmentId()).toUri();
        return ResponseEntity.created(uri).body(new InvestmentResponse(newInvestment));
    }

    @PutMapping("/receive-income")
    public ResponseEntity<InvestmentResponse> receiveIncome(
            @RequestParam int investmentId
    ){
      Investment closedInvestment = investmentService.receiveIncome(investmentId);
      return ResponseEntity.ok(new InvestmentResponse(closedInvestment));
    }
}
