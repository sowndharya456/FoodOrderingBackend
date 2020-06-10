package com.upgrad.FoodOrderingApp.service.dao;


import com.upgrad.FoodOrderingApp.service.entity.CouponEntity;
import com.upgrad.FoodOrderingApp.service.entity.CustomerAuthEntity;
import com.upgrad.FoodOrderingApp.service.exception.AuthorizationFailedException;
import com.upgrad.FoodOrderingApp.service.exception.CouponNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.UUID;

@Repository
public class CouponDao {

    @PersistenceContext
    EntityManager entityManager;

    public CustomerAuthEntity getCustomerByAccessToken(String accessToken) throws AuthorizationFailedException {
        try {
            return entityManager.createNamedQuery("getCustomerAuthToken", CustomerAuthEntity.class).setParameter("accessToken", accessToken).getSingleResult();
        } catch (NoResultException nre) {
            throw new AuthorizationFailedException("ATHR-001", nre.getMessage());
        }
    }

    public CouponEntity getCouponByName(String couponname) throws CouponNotFoundException {
        try {
            return entityManager.createNamedQuery("couponByname", CouponEntity.class).setParameter("couponName", couponname).getSingleResult();
        } catch (NoResultException nre) {
            throw new CouponNotFoundException("CPF-002", nre.getMessage());
        }
    }

    public CouponEntity getCouponByUUID (String uuid) throws CouponNotFoundException {
        try {
            return entityManager.createNamedQuery("getCouponByUUID", CouponEntity.class).setParameter("uuid", uuid).getSingleResult();
        } catch (NoResultException nre) {
            throw new CouponNotFoundException("CPF-002",nre.getMessage());
        }
    }
}
