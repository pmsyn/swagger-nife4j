package com.pms.swaggerdemo.test.controller;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@Api(tags = "测试控制器说明")
@RestController
@RequestMapping(value = "/test")
public class TestController {
    /* 方法注解 */
    @ApiOperation("home方法说明")
    @GetMapping("/home")
    public String home() {
        return "返回值";
    }

    @ApiOperation("post方法说明")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="主键"),
            @ApiImplicitParam(name="name",value="名称")
    })
    @PostMapping("/post")
    public void post(@RequestParam String id,@RequestParam String name) {

    }
}
