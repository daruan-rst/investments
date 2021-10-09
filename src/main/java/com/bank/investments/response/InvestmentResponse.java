package com.bank.investments.response;

import com.bank.investments.domain.Investment;
import com.bank.investments.domain.InvestmentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class InvestmentResponse {

    private int InvestmentId;
    private BigDecimal investmentAmmount;
    private String accountId;
    private InvestmentStatus status;

    public InvestmentResponse(Investment inv){
        this.InvestmentId = inv.getInvestmentId();
        this.investmentAmmount = inv.getInvestmentAmmount();
        this.accountId = inv.getAccountId();
        this.status = inv.getStatus();
    }
}
