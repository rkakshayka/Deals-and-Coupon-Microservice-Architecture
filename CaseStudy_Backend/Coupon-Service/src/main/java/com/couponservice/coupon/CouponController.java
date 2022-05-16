package com.couponservice.coupon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.couponservice.coupon.Model.Coupon;
import com.couponservice.coupon.Service.SequenceGeneratorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@Tag(name = "Coupons", description = "The Coupons API")
@RequestMapping("/coupons")
public class CouponController {

    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    
    Logger logger = LoggerFactory.getLogger(CouponController.class);
    
    // To get all the Coupons> http://localhost:9001/coupons/list
    
    @GetMapping(value = "/list")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Request to get all Coupons")
    public List<Coupon> getAllCoupons(){
    	logger.info("logger info get all coupons");
		logger.trace("logger get all coupons activated");
    	logger.error("Error happend in get all coupons");
    	
        return couponRepository.findAll();
    }

    // To add a Coupon> http://localhost:9001/coupons/add
    
    @PostMapping(value = "/add")
    @Operation(summary = "Request to add a Coupon")
    @ResponseStatus(HttpStatus.CREATED)
    public String addCoupon(@RequestBody Coupon coupon){
    	
    	// Generate Sequence
    	coupon.setId(sequenceGeneratorService.getSequenceNumber(Coupon.SEQUENCE_NAME));
    	
    	logger.info("logger info addCoupon");
		logger.trace("logger addCoupon activated");
    	logger.error("Error happend in addCoupon");
    	
        couponRepository.save(coupon);
        return "coupon Added Succesfully";
    }
    
    // To delete a Coupon> http://localhost:9001/coupons/delete/{couponID}
    
    @DeleteMapping(value = "/delete/{couponID}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Request to delete a Coupon by Id")
    public String deleteProduct(@RequestBody Coupon coupon,@PathVariable String couponID) {
       System.out.println("Delete method called");
        logger.info("logger info deleteProduct");
	    logger.trace("logger deleteProduct activated");
   	    logger.error("Error happend in deleteProduct");
        
        couponRepository.deleteById(couponID);
        
        return "Deleted Successfully";
    }
    
    // To update a Coupon> http://localhost:9001/coupons/update/{couponID}
    
    @PutMapping(value = "/update/{couponID}")
    @Operation(summary = "Request to update a Coupon by Id")
    @ResponseStatus(HttpStatus.CREATED)
    public String updateCoupon(@RequestBody Coupon coupon, @PathVariable String couponID){
    	logger.info("logger info updateCoupon");
		logger.trace("logger updateCoupon activated");
    	logger.error("Error happend in updateCoupon");
    	
        couponRepository.save(coupon);
        return "coupon Updated Succesfully";
    }
}
