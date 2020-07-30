package com.bus.realm;

import com.bus.entity.User;
import com.bus.service.AuthorityService;
import com.bus.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashSet;
import java.util.Set;

public class UserRealm extends AuthorizingRealm {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("-----------授权--------");
        //User user = (User) principals.getPrimaryPrincipal();
        String username =(String)principals.getPrimaryPrincipal();
        //String username = user.getUserName();
        System.out.println("username = " + username);

        Set<String> roles = new HashSet<>(userService.findRoleByUserName(username));
        System.out.println("roles = " + roles);

        Set<String> permissions = new HashSet<>(userService.findAuthorityByUserName(username));
        System.out.println("permissions = " + permissions);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roles);
        info.setStringPermissions(permissions);

        return info;

    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = token.getPrincipal().toString();
        System.out.println("username ============= " + username);
        String inputPassword = new String((char[]) token.getCredentials());
        System.out.println("前台传来的密码：" + inputPassword);
        User user = userService.selectByUsername(username);
        System.out.println(user.getUserPassword());

        if (user == null) {
            throw new UnknownAccountException("aaa");
        }
        ByteSource credentialsSalt = ByteSource.Util.bytes("skeye");
        return new SimpleAuthenticationInfo
                (user.getUserName(), user.getUserPassword(),credentialsSalt, getName());
    }
}
