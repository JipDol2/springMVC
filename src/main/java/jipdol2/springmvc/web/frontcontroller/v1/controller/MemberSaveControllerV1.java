package jipdol2.springmvc.web.frontcontroller.v1.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jipdol2.springmvc.domain.member.Member;
import jipdol2.springmvc.domain.member.MemberRepository;
import jipdol2.springmvc.web.frontcontroller.v1.ControllerV1;

import java.io.IOException;

public class MemberSaveControllerV1 implements ControllerV1 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        Integer age = Integer.parseInt(request.getParameter("age"));

        Member member =new Member(username,age);
        memberRepository.save(member);

        request.setAttribute("member",member);
        String viewPath = "/WEB-INF/views/save.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request,response);
    }
}
