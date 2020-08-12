package com.ns.bank.security;

import com.ns.bank.entity.Customer;
import com.ns.bank.model.CustomerDetails;
import com.ns.bank.model.CustomerModel;
import com.ns.bank.model.MyUserDetails;
import com.ns.bank.model.UserModel;
import com.ns.bank.service.impl.CustomerService;
import com.ns.bank.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserService myUserDetailsService;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        System.out.println("inside provider");
        UsernamePasswordAuthenticationToken authenticationToken = null;
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        if (name.endsWith("cus")) {
            int length=name.length()-3;
          //  System.out.println("email"+name.substring(0,length));
            name= name.substring(0,length);
            //System.out.println("customermodel inside provider");
            System.out.println("inside if ..name"+name);
            CustomerModel customerModel = customerService.getCustomerByEmailAndPassword(name, password);
            CustomerDetails customerDetails=new CustomerDetails(customerModel);
            //System.out.println("customermodel inside provider"+customerModel);
            if (customerModel != null) {
               // System.out.println("customermodel inside provider"+customerModel);
                if (customerModel.getEmail().equals(name) && customerModel.getPassword().equals(password)) {
                    authenticationToken = new UsernamePasswordAuthenticationToken(customerDetails, password, authentication.getAuthorities());
                } else {
                    throw new UsernameNotFoundException("Customer " + name + "Not found");
                }
            }
        }else {
           // System.out.println("else block inside provider");
                UserModel userModel = myUserDetailsService.findUserByEmailAndPassword(name, password);
            MyUserDetails  myUserDetails=new MyUserDetails(userModel);
                //System.out.println(userModel.getEmail());
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            grantedAuthorities.add(new SimpleGrantedAuthority(userModel.getRoleModel().getName()));
                if (userModel != null) {
                    if (userModel.getEmail().equals(name) && userModel.getPassword().equals(password)) {
                        authenticationToken = new UsernamePasswordAuthenticationToken( myUserDetails,password,grantedAuthorities);
                    } else {
                        throw new UsernameNotFoundException("user Not found");
                    }
                }
            }

        return authenticationToken;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
