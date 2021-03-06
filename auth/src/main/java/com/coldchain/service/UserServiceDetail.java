package com.coldchain.service;

import com.coldchain.entity.Admin;
import com.coldchain.entity.Seller;
import com.coldchain.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserServiceDetail implements UserDetailsService {

    @Autowired
    private AdminService adminService;

    @Autowired
    private SellerService sellerService;

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if (s.contains("{admin}")) {
            Admin admin = adminService.getByUsername(s.replace("{admin}", ""));
            if (admin == null) {
                throw new UsernameNotFoundException("管理员用户名：" + s.substring(7) + "不存在！");
            }
            return admin;
        } else if (s.contains("{seller}")) {
            Seller seller = sellerService.getOneBySellerName(s.replace("{seller}", ""));
            if (seller == null) {
                throw new UsernameNotFoundException("商家用户名：" + s.substring(8) + "不存在！");
            }
            seller.setPassword(userService.getById(seller.getUserId()).getPassword());
            return seller;
        } else if (s.contains("{mobile}")) {
            User user = userService.getOneByMobile(s.replace("{mobile}", ""));
            if (user == null) {
                throw new UsernameNotFoundException("账号：" + s + ",不存在！");
            }
            fixUserAuthorities(user);
            return user;
//        } else if (s.contains("{email}")) {
//            User user = userService.getOneByEmail(s.replace("{email}", ""));
//            if (user == null) {
//                throw new UsernameNotFoundException("邮箱：" + s + ",不存在！");
//            }
//            fixUserAuthorities(user);
//            return user;
        }
        return null;
    }

    public void fixUserAuthorities(User user) {
        Seller seller = sellerService.getOneByUserId(user.getUserId());
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        if (seller != null) authorities.add(new SimpleGrantedAuthority("ROLE_SELLER"));
        user.setAuthorities(authorities);
    }
}
