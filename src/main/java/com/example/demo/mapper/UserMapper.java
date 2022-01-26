package com.example.demo.mapper;

import com.example.demo.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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

}
