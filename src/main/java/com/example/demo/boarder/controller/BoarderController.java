package com.example.demo.boarder.controller;

import com.example.demo.boarder.service.BoarderService;
import com.example.demo.dto.RegisterDto;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping(value = "/boarderList")
    public ModelAndView boarderListPage(ModelAndView mv){
        log.info("[ boarderController > boarderListPage 게시판 페이지 이동 요청]");
        mv.addObject("userList",boarderService.findAll());
        mv.setViewName("/boarder/boarderList.html");
        return mv;
    }


    @GetMapping(value = "/boarderList2")
    public ModelAndView boarderListPage2(ModelAndView mv){
        log.info("[ boarderController > boarderListPage 게시판 페이지 이동 요청]");
        mv.setViewName("/boarder/boarderList2.html");
        return mv;
    }

    @GetMapping(value = "/reqBoarderRegister")
    public ModelAndView boarderRegisterPage(ModelAndView mv){
        log.info("[ boarderController > boarderRegisterPage 게시판 등록 페이지 이동 요청]");
        mv.setViewName("/boarder/boarderRegister.html");
        return mv;
    }

    /**
     * 회원정보 등록  ( DTO 로 요청 받는 경우 )
     * 현재는 postman 과같은 툴을 이용해서만 테스트 가능
     * @param registerDto registerDto
     * @param mv mv
     * @return ModelAndView
     */
    @PostMapping(value = "/boarderRegister")
    public ModelAndView boarderRegister(RegisterDto registerDto, ModelAndView mv) {
        log.info("[ UserController > registerUser 사용자 등록 요청 시작]");

        // 사용자 등록 business 로직 실행 후 결과 바로 받아 모델에 담는다.
        mv.addObject("userList",boarderService.boarderRegister(registerDto));
        mv.setViewName("/boarder/boarderList.html");
        return mv;
    }
}
