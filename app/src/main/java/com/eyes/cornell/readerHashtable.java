package com.eyes.cornell;

import android.content.Context;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * Created by redstripe509 on 7/21/14.
 */
public class readerHashtable {

    public Hashtable<String,ArrayList<String>> readFile()throws IOException {
        String content;
        char[] ch = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        Hashtable<String, ArrayList<String>> list = new Hashtable<String, ArrayList<String>>();
        for(int i = 0; i < 26; i++){
            list.put(ch[i] +"", new ArrayList<String>());
        }

        Context c = App.getAppContext();
        Scanner sc = new Scanner(c.getResources().openRawResource(R.raw.dict));
        while (sc.hasNextLine()){
            content = sc.nextLine().toLowerCase();
            String holder = content.charAt(0) + "";
            list.get(holder).add(content);
        }
        sc.close();

        return list;

    }
}