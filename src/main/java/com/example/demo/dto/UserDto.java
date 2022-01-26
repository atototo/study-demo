package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;

/**
 * packageName : com.example.demo.dto
 * fileName : UserDto
 * author : isbn8
 * date : 2022-01-27
 * description :
 * ===========================================================
 * DATE                  AUTHOR                  NOTE
 * -----------------------------------------------------------
 * 2022-01-27              isbn8             최초 생성
 */

@Getter
@Setter
public class UserDto {

    private Long seq;
    private String email;
    private String passwd;
    private int login_count;
    private LocalDateTime last_login_at;
    private LocalDateTime create_at;

}
