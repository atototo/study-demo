package com.example.demo.boarder.mapper;

import com.example.demo.dto.RegisterDto;
import com.example.demo.dto.UserDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * packageName : com.example.demo.boarder.mapper
 * fileName : BoarderMapper
 * author : isbn8
 * date : 2022-02-02
 * description :
 * ===========================================================
 * DATE                  AUTHOR                  NOTE
 * -----------------------------------------------------------
 * 2022-02-02              isbn8             최초 생성
 */
@Mapper
public interface BoarderMapper {

    @Select("SELECT * FROM USERS")
    List<UserDto> findAll();

    @Insert("INSERT INTO users(email, passwd, nick_name, login_count, last_login_at, create_at, update_at) VALUES (#{email},#{passwd},#{nick_name},0,now(),now(),now())")
    int boarderRegister(RegisterDto registerDto);
}
