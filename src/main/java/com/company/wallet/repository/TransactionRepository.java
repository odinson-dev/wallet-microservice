package com.company.wallet.repository;

import com.company.wallet.entities.Transaction;
import com.company.wallet.entities.Wallet;
import com.company.wallet.exceptions.WalletException;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional(rollbackOn = WalletException.class)
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findByWallet(Wallet wallet);
    Transaction findByGlobalId(String globalId);
}
