package com.example.demo.boarder.controller;

import com.example.demo.boarder.service.BoarderService;
import com.example.demo.boarder.dto.RegisterDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/boarder")
public class BoarderController {
    private final BoarderService boarderService;

    @GetMapping(value = "/list")
    public ModelAndView boarderListPage(ModelAndView mv){
        log.info("[ boarderController > boarderListPage 게시판 페이지 이동 요청]");
        mv.addObject("userList",boarderService.findAll());
        mv.setViewName("/boarder/boarderList");
        return mv;
    }


    @GetMapping(value = "/register/page")
    public ModelAndView boarderRegisterPage(ModelAndView mv){
        log.info("[ boarderController > boarderRegisterPage 게시판 등록 페이지 이동 요청]");
        mv.setViewName("/boarder/boarderRegister");
        return mv;
    }

    /**
     * 회원정보 등록  ( DTO 로 요청 받는 경우 )
     * 현재는 postman 과같은 툴을 이용해서만 테스트 가능
     * @param registerDto registerDto
     * @param mv mv
     * @return ModelAndView
     */
    @PostMapping(value = "/register/save")
    public ModelAndView boarderRegister(RegisterDto registerDto, ModelAndView mv) {
        log.info("[ UserController > registerUser 사용자 등록 요청 시작]");

        // 사용자 등록 business 로직 실행 후 결과 바로 받아 모델에 담는다.
        mv.addObject("userList",boarderService.boarderRegister(registerDto));
        mv.setViewName("redirect:/boarder/list");
        return mv;
    }


    /**
     * 사용자 삭제 요청
     * @param mv mv
     * @param seq seq
     * @return ModelAndView
     */
    @PostMapping(value = "/delete")
    public ModelAndView deleteBoarder(ModelAndView mv, Long seq) {
        log.info("[ UserController > deleteUser 사용자 삭제 요청 시작]");

        // 사용자 삭제 business 로직 실행 후 결과 바로 받아 모델에 담는다.
        mv.addObject("userList",boarderService.deleteBoarder(seq));
        mv.setViewName("redirect:/boarder/list");
        return mv;
    }
}