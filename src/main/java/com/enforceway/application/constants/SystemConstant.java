package com.enforceway.application.constants;

import java.util.ArrayList;
import java.util.List;

public class SystemConstant {

    /**
     * token
     */
    public static final int JWT_ERRCODE_NULL = 4000;			//Token不存在
    public static final int JWT_ERRCODE_EXPIRE = 4001;			//Token过期
    public static final int JWT_ERRCODE_FAIL = 4002;			//验证不通过

    /**
     * JWT
     */
    public static final String JWT_SECERT = "8677df7fc3a34e26a61c034d5ec8245d";			//密匙
    public static final long JWT_TTL = 60 * 60 * 1000;									//token有效时间

//    public static final String ALI_YUN_OSS_ENDPOINT = "phonebook-app-1817212929972022.oss-cn-beijing.oss-accesspoint.aliyuncs.com";

    public static final String ALI_YUN_OSS_ENDPOINT = "oss-cn-beijing.aliyuncs.com";
    //

    public static final String ALI_YUN_OSS_CRTL_ACCOUNT_NAME = "phoneBook_Dev@1817212929972022.onaliyun.com";

    public static final String ALI_YUN_OSS_USER_ACCESSKEY_SECRET = "whXZoThFFOvOxiV8GYoRPD16L0v33n";

    public static final String ALI_YUN_OSS_USER_ACCESSKEY_ID = "LTAI5tLm4ppw8XLZ38aMegfW";

    public static final String ALI_YUN_OSS_IMAGE_BUCKETNAME = "phonebook-image";

    public static final String[] excludedCheckURLs = new String[]{"/phoneBook/avatar", "/login"};

    public static final String imageStorePath = "D:\\espace\\practice\\contacts-manager\\src\\main\\resources\\static\\image";

}

