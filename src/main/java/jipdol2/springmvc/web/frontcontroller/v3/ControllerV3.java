package jipdol2.springmvc.web.frontcontroller.v3;

import jipdol2.springmvc.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {
    ModelView process(Map<String,String> paramMap);
}
