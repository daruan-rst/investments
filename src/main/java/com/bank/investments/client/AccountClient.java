package com.bank.investments.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(value ="account", url="http://localhost:7080/accounts")
public interface AccountClient {

    @RequestMapping(value="/find-by-account-id/", method= RequestMethod.GET)
    String findById(@RequestParam int accountId);

    @RequestMapping(value = "/update-money/{accountId}", method = RequestMethod.PUT)
    void updateMoney(@RequestParam int accountId, @RequestParam BigDecimal money);

}
