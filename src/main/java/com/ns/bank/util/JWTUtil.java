package com.ns.bank.util;

import com.ns.bank.entity.User;
import com.ns.bank.model.CustomerModel;
import com.ns.bank.model.UserModel;
import com.ns.bank.service.impl.CustomerService;
import com.ns.bank.service.impl.UserService;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

@Service
public class JwtUtil {

    @Autowired
    private UserService userService;

    @Autowired
    private CustomerService customerService;


    private String SECRET_KEY="secret";


    public String extractEmail(String token){
        return extractClaim(token, Claims::getSubject);
    }
    public Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token , Function<Claims,T> claimsResolver){
        final Claims claims=extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    public String extractRole(String token){
       return (String) extractAllClaims(token).get("role");
    }
    private Claims extractAllClaims(String token) {
        //   System.out.println("claims"+Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody());
      //  System.out.println("inside extract all claims:+role"+Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().get("role"));
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();

    }

    private Boolean isTokenExpired(String token)
    {
        boolean validation=false;
        try {
          Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
            validation=extractExpiration(token).before(new Date());
        } catch (ExpiredJwtException e) {
            System.out.println(" Token expired ");
        } catch (SignatureException e) {

        } catch(Exception e){
            System.out.println(" Some other exception in JWT parsing ");
        }
     return validation;
    }
    public  String generateToken(UserDetails userDetails)
    {
        System.out.println("inside user generate token");
       UserModel userModel= userService.findUserByEmailAndPassword(userDetails.getUsername(),userDetails.getPassword());
       // UserModel userModel=userMapper.convertEntityToModel(user.get());
       Map<String ,Object> claims=new HashMap<>();
       claims.put("name",userModel.getName());
       claims.put("id",userModel.getId());
       claims.put("email",userModel.getEmail());
       claims.put("role",userModel.getRoleModel().getName());
        return createToken(claims,userDetails.getUsername());
    }

    public String generateToken(UserDetails userDetails,Boolean isCustomer)
    {
        System.out.println("inside customer generate token");
       CustomerModel customerModel= customerService.getCustomerByEmailAndPassword(userDetails.getUsername(),userDetails.getPassword());
        Map<String ,Object> claims=new HashMap<>();
        claims.put("name",customerModel.getName());
        claims.put("id",customerModel.getAccountNo());
        claims.put("email",customerModel.getEmail());
        claims.put("role","Customer");
        return createToken(claims,userDetails.getUsername());
    }
    private String createToken(Map<String ,Object> claims,String subject)
    {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60*10)).signWith(SignatureAlgorithm.HS256,SECRET_KEY).compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
       // System.out.println("inside validate token");
        final String email= extractEmail(token);
       // System.out.println("inside validate token+email"+email);
       // System.out.println("claims"+extractAllClaims(token));
       // System.out.println("condition-1:"+email.equals(username) );
        //System.out.println( "condition-2"+ !isTokenExpired(token));
        return (email.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}

