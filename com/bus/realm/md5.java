package com.bus.realm;

import org.apache.shiro.crypto.hash.Md5Hash;

public class md5 {

    public void jami(String password){
    /*Md5Hash hash = new Md5Hash("password");
    System.out.println("hash1 = " + hash);
    hash = new Md5Hash("password","skeye");
    System.out.println("hash2 = " + hash);*/
    Md5Hash hash = new Md5Hash("password","skeye",2);//迭代2次
    System.out.println("hash3 = " + hash);
    }

}
