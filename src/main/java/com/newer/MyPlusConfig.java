package com.newer;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.incrementer.OracleKeyGenerator;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Administrator
 * @CopyRight(C), 2009-2023,牛耳教育有限公司
 * @FileName: MyPlusConfig
 * @projectName test_mybatisplus_oracle_0516
 * @description: TODO
 * @date 2023/5/189:45
 */
@Configuration
public class MyPlusConfig {

    /**
     * 新的分页插件,一缓和二缓遵循mybatis的规则,需要设置 MybatisConfiguration#useDeprecatedExecutor = false 避免缓存出现问题
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //PaginationInnerInterceptor->MyBatis-Plus提供分页工具-》IPage接口必须配置分页工具。
        //DbType.数据库管理系统名字和版本
        interceptor.addInnerInterceptor
                (new PaginationInnerInterceptor(DbType.ORACLE));
        return interceptor;
    }

    @Bean
    public OracleKeyGenerator oracleKeyGenerator(){

        return new OracleKeyGenerator();//必须提供Oracle主键增长发生器（Generator）

    }
}
