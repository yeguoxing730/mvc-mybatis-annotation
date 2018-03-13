package com.mvc.controllers;

import com.mvc.vo.Return;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Default Controller
 */
@Controller
public class DefaultController extends BaseController {

    /**
     * 版本检查
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Return get( ) {
        return processRequest("2018-03-09" ,0);
    }

    @ResponseBody
    @RequestMapping(value = "/error", method = RequestMethod.POST)
    public Return getException( ) throws Exception {
       throw new Exception("test");
    }
}
