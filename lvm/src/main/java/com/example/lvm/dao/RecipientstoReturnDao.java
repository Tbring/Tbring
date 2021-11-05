
package com.example.lvm.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RecipientstoReturnDao
{

    public abstract List selectrecipientstoreturnAll();
}
