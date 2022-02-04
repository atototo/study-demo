package com.example.demo.boarder.mapper;

import com.example.demo.boarder.dto.RegisterDto;
import com.example.demo.boarder.dto.UserDto;
import org.apache.ibatis.annotations.*;

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

    @Select("SELECT * FROM users")
    List<UserDto> findAll();

    @Select("SELECT * FROM users WHERE seq = #{seq}")
    UserDto findBySeq(Long seq);

    @Insert("INSERT INTO users(email, passwd, nick_name, login_count, last_login_at, create_at, update_at) VALUES (#{email},#{passwd},#{nick_name},0,now(),now(),now())")
    int boarderRegister(RegisterDto registerDto);


    @Update("UPDATE users SET email = #{email}, passwd = #{passwd}, nick_name = #{nick_name}, update_at = now() WHERE seq = #{seq}")
    int boarderUpdate(RegisterDto registerDto);


    @Delete("DELETE FROM users WHERE seq = #{seq}")
    int deleteBoarder(Long seq);
}
