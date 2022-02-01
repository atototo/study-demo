package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * packageName : com.example.demo.dto
 * fileName : RegisterDto
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
public class RegisterDto {
    private Long seq;
    private String email;
    private String passwd;
    private String nick_name;
}
