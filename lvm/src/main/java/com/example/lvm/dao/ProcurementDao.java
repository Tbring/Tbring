
package com.example.lvm.dao;

import com.example.lvm.po.Procurement;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProcurementDao
{

    public abstract List selectprocurementAll();

    public abstract int addProcurement(Procurement procurement);

    public abstract int deleteProcurement(int i);
}
