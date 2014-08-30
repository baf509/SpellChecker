package com.eyes.cornell;

import android.content.Context;
import java.io.IOException;

/**
 * Created by redstripe509 on 7/29/14.
 */
public class ST {

    SimpleST.SplayBST dict;
    Boolean response = false;
    Context c;
    long stT;
    long rtT;

    public long getRtT() {
        return rtT;
    }

    public void readST(){
        long startTime = System.currentTimeMillis();
        readerSplayTree r = new readerSplayTree();
        try {
            dict = r.readFile();
        } catch (IOException e){
            System.out.println("No Dictionary");
        }
        long endTime = System.currentTimeMillis();

        rtT = endTime - startTime;
    }

    public void checkSTWord(String input){

        long startTime = System.currentTimeMillis();
        System.out.println(dict.root.key);
        if(dict.get(input).equals(input)){
            response = true;
        } else{
            response = false;
        }

        long endTime = System.currentTimeMillis();

        stT = endTime - startTime;

        //Double check to show the benefit of having a splay tree
        //as the item is now towards the top

    }

    public boolean callSTResponse(){
        return response;
    }

    public long getstT(){
        return stT;
    }
}
