package com.social.web;

import com.social.helpers.RespHelper;
import com.social.model.SuppliersDetails;
import com.social.service.DataService;
import com.social.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/suppliers")
public class SuppliersController {
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    DataService dataService;
    @Autowired
    RespHelper respHelper;


    @RequestMapping(path="/search",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void signUp(@RequestBody SuppliersDetails supplier, HttpServletResponse resp) {
        List<SuppliersDetails> resList = dataService.getSuppliersByModel(supplier);
        Map result=new HashMap<String,Object>();
        resList.add(supplier);
        result.put("count",resList.size());
        result.put("results",resList);
        respHelper.sendOk(resp, result);
    }
}
