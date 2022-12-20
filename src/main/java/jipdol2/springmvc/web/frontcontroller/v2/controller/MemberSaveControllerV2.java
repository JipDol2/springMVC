package jipdol2.springmvc.web.frontcontroller.v2.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jipdol2.springmvc.domain.member.Member;
import jipdol2.springmvc.domain.member.MemberRepository;
import jipdol2.springmvc.web.frontcontroller.MyView;
import jipdol2.springmvc.web.frontcontroller.v2.ControllerV2;

import java.io.IOException;

public class MemberSaveControllerV2 implements ControllerV2 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        Integer age = Integer.parseInt(request.getParameter("age"));

        Member member =new Member(username,age);
        memberRepository.save(member);

        request.setAttribute("member",member);

        return new MyView( "/WEB-INF/views/save.jsp");
    }
}
