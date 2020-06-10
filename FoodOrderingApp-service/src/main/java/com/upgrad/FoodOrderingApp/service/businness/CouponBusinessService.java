package com.upgrad.FoodOrderingApp.service.businness;

import com.upgrad.FoodOrderingApp.service.dao.CouponDao;
import com.upgrad.FoodOrderingApp.service.entity.CouponEntity;
import com.upgrad.FoodOrderingApp.service.entity.CustomerAuthEntity;
import com.upgrad.FoodOrderingApp.service.exception.AuthorizationFailedException;
import com.upgrad.FoodOrderingApp.service.exception.CouponNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CouponBusinessService {
    @Autowired
    CouponDao couponDao;

    public CouponEntity getCouponByCouponName(String couponName) throws CouponNotFoundException {
        return couponDao.getCouponByName(couponName);
    }

    public CustomerAuthEntity getCustomerByAccessToken(String access_token) throws AuthorizationFailedException {
        return couponDao.getCustomerByAccessToken(access_token);
    }

    public CouponEntity getCouponByUUID(String uuid) throws CouponNotFoundException {
        return couponDao.getCouponByUUID(uuid);
    }
}
