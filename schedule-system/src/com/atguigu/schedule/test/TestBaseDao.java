package com.atguigu.schedule.test;

import com.atguigu.schedule.dao.BaseDao;
import com.atguigu.schedule.pojo.SysUser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * ClassName:TestBaseDao
 * Description:
 *
 * @Author Zack
 * @Create 2025/9/18 1:45
 * @Version 1.0
 */
public class TestBaseDao {
    private static BaseDao baseDao;

    @BeforeAll
    public static void initBaseDao(){
        baseDao=new BaseDao();
    }

    @Test
    public void testBaseQueryObject(){
        //查询用户数量 BaseQueryObject 查询结果集是单行单列的一个值的数据的方法
        String sql = "select count(1) from sys_user";
        Long count = baseDao.baseQueryObject(Long.class, sql);
        System.out.println(count);

    }

    @Test
    public void testBaseQuery(){
        String sql = "select uid,username,user_pwd userPwd from sys_user";
        List<SysUser> sysUserList = baseDao.baseQuery(SysUser.class, sql);
        sysUserList.forEach(System.out::println);
    }

    @Test
    public void testBaseUpdate(){
        String sql = "insert into sys_schedule values(DEFAULT,?,?,?)";
        int rows = baseDao.baseUpdate(sql,1,"学习Java",0);
        System.out.println(rows);
    }
}
