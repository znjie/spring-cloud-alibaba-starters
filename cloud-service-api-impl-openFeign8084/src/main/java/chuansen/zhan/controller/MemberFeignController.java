package chuansen.zhan.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/memberImpl")
public class MemberFeignController {


    @GetMapping("/getMemberInfo")
    public ResponseEntity getMemberInfo() {
        return ResponseEntity.ok("成功远程调用具体实现的逻辑代码");
    }
}
