package com.testing;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by on 01.02.16.
 *
 * @author David Steiman
 */
@RestController
@RequestMapping("/foo")
public class WebController {

    @RequestMapping(method = RequestMethod.GET)
    public String readFoo() {
        return "read foo " + UUID.randomUUID().toString();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String writeFoo() {
        return "write foo " + UUID.randomUUID().toString();
    }
}
