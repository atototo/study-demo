package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import java.sql.Connection;

/**
 * packageName : com.example.demo.service
 * fileName : DemoService
 * author : isbn8
 * date : 2022-01-26
 * description :
 * ===========================================================
 * DATE                  AUTHOR                  NOTE
 * -----------------------------------------------------------
 * 2022-01-26              isbn8             최초 생성
 */

@Service
@Slf4j
@RequiredArgsConstructor
public class DemoService {

    private final SqlSessionFactory sqlSessionFactory;
    private final UserMapper userMapper;

    public String idToName(String id){

        String name = "";
        if(id.equals("liu")){
            name = "김연우";
        }else if(id.equals("2")){
            name = "뽀삐";
        }else{
            name = "밍키";
        }

        return name;
    }

    public String findService(String name){
        String service = "";
        if(name.equals("김연우")){
            service = "11";
        }else if(name.equals("뽀삐")){
            service = "22";
        }else{
            service = "33";
        }

        return service;
    }

    public void connectionTest(){
        try(Connection con = sqlSessionFactory.openSession().getConnection()){
            log.info("커넥션 성공");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public UserDto findUser(Long seq) {

        return userMapper.findById(seq);
    }


}
