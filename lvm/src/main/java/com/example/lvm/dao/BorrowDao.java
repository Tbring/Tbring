
package com.example.lvm.dao;

import com.example.lvm.po.Borrow;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BorrowDao
{

    public abstract List selectborrowAll();

    public abstract List selectborrowidAll(int i);

    public abstract int deleteBorrow(int i);

    public abstract int addBorrow(Borrow borrow);

    public abstract int upborrowNumber(int i, int j);
}
