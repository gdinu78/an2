package com.social.repository;

import com.social.model.SuppliersDetails;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SupplierRepository extends JpaRepository<SuppliersDetails, Long> {

}
