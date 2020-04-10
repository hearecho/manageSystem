package com.echo.controller;

import com.echo.entity.User;
import com.echo.response.R;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author hearecho
 * @createtime 2020/3/30 15:33
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class MainController {
    HashMap<String,String> storeToken = new HashMap<>();

    @PostMapping("/login")
    public R login(@RequestBody User u) {
        String token = DigestUtils.md5DigestAsHex(u.getPassword().getBytes());
        if ("admin".equals(u.getUsername()) && "123456".equals(u.getPassword())) {
            storeToken.put(u.getUsername(), token);
            return R.ok().data("token",token,1);
        }
        return R.ok().data("token",token,1);
    }

}
