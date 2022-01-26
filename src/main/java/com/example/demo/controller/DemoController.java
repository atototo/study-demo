package com.example.demo.controller;

import com.example.demo.service.DemoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;


/**
 * packageName : com.example.demo.controller
 * fileName : DemoController
 * author : isbn8
 * date : 2022-01-26
 * description :
 * ===========================================================
 * DATE                  AUTHOR                  NOTE
 * -----------------------------------------------------------
 * 2022-01-26              isbn8             최초 생성
 */


@Controller
@Slf4j
@RequiredArgsConstructor
public class DemoController {

    private final DemoService demoService;


    @GetMapping(value = "/findName")
    public ModelAndView findName(ModelAndView mv, String id){
        log.info("?????????????????????123");

        String name = demoService.idToName(id);

        log.info("name:::{}", name);

        mv.addObject("id", id);
        mv.addObject("name", name);
        mv.setViewName("test.html");
        return mv;
    }

    @GetMapping(value = "/")
    public ModelAndView find(ModelAndView mv){
        log.info("?????????????????????123");
         demoService.connectionTest();
        mv.addObject("name", "name");
        mv.setViewName("test.html");
        return mv;
    }

    @RequestMapping(value = "/demo" , method = RequestMethod.GET)
    public ModelAndView demo(ModelAndView mv, String id){

        // 네임 찾기
        String name = demoService.idToName(id);

        // 네임이 소속된 스터디 그룹 찾기
        String sc = demoService.findService(name);

        mv.addObject("sc", sc);
        mv.setViewName("test2.html");
        return mv;
    }

    @RequestMapping(value = "/PostDemo" , method = RequestMethod.POST)
    public ModelAndView postDemo(ModelAndView mv, String id){

        // 네임 찾기
//        String name = demoService.idToName(id);
//
//        // 네임이 소속된 스터디 그룹 찾기
//        String sc = demoService.findService(name);
        demoService.connectionTest();

        mv.addObject("msg", "post 전송 성공");
        mv.setViewName("test3.html");
        return mv;
    }


}