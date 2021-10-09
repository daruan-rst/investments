package com.bank.investments.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Investment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name  = "investment" )
    private int InvestmentId;

    private BigDecimal investmentAmmount;
    private String accountId;

    @Enumerated(EnumType.STRING)
    private InvestmentStatus status;


}
