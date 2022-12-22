package jipdol2.springmvc.web.frontcontroller.v3.controller;

import jipdol2.springmvc.domain.member.Member;
import jipdol2.springmvc.domain.member.MemberRepository;
import jipdol2.springmvc.web.frontcontroller.ModelView;
import jipdol2.springmvc.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public ModelView process(Map<String, String> paramMap) {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username,age);
        memberRepository.save(member);

        ModelView mv = new ModelView("save");
        mv.getModel().put("member",member);
        return mv;
    }
}
