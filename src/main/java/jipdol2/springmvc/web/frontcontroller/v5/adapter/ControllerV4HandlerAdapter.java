package jipdol2.springmvc.web.frontcontroller.v5.adapter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jipdol2.springmvc.web.frontcontroller.ModelView;
import jipdol2.springmvc.web.frontcontroller.v4.ControllerV4;
import jipdol2.springmvc.web.frontcontroller.v5.MyHandlerAdapter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV4HandlerAdapter implements MyHandlerAdapter {

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV4);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        ControllerV4 controller = (ControllerV4) handler;

        Map<String,String> paramMap = createParamMap(request);
        Map<String,Object> model = new HashMap<>();

        String viewName = controller.process(paramMap, model);

        //원래는 viewName을 return 시켜야되는데 형식이 맞지 않는다.
        //여기서 Adapter 의 역할을 수행
        //ModelView 를 생성해서 return
        ModelView mv = new ModelView(viewName);
        mv.setModel(model);

        return mv;
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String,String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName->paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
