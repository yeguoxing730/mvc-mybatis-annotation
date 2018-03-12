package com.mvc.controllers;


import com.mvc.vo.Return;

/**
 * 基础控制器
 */
public class BaseController {
    /**
     * @param object
     * @param returnCode
     * @return
     */
    public Return processRequest(Object object, int returnCode) {
        Return item = new Return();
        item.setReturncode(returnCode);
        item.setMessage("msg");

        if (returnCode <= 0) {
            item.setResult(object);
        }
        return item;
    }

    protected Return returnNull(int returnCode) {
        return processRequest(null, returnCode);
    }
}
