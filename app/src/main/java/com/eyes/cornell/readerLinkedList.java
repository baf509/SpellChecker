package com.eyes.cornell;

import android.content.Context;

import java.util.*;
import java.io.*;

public class readerLinkedList
{


    public LinkedList<String> readFile()throws IOException{
        String content;
        LinkedList<String> list = new LinkedList<String>();
        Context c = App.getAppContext();
            Scanner sc = new Scanner(c.getResources().openRawResource(R.raw.dict));
            while (sc.hasNextLine()){
                content = sc.nextLine();
                list.add(content);
            }
            sc.close();


        return list;
    }
}