package com.social.service;

import com.social.model.SuppliersDetails;
import org.springframework.context.annotation.Bean;

import java.util.List;


public interface DataService {

    List<SuppliersDetails> getSuppliersByModel(SuppliersDetails model);
}
