package com.scottapps.petshop.shared.service;

import com.scottapps.petshop.shared.dao.transaction.Transaction;
import org.jboss.logging.Logger;

import javax.inject.Inject;

public class AppTransactionService {
    @Inject
    Logger log;

    public void persist(Transaction transaction) {

    }
}
