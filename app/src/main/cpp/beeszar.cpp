// Write C++ code here.
//
// Do not forget to dynamically load the C++ library into your application.
//
// For instance,
//
// In MainActivity.java:
//    static {
//       System.loadLibrary("beeszar");
//    }
//
// Or, in MainActivity.kt:
//    companion object {
//      init {
//         System.loadLibrary("beeszar")
//      }
//    }

//Android
#include <jni.h>
#include <android/log.h>

// C
#include <cstring>
#include <cstdio>
#include <cstdlib>
#include <unistd.h>
#include <iosfwd>

#define APP "beeszar"

extern "C" int Java_com_delcon_beeszar_Authenticator_auth( JNIEnv* env, jobject thiz, jstring param )
{
    int i;
    int valid_key;
    const char *signature = "f0d4c3";
    const char *password = (env)->GetStringUTFChars(param, NULL);
    unsigned int len = strlen(password);

    if (len == 22)
    {
        for ( i = 0; (unsigned long)i < len - 6; i = i+2 ) {
            if((long int)(password[i] - (long int)password[i + 1]) != -1 ){
                __android_log_print(ANDROID_LOG_VERBOSE,APP,"[-] Incorrect password1!");
                valid_key = 0;
                return valid_key;
            }
        }
        for ( i = 16; (unsigned long)i < len; i++){
            if(password[i] != signature[i-16]){
                __android_log_print(ANDROID_LOG_VERBOSE,APP,"[-] Incorrect password2!");
            }
        }
        valid_key = 1;
        __android_log_print(ANDROID_LOG_VERBOSE,APP,"[+] Correct password!");
    }
    else {
        __android_log_print(ANDROID_LOG_VERBOSE,APP,"[-] Incorrect len of password!");
        valid_key = 0;
    }
    return valid_key;
}