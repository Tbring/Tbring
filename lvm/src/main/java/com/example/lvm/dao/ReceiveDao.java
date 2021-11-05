
package com.example.lvm.dao;

import com.example.lvm.po.Receive;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ReceiveDao
{

    public abstract List selectreceiveAll();

    public abstract Receive selectreceiveidAll(int i);

    public abstract List selectreceivestateAll(int i);

    public abstract int deleteReceive(int i);

    public abstract int upReceiveState(int i, int j);

    public abstract int addReceive(Receive receive);
}
