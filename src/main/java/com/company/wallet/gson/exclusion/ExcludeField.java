package com.company.wallet.gson.exclusion;

import com.company.wallet.entities.Transaction;
import com.company.wallet.entities.Wallet;

public class ExcludeField {
    public static final String EXCLUDE_WALLET = Transaction.class.getCanonicalName()+ ".wallet";
    public static final String EXCLUDE_TRANSACTIONS = Wallet.class.getCanonicalName() + ".transactions";

}
