package com.atguigu.schedule.test;

import com.atguigu.schedule.dao.SysScheduleDao;
import com.atguigu.schedule.dao.impl.SysScheduleDaoImpl;
import com.atguigu.schedule.pojo.SysSchedule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * ClassName:TestSysScheduleDao
 * Description:
 *
 * @Author Zack
 * @Create 2025/9/18 2:24
 * @Version 1.0
 */
public class TestSysScheduleDao {

    private static SysScheduleDao scheduleDao;

    @BeforeAll
    public static void initScheduleDao(){
        scheduleDao = new SysScheduleDaoImpl();
    }

    @Test
    public void testAddSchedule() {
        int rows = scheduleDao.addSchedule(new SysSchedule(null,2,"学习数据库",1));
        System.out.println(rows);
    }

    @Test
    public void testFindAll(){
        List<SysSchedule> scheduleList = scheduleDao.findALl();
        scheduleList.forEach(System.out::println);
    }
}
