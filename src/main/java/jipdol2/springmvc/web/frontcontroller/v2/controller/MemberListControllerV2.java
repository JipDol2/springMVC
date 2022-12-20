package jipdol2.springmvc.web.frontcontroller.v2.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jipdol2.springmvc.domain.member.Member;
import jipdol2.springmvc.domain.member.MemberRepository;
import jipdol2.springmvc.web.frontcontroller.MyView;
import jipdol2.springmvc.web.frontcontroller.v2.ControllerV2;

import java.io.IOException;
import java.util.List;

public class MemberListControllerV2 implements ControllerV2 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();
        request.setAttribute("members",members);

        return new MyView("/WEB-INF/views/members.jsp")   ;
    }
}
