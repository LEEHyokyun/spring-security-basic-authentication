package spring.security.basic.authentication.auth.users.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring.security.basic.authentication.auth.users.domain.entity.Account;
import spring.security.basic.authentication.auth.users.domain.vo.UserInfomation;
import spring.security.basic.authentication.auth.users.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    //회원가입
    @PostMapping("/signup")
    public Account signup(@RequestBody UserInfomation userInfomation){
        ModelMapper modelMapper = new ModelMapper();
        Account account =  modelMapper.map(userInfomation, Account.class);
        account.setPassword(passwordEncoder.encode(userInfomation.getPassword()));

        userService.signUp(account);

        return account;
    }
}
