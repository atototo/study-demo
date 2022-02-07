package com.example.demo.boarder.mapper;

import com.example.demo.boarder.dto.RegisterDto;
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
    List<RegisterDto> findAll();

    @Select("SELECT * FROM users WHERE seq = #{seq}")
    RegisterDto findBySeq(Long seq);

    @Insert("INSERT INTO users(email, passwd, nick_name, login_count, last_login_at, create_at, update_at) VALUES (#{email},#{passwd},#{nickName},0,now(),now(),now())")
    int boarderRegister(RegisterDto registerDto);


    @Update("UPDATE users SET email = #{email}, passwd = #{passwd}, nick_name = #{nickName}, update_at = now() WHERE seq = #{seq}")
    int boarderUpdate(RegisterDto registerDto);


    @Delete("DELETE FROM users WHERE seq = #{seq}")
    int deleteBoarder(Long seq);
}
