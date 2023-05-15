package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    // 의존 관계가 실행중에 동적으로 변하는 경우는 거의 없으므로 생성자 주입 권장(필드 주입, setter 주입, 생성자 주입)
    // `Autowired`를 통한 DI는 스프링이 관리하는 객체에서만 동작한다.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
