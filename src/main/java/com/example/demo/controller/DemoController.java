package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.service.DemoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


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


    /**
     * 사용자 등록 페이지 이동
     * @param mv mv
     * @return ModelAndView
     */
    @GetMapping(value = "/")
    public ModelAndView requestPage(ModelAndView mv){
        log.info("[ DemoController > requestPage 사용자 등록 페이지 이동 요청]");
        mv.setViewName("index.html");
        return mv;
    }




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

    @GetMapping(value = "/findUser")
    public ModelAndView findUser(ModelAndView mv, Long seq){

        UserDto userDto = demoService.findUser(seq);

        log.info("seq : {} , email : {}, passwd: {}, create_at {} ",
                userDto.getSeq(), userDto.getEmail(), userDto.getPasswd(), userDto.getCreate_at());

        mv.addObject("email", userDto.getEmail());
        mv.addObject("passwd", userDto.getPasswd());
        mv.setViewName("test4.html");
        return mv;
    }


}