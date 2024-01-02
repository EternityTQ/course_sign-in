package com.rainng.coursesystem.util;

import java.util.Random;

public class GernerateSigninCode {

    public static int getCode() {
        Random random = new Random();
        return 100000 + random.nextInt(900000);
    }

}