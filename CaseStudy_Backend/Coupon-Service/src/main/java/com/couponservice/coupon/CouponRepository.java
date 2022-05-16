package com.couponservice.coupon;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.couponservice.coupon.Model.Coupon;

public interface CouponRepository extends MongoRepository<Coupon, String> {

    ///Coupon findProductById(String Id);

}
