package com.atguigu.schedule.pojo;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * ClassName:SysUser
 * Description:
 *
 * @Author Zack
 * @Create 2025/9/18 0:26
 * @Version 1.0
 */

/*
* 1 实体类的类名和表格名称对应（不是一致）
* 2 实体类的属性名和表格的列名应该对应
* 3 每个属性都必须私有的
* 4 每个属性都应该具备getter setter
* 5 必须具备无参构造器
* 6 应该实现序列化接口(缓存 分布式项目数据传递 可能将对象序列化)
* 7 应该重写类的hashcode和equals方法
* 8 toString是否重写都可以
*
* 使用Lombok帮助我们生成这些内容 getter setter 全参构造 无参构造 equals hashcode
*   Lombok使用步骤
*       1   检查idea是否已经安装了Lombok插件
*       2   检查是否勾选了enable annotation processer
*       3   导入lombok的依赖，在实体类上添加注解
* */
@AllArgsConstructor //添加了全参构造
@NoArgsConstructor //添加了无参构造
@Data//getter setter equals hashcode toString
public class SysUser implements Serializable {
    private Integer uid;
    private String username;
    private String userPwd;




}
