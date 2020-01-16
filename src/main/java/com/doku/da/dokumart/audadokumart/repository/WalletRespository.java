package com.doku.da.dokumart.audadokumart.repository;

import com.doku.da.dokumart.audadokumart.entity.payment.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRespository extends JpaRepository<Wallet, Integer> {
}
