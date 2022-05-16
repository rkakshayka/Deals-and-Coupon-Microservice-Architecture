package com.couponservice.coupon;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.couponservice.coupon.Model.Coupon;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
class CouponApplicationTests {

    @MockBean
    CouponRepository couponRepository;

    @Autowired
    CouponController couponController;

    @Test
    public void getAllCouponsTest() {
        when(couponRepository.findAll())
        .thenReturn(
                Stream.of(new Coupon(1, "FLIPKART", "FLIP25", "Electronics", "25% Off","21-June-2022"))
        .collect(Collectors.toList())
        );
        
        assertEquals(1, couponController.getAllCoupons().size());
    }

    @Test
    public void addCouponTest() {
        Coupon coupon = new Coupon(1, "FLIPKART", "FLIP25", "Electronics", "25% Off","21-June-2022");
        when(couponRepository.save(coupon)).thenReturn(coupon);
        assertEquals(coupon, couponController.addCoupon(coupon));
    }

    @Test
    public void deleteDealTest() {

        String couponId = "1";

        Coupon coupon = new Coupon(1, "FLIPKART", "FLIP25", "Electronics", "25% Off","21-June-2022");
        couponRepository.deleteById(couponId);
        verify(couponRepository).deleteById(couponId);
        when(couponRepository.save(coupon)).thenReturn(coupon);
    }
}