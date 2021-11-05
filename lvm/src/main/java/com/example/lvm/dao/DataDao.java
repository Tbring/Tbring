
package com.example.lvm.dao;

import com.example.lvm.po.Data;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DataDao
{

    public abstract List selectdataAll();

    public abstract Data selectdataidAll(int i);

    public abstract int deleteData(int i);

    public abstract int addData(Data data);

    public abstract int upDataNumber(int i, int j);

    public abstract int upDataPrice(int i, double d);
}
