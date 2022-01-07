package chuansen.zhan.controller;

import chuansen.zhan.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberFeignController {

    @Autowired
    private MemberService memberService;


    @GetMapping("/getMemberInfo")
    public ResponseEntity getMemberInfo() {
        return ResponseEntity.ok(memberService.getMemberInfo());
    }
}
