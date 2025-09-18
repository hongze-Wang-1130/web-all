package com.atguigu.schedule.dao;

import com.atguigu.schedule.pojo.SysUser;

/**
 * ClassName:SysUserDao
 * Description:
 * Data access Object 数据访问对象
 * 该类中用于定义针对表格的CRUD的方法
 * DAO层需要定义接口和实现类
 * @Author Zack
 * @Create 2025/9/18 1:04
 * @Version 1.0
 */
public interface SysUserDao {

    /**
     * 向数据库中增加一条用户记录的方法
     * @param sysUser 要增加的记录的username 和 user_pwd字段以SysUser实体类对象的形式接收
     * @return 增加成功返回1 增加失败返回0
     */
    int addSysUser(SysUser sysUser);

    /**
     * 根据用户名获得完整用户信息的方法
     * @param username 要查询的用户名
     * @return 如果找到了返回SysUser对象，找不到返回null
     */
    SysUser findByUsername(String username);
}
