package com.example.demo.boarder.controller;

import com.example.demo.boarder.dto.RegisterDto;
import com.example.demo.boarder.service.BoarderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * packageName : com.example.demo.boarder.controller
 * fileName : boarderController
 * author : isbn8
 * date : 2022-02-02
 * description :
 * ===========================================================
 * DATE                  AUTHOR                  NOTE
 * -----------------------------------------------------------
 * 2022-02-02              isbn8             최초 생성
 */

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/boarder")
public class BoarderRestController {
    private final BoarderService boarderService;

    /**
     * 회원정보 등록
     * @param registerDto registerDto
     * @return String
     */
    @PostMapping(value = "/register")
    public String boarderRegister(RegisterDto registerDto) {
        log.info("[ UserController > registerUser 사용자 등록 요청 시작]");
        return boarderService.boarderRegister(registerDto);
    }

    /**
     * 회원정보 수정
     * @param registerDto registerDto
     * @return String
     */
    @PostMapping(value = "/update")
    public String boarderUpdate(RegisterDto registerDto) {
        log.info("[ UserController > registerUser 사용자 수정 요청 시작]");
        return boarderService.boarderUpdate(registerDto);
    }

    /**
     * 사용자 삭제 요청
     * @param seq seq
     * @return String
     */
    @PostMapping(value = "/delete")
    public String deleteBoarder(Long seq) {
        log.info("[ UserController > deleteUser 사용자 삭제 요청 시작]");
        return boarderService.deleteBoarder(seq);
    }
}