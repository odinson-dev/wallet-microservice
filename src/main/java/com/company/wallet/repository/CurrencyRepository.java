package com.company.wallet.repository;

import com.company.wallet.entities.Currency;
import com.company.wallet.exceptions.WalletException;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;


@Transactional(rollbackOn = WalletException.class)
public interface CurrencyRepository  extends JpaRepository<Currency, Integer> {
    Currency findByName(String name);
}