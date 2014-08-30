package com.eyes.cornell;

import android.content.Context;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by redstripe509 on 7/20/14.
 */
public class LL{

    LinkedList<String> dict;
    Boolean response = false;
    Context c;
    long llT;
    long llrT;

    public long getLlrT() {
        return llrT;
    }

    public void readLL(){
        long startTime = System.currentTimeMillis();
        readerLinkedList r = new readerLinkedList();
        try {
            dict = r.readFile();
        } catch (IOException e){
            System.out.println("No Dictionary");
        }
        long endTime = System.currentTimeMillis();
        llrT = endTime - startTime;
    }

    public void checkLLWord(String input){

        long startTime = System.currentTimeMillis();

        if(dict.contains(input)){
            response = true;
        } else{
            response = false;
        }


        long endTime = System.currentTimeMillis();

        llT = endTime - startTime;
    }

    public boolean callLLResponse(){
        return response;
    }

   public long getllT(){
       return llT;
   }

}
