package com.example.demo.boarder.service;

import com.example.demo.boarder.mapper.BoarderMapper;
import com.example.demo.boarder.dto.RegisterDto;
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
    public String boarderRegister(RegisterDto registerDto) {
        // 결과 문구 default 값 설정
        String registerResult = "회원 등록 실패";

        // 성공일 경우 결과 문구 변경
        try {
            if (boarderMapper.boarderRegister(registerDto) > 0) {
                registerResult = "회원 등록 성공";
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        log.info("[ UserService > registerUser Result: {}]", registerResult);
        return registerResult;
    }

    /**
     * 회원정보 수정, 결과 문구 리턴 ( json 으로 받는 경우)
     * @param registerDto registerDto
     * @return String
     */
    public String boarderUpdate(RegisterDto registerDto) {
        // 결과 문구 default 값 설정
        String updateResult = "회원 수정 실패";

        // 성공일 경우 결과 문구 변경
        try {
            if (boarderMapper.boarderUpdate(registerDto) > 0) {
                updateResult = "회원 수정 성공";
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        log.info("[ UserService > registerUser Result: {}]", updateResult);
        return updateResult;
    }


    /**
     * 사용자 전체 리스트 요청
     * @return List<RegisterDto>
     */
    public List<RegisterDto> findAll() {
        return boarderMapper.findAll();
    }

    /**
     * seq에 해당하는 사용자 조회
     * @return RegisterDto
     */
    public RegisterDto findBySeq(Long seq) {
        return boarderMapper.findBySeq(seq);
    }


    /**
     * 회원 삭제 요청 처리
     * @param seq seq
     * @return String
     */
    public String deleteBoarder(Long seq) {
        // 결과 문구 default 값 설정
        String registerResult = "회원 삭제 실패";
        // 성공일 경우 결과 문구 변경
        if ( boarderMapper. deleteBoarder(seq) > 0) {
            registerResult = "회원 삭제 성공";
        }

        log.info("[ UserService > deleteUser Result: {}]", registerResult);
        return registerResult;
    }
}
