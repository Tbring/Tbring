
package com.example.lvm.dao;

import com.example.lvm.po.Audit;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AuditDao
{

    public abstract List selectauditAll();

    public abstract int addAudit(Audit audit);

    public abstract int deleteAudit(int i);
}
