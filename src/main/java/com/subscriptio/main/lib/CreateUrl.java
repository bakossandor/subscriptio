package com.subscriptio.main.lib;

import net.bytebuddy.utility.RandomString;

public class CreateUrl {
    public static String make() {
        return RandomString.make(10);
    }
}
