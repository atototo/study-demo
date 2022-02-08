package com.example.demo.boarder.controller;

import com.example.demo.boarder.service.BoarderService;
import com.example.demo.boarder.dto.RegisterDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
        mv.setViewName("/boarder/list");
        return mv;
    }


    @GetMapping(value = "/register")
    public ModelAndView boarderRegisterPage(ModelAndView mv){
        log.info("[ boarderController > boarderRegisterPage 게시판 등록 페이지 이동 요청]");
        mv.setViewName("/boarder/registerForm");
        return mv;
    }

    @GetMapping(value = "/update")
    public ModelAndView boarderUpdatePage(ModelAndView mv, Long seq){
        log.info("[ boarderController > boarderUpdatePage 게시판 수정 페이지 이동 요청], parameter [seq:{}]", seq);
        mv.addObject("user", boarderService.findBySeq(seq));
        mv.setViewName("/boarder/updateForm");
        return mv;
    }
}