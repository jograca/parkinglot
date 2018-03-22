package com.lm.claims.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lm.claims.models.Receipt;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Integer> {

	Receipt findById(int id);

}
