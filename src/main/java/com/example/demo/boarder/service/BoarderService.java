package com.example.demo.boarder.service;

import com.example.demo.boarder.mapper.BoarderMapper;
import com.example.demo.boarder.dto.RegisterDto;
import com.example.demo.boarder.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName : com.example.demo.boarder.service
 * fileName : BoarderService
 * author : isbn8
 * date : 2022-02-02
 * description :
 * ===========================================================
 * DATE                  AUTHOR                  NOTE
 * -----------------------------------------------------------
 * 2022-02-02              isbn8             최초 생성
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class BoarderService {

    private final BoarderMapper boarderMapper;

    /**
     * 회원정보 등록, 결과 문구 리턴 ( json 으로 받는 경우)
     * @param registerDto registerDto
     * @return String
     */
    public List<UserDto> boarderRegister(RegisterDto registerDto) {
        // 사용자 정보 insert
        int result = boarderMapper.boarderRegister(registerDto);
        // 결과 문구 default 값 설정
        String registerResult = "회원 등록 실패";

        // 성공일 경우 결과 문구 변경
        if (result > 0) {
            registerResult = "회원 등록 성공";
            log.info("[ UserService > registerUser 사용자 등록 요청 성공]");
        }

        return boarderMapper.findAll();
    }

    /**
     * 사용자 전체 리스트 쵸청
     * @return List<UserDto>
     */
    public List<UserDto> findAll() {
        return boarderMapper.findAll();
    }

    /**
     * 회원 삭제 요청 처리
     * @param seq seq
     * @return String
     */
    public List<UserDto> deleteBoarder(Long seq) {
        // 사용자 정보 insert
        int result = boarderMapper. deleteBoarder(seq);
        // 결과 문구 default 값 설정
        String registerResult = "회원 삭제 실패";

        // 성공일 경우 결과 문구 변경
        if (result > 0) {
            registerResult = "회원 삭제 성공";
            log.info("[ UserService > deleteUser 사용자 삭제 요청 성공]");
        }

        return boarderMapper.findAll();
    }
}
