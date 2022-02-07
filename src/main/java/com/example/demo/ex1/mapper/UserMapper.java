package com.example.demo.ex1.mapper;

import com.example.demo.boarder.dto.RegisterDto;
import com.example.demo.ex1.dto.UserDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * packageName : com.example.demo.mapper
 * fileName : UserMapper
 * author : isbn8
 * date : 2022-01-27
 * description :
 * ===========================================================
 * DATE                  AUTHOR                  NOTE
 * -----------------------------------------------------------
 * 2022-01-27              isbn8             최초 생성
 */

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USERS")
    List<UserDto> findAll();

    @Select("SELECT * FROM USERS where seq = #{seq}")
    UserDto findById(Long seq);

    @Select("SELECT * FROM USERS where email = #{email}")
    UserDto findByEmail(String email);

    @Insert("INSERT INTO users(email, passwd, nick_name, login_count, last_login_at, create_at, update_at) VALUES (#{email},#{passwd},#{nick_name},0,now(),now(),now())")
    int registerUser(RegisterDto registerDto);

    @Insert("INSERT INTO users(email, passwd, nick_name, login_count,  last_login_at, create_at, update_at) VALUES (#{email},#{passwd}, #{nick_name}, 0,now(),now(),now())")
    int createUser(String email, String nick_name, String passwd);

    @Update("UPDATE users SET passwd=#{passwd}, nick_name=#{nick_name}, update_at=now() WHERE seq =#{seq}")
    int updateUser(RegisterDto registerDto);

    @Delete("DELETE FROM users WHERE seq = #{seq}")
    int deleteUser(Long seq);
}
