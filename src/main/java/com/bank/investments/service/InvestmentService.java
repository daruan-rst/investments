package com.bank.investments.service;

import com.bank.investments.client.AccountClient;
import com.bank.investments.domain.Investment;
import com.bank.investments.domain.InvestmentStatus;
import com.bank.investments.exceptions.InvalidAccountType;
import com.bank.investments.exceptions.NotSuchAccountException;
import com.bank.investments.repository.InvestmentRepository;
import com.bank.investments.request.InvestmentRequest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
@RequiredArgsConstructor
public class InvestmentService {

    private final InvestmentRepository investmentRepository;

    private final AccountClient accountClient;

    public Investment createInvestment(InvestmentRequest investmentRequest){
        String accountId = accountClient
                .findById(Integer.parseInt(investmentRequest
                        .getAccountId()));
            if (accountId.equals("NotSuchAccountException")){
                throw new NotSuchAccountException();
            }else if(accountId.equals("InvalidAccountType")){
                throw new InvalidAccountType();
            }else{
                BigDecimal money = investmentRequest.getInvestmentAmmount();
                accountClient.updateMoney(Integer.parseInt(accountId),money.negate());
                BigDecimal INCOME = new BigDecimal("1.02");
                investmentRequest
                        .setInvestmentAmmount(money
                        .multiply(INCOME));
                Investment thisInvestment = investmentRequest.convert(InvestmentStatus.OPENED);
                investmentRepository.save(thisInvestment);
        return thisInvestment;}
    }

    public Investment receiveIncome(int investmentId){
        Investment thisInvestment = investmentRepository.getById(investmentId);
        BigDecimal money = thisInvestment.getInvestmentAmmount();
        accountClient.updateMoney(Integer.parseInt(thisInvestment.getAccountId()),money);
        thisInvestment.setStatus(InvestmentStatus.CLOSED);
        investmentRepository.save(thisInvestment);
        return thisInvestment;}

}
