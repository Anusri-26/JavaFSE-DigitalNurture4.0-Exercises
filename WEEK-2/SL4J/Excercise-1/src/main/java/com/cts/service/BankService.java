package com.cts.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.model.BankAccount;

public class BankService {
    private static final Logger logger = LoggerFactory.getLogger(BankService.class);

    public void transfer(BankAccount from, BankAccount to, double amount) {
        logger.info("Initiating transfer of ₹{} from {} to {}", amount, from.getAccountHolder(), to.getAccountHolder());

        if (amount > from.getBalance()) {
            logger.error("Transfer failed: Insufficient balance in {}'s account. Available: ₹{}", from.getAccountHolder(), from.getBalance());
            return;
        }

        if (from.getBalance() - amount < 1000) {
            logger.warn("Low balance alert for {} after transfer: ₹{}", from.getAccountHolder(), from.getBalance() - amount);
        }

        from.withdraw(amount);
        to.deposit(amount);

        logger.info("Transfer successful. {} new balance: ₹{}, {} new balance: ₹{}", 
                     from.getAccountHolder(), from.getBalance(),
                     to.getAccountHolder(), to.getBalance());
    }
}
