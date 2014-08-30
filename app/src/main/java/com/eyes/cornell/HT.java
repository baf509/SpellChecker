package com.eyes.cornell;

import android.content.Context;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by redstripe509 on 7/21/14.
 */
public class HT {

        Hashtable dict;
        Boolean response = false;
        Context c;
        long htT;
        long htrT;

    public long getHtrT() {
        return htrT;
    }

    public void readHT(){
            long startTime = System.currentTimeMillis();
            readerHashtable r = new readerHashtable();
            try {
                dict = r.readFile();
            } catch (IOException e){
                System.out.println("No Dictionary");
            }
            long endTime = System.currentTimeMillis();
            htrT = endTime - startTime;
        }

        public void checkHTWord(String input){

            long startTime = System.currentTimeMillis();
            String temp = (input.charAt(0) + "").toLowerCase();
            ArrayList<String> tempArray;

            tempArray = (ArrayList<String>)dict.get(temp);

            if(tempArray.contains(input)){
                response = true;
            } else{
                response = false;
            }

            long endTime = System.currentTimeMillis();

            htT = endTime - startTime;

            System.out.println(htT);
        }

        public boolean callHTResponse(){
            return response;
        }

        public long gethtT(){
            return htT;
        }
}
