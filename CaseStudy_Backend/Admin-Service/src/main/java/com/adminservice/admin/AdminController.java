package com.adminservice.admin;

import com.couponservice.coupon.Model.Coupon;
//import com.couponservice.coupon.Service.SequenceGeneratorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Tag(name = "Admin", description = "The Admin API")
@RequestMapping("/admin")
public class AdminController {
	
	//Admin and Coupon Interaction using Rest Template without hardcoded urls.
	
    @Autowired
    RestTemplate restTemplate;
    
//    @Autowired
//    private SequenceGeneratorService sequenceGeneratorService;

    Logger logger = LoggerFactory.getLogger(AdminController.class);
    
    // To get all the Coupons> http://localhost:9005/admin/listCoupon
    
    @GetMapping(value = "/listCoupon")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Request to get all Coupons")
    public List<Coupon> getAllCoupons(){
    	logger.info("logger info get all coupons");
		logger.trace("logger get all coupons activated");
    	logger.error("Error happend in get all coupons");
    	
        return Arrays.asList(restTemplate.getForObject("http://coupons/coupons/list",Coupon[].class));
    }

    // To add a Coupon> http://localhost:9005/coupons/addCoupon
    
    @PostMapping(value = "/addCoupon")
    @Operation(summary = "Request to add Coupon")
    @ResponseStatus(HttpStatus.CREATED)
    public String addCoupon(@RequestBody Coupon coupon){
    	
//    	// Generate Sequence
//    	coupon.setId(sequenceGeneratorService.getSequenceNumber(Coupon.SEQUENCE_NAME));
    	
    	logger.info("logger info addCoupon");
		logger.trace("logger addCoupon activated");
    	logger.error("Error happend in addCoupon");
    	
        return restTemplate.postForObject("http://coupons/coupons/add",coupon,String.class);
    }

    // To delete a Coupon> http://localhost:9005/coupons/deleteCoupon/{couponID}
    
    @DeleteMapping(value = "/deleteCoupon/{couponID}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Request to delete a Coupon by Id")
    public String deleteProduct(@PathVariable String couponID) {
    	logger.info("logger info deleteCoupon");
		logger.trace("logger deleteCoupon activated");
    	logger.error("Error happend in deleteCoupon");
    	
        restTemplate.delete("http://coupons/coupons/delete/{couponID}", couponID, String.class);
        return "Deleted Successfully";
    }

    // To update a Coupon> http://localhost:9005/coupons/updateCoupon/{couponID}
    
    @PutMapping(value = "/updateCoupon/{couponID}")
    @Operation(summary = "Request to update Coupon by Id")
    @ResponseStatus(HttpStatus.CREATED)
    public String updateCoupon(@RequestBody Coupon coupon, @PathVariable String couponID){
    	logger.info("logger info updateCoupon");
		logger.trace("logger updateCoupon activated");
    	logger.error("Error happend in updateCoupon");
    	
        restTemplate.put("http://coupons/coupons/update/{couponID}",coupon,couponID,String.class);
        return "coupon Updated Succesfully";
    }

}
