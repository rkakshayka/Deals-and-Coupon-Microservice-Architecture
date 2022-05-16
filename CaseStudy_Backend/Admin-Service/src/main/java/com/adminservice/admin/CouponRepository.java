package com.adminservice.admin;

import com.adminservice.admin.Model.Coupon;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CouponRepository extends MongoRepository<Coupon, String> {

    Coupon findProductById(String Id);

}
