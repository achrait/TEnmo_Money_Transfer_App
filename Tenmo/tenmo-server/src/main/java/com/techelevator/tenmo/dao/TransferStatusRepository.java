package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.TransferStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferStatusRepository extends JpaRepository <TransferStatus, Integer> {
    TransferStatus findById(int id);
}
