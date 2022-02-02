package com.example.demo.controller;

import com.example.demo.dto.RegisterDto;
import com.example.demo.service.DemoService;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * packageName : com.example.demo.controller
 * fileName : UserController
 * author : isbn8
 * date : 2022-01-27
 * description :
 * ===========================================================
 * DATE                  AUTHOR                  NOTE
 * -----------------------------------------------------------
 * 2022-01-27              isbn8             최초 생성
 */

@Controller
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final DemoService demoService;


    /**
     * 회원정보 등록  ( form 으로 요청 받는 경우 )
     * @param mv mv
     * @param email email
     * @param passwd passwd
     * @return ModelAndView
     */
    @PostMapping(value = "/createUser")
    public ModelAndView createUser(ModelAndView mv , String email, String nick_name, String passwd) {
        log.info("[ UserController > registerUser 사용자 등록 요청 시작]");

        // 사용자 등록 business 로직 실행 후 결과 바로 받아 모델에 담는다.
        mv.addObject("result",userService.createUser(email, nick_name, passwd));
        mv.setViewName("result.html");
        return mv;
    }

    /**
     * 회원정보 등록  ( DTO 로 요청 받는 경우 )
     * 현재는 postman 과같은 툴을 이용해서만 테스트 가능
     * @param registerDto registerDto
     * @param mv mv
     * @return ModelAndView
     */
    @PostMapping(value = "/registerUser")
    public ModelAndView registerUser(@RequestBody RegisterDto registerDto, ModelAndView mv) {
        log.info("[ UserController > registerUser 사용자 등록 요청 시작]");

        // 사용자 등록 business 로직 실행 후 결과 바로 받아 모델에 담는다.
        mv.addObject("result",userService.registerUser(registerDto));
        mv.setViewName("result.html");
        return mv;
    }


    /**
     * 사용자 리스트 요청
     * @param mv mv
     * @return ModelAndView
     */
    @GetMapping(value="/findAll")
    public ModelAndView findAll(ModelAndView mv) {
        log.info("[ UserController > findAll 사용자 리스트 요청 시작]");

        // 사용자 등록 business 로직 실행 후 결과 바로 받아 모델에 담는다.
        mv.addObject("userList",userService.findAll());
        mv.setViewName("/boarder/boarderList.html");

        return mv;
    }

    /**
     *  사용자 수정 페이지 요청
     * @param mv mv
     * @param seq seq
     * @return ModelAndView
     */
    @GetMapping(value="/reqUpdateUserInfo")
    public ModelAndView reqUpdateUserInfo(ModelAndView mv, Long seq) {
        log.info("[ UserController > reqUpdateUserInfo 사용자 정보 수정 페이지 요청 시작]");

        // 사용자 등록 business 로직 실행 후 결과 바로 받아 모델에 담는다.
        mv.addObject("user", demoService.findUser(seq));
        mv.setViewName("request.html");
        return mv;
    }

    /**
     *  사용자 정보 업데이트
     * @param registerDto registerDto
     * @param mv mv
     * @return ModelAndView
     */
    @PostMapping(value = "/updateUser")
    public ModelAndView updateUser(RegisterDto registerDto, ModelAndView mv) {
        log.info("[ UserController > updateUser 사용자 수정 요청 시작]");

        // 사용자 수정 business 로직 실행 후 결과 바로 받아 모델에 담는다.
        mv.addObject("result",userService.updateUser(registerDto));
        mv.setViewName("result.html");
        return mv;
    }

    /**
     * 사용자 삭제 요청
     * @param mv mv
     * @param seq seq
     * @return ModelAndView
     */
    @PostMapping(value = "/deleteUser")
    public ModelAndView deleteUser(ModelAndView mv, Long seq) {
        log.info("[ UserController > deleteUser 사용자 삭제 요청 시작]");

        // 사용자 삭제 business 로직 실행 후 결과 바로 받아 모델에 담는다.
        mv.addObject("result",userService.deleteUser(seq));
        mv.setViewName("result.html");
        return mv;
    }
}
