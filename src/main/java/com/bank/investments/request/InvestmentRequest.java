package com.bank.investments.request;

import com.bank.investments.domain.Investment;
import com.bank.investments.domain.InvestmentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
public class InvestmentRequest {

    private BigDecimal investmentAmmount;
    private String accountId;

    public Investment convert(InvestmentStatus status){
        return new Investment(0, this.investmentAmmount, this.accountId, status);
    }


}
