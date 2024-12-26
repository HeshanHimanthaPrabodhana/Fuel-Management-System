
package com.mycompany.fuelmanagementsystem;

import java.util.prefs.Preferences;

public class Preference {
    static Preferences preference = Preferences.userRoot();
    
    public static void userDtataStore(String userName , String password){
        preference.put(userName, password);
    }
    
    public static String userDataReceiver(String userName){
        return preference.get(userName , "");
    }
    
    public static void oilStatusStore(String oiltype , String availability){
        preference.put(oiltype, availability);
    }
    
    public static String OilStatusReceiver(String oiltype){
        return preference.get(oiltype , "");
    }
}
