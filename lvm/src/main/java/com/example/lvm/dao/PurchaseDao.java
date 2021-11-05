
package com.example.lvm.dao;

import com.example.lvm.po.Purchase;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PurchaseDao
{

    public abstract int upDataState(int i, int j);

    public abstract List selectstateAll();

    public abstract Purchase selectidAll(int i);

    public abstract Purchase selectnameAll(String s);

    public abstract int deletePurchase(int i);

    public abstract List selectAll();

    public abstract int addPurchase(Purchase purchase);
}
