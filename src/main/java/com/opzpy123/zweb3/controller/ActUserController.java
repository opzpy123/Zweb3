package com.opzpy123.zweb3.controller;

import com.opzpy123.zweb3.vo.resp.R;
import com.opzpy123.zweb3.vo.req.StringReq;
import com.opzpy123.zweb3.model.ActUser;
import com.opzpy123.zweb3.service.ActUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class ActUserController {
    @Autowired
    protected ActUserService actUserService;

    @PostMapping("findByName")
    public R<ActUser> findByName(@RequestBody StringReq req) {
        ActUser actUser = actUserService.findByUsername(req.getValue());
        return R.success(actUser);
    }
}
