package com.example.meituan.mapper;


import com.example.meituan.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM User WHERE id = #{id}")
    User findById(@Param("id") Long id);

    // 根据用户名查询用户
    @Select("SELECT * FROM User WHERE username = #{username}")
    User findByUsername(@Param("username") String username);
}