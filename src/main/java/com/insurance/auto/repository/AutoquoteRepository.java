/**
 * 
 */
package com.insurance.auto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.insurance.auto.entities.Autoquote;

/**
 * @author mrdee
 *
 */
public interface AutoquoteRepository extends JpaRepository<Autoquote, Integer> {

	@Query(value="SELECT * FROM auto_quote WHERE customer_mail_id=:customerMailId",nativeQuery = true)
	List<Autoquote> findByCustomerMail(@Param("customerMailId") String customerMailId);
	
	@Query(value="SELECT * FROM auto_quote WHERE reference_number=:referenceNumber",nativeQuery = true)
	List<Autoquote> findByReferenceNumber(@Param("referenceNumber") String referenceNumber);
	
	@Query(value="SELECT * FROM auto_quote WHERE id=:id",nativeQuery = true)
	List<Autoquote> findByQuoteId(@Param("id") String id);
}
