package com.delcon.beeszar;

public class Authenticator {
    static {
        System.loadLibrary("beeszar");
    }

    public native int auth(String param);
}
