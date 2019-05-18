package com.example.demo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api("用户信息管理")  // 描述接口的类型
@RestController
@RequestMapping("/users")
public class UserController {

    private final static List<User> userList = new ArrayList<>();

    {   // 添加数据
        userList.add(new User("1", "admin", "123456"));
        userList.add(new User("2", "jacks", "111111"));
    }

    @ApiOperation("获取列表")  // 描述方法的用途
    @GetMapping("list")
    public List userList() {
        return userList;
    }

    @ApiOperation("新增用户")
    @PostMapping("save")
    public boolean save(User user) {
        return userList.add(user);
    }

    @ApiOperation("更新用户")
    @ApiImplicitParam(name = "user", value = "单个用户信息", dataType = "User")  // 描述方法的参数
    @PutMapping("update")
    public boolean update(User user) {
        return userList.remove(user) && userList.add(user);
    }

    @ApiOperation("批量删除")
    @ApiImplicitParam(name = "users", value = "N个用户信息", dataType = "List<User>") //  @apiImplicitParam 描述方法的参数(Multi-Params)
    @DeleteMapping("delete")
    public boolean delete(@RequestBody List<User> users) {
        return userList.removeAll(users);
    }


}