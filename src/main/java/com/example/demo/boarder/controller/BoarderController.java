package com.example.demo.boarder.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
public class BoarderController {

    @GetMapping(value = "/boarder")
    public ModelAndView boarderListPage(ModelAndView mv){
        log.info("[ boarderController > boarderListPage 게시판 페이지 이동 요청]");
        mv.setViewName("/boarder/boarderList.html");
        return mv;
    }
}
