package com.example.demo.service;

import com.example.demo.dto.RegisterDto;
import com.example.demo.dto.UserDto;
import com.example.demo.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName : com.example.demo.service
 * fileName : UserService
 * author : isbn8
 * date : 2022-01-27
 * description :
 * ===========================================================
 * DATE                  AUTHOR                  NOTE
 * -----------------------------------------------------------
 * 2022-01-27              isbn8             최초 생성
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserMapper userMapper;

    /**
     * 회원정보 등록, 결과 문구 리턴 ( json 으로 받는 경우)
     * @param registerDto registerDto
     * @return String
     */
    public String registerUser(RegisterDto registerDto) {
        // 사용자 정보 insert
        int result = userMapper.registerUser(registerDto);
        // 결과 문구 default 값 설정
        String registerResult = "회원 등록 실패";

        // 성공일 경우 결과 문구 변경
        if (result > 0) {
            registerResult = "회원 등록 성공";
            log.info("[ UserService > registerUser 사용자 등록 요청 성공]");
        }

        return registerResult;
    }


    /**
     * 회원정보 등록, 결과 문구 리턴 (form 형식으로 받는 경우)
     * @param email email
     * @param passwd passwd
     * @return String
     */
    public String createUser(String email, String passwd) {
        // 사용자 정보 insert
        int result = userMapper. createUser(email, passwd);
        // 결과 문구 default 값 설정
        String registerResult = "회원 등록 실패";

        // 성공일 경우 결과 문구 변경
        if (result > 0) {
            registerResult = "회원 등록 성공";
            log.info("[ UserService > registerUser 사용자 등록 요청 성공]");
        }

        return registerResult;
    }

    /**
     * 사용자 전체 리스트 쵸청
     * @return List<UserDto>
     */
    public List<UserDto> findAll() {
        return userMapper.findAll();
    }

}
