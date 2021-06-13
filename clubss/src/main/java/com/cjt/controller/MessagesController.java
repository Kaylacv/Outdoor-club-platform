package com.cjt.controller;


import com.cjt.entity.Messages;
import com.cjt.service.IMessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2021-03-18
 */
@RestController
@RequestMapping("/cjt/messages")
public class MessagesController {

    @Autowired
    private IMessagesService messagesService;

    @RequestMapping("managerGet")
    public Object managerGet(Messages messages){
        return messagesService.managerGet(messages);
    }
}
