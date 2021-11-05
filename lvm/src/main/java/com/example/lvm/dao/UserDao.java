 

package com.example.lvm.dao;

import com.example.lvm.po.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserDao
{

    public abstract List selectAllUser();

    public abstract int upDataPassword(String s, String s1);

    public abstract List selectUser(int i);

    public abstract User selectUserNameUser(String s);

    public abstract String selectState(String s);

    public abstract int deleteuser(int i);

    public abstract int upDataState(String s, String s1);

    public abstract int upDataIpaddress(String s, String s1);

    public abstract int upDataPermissions(String s, int i);

    public abstract int upDataLoginTime(String s, String s1);

    public abstract int upData(User user);

    public abstract User selectPassWordUser(String s);

    public abstract int upDataAvatars(String s, String s1);

    public abstract int addUser(User user);
}
