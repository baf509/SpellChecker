package com.eyes.cornell;

import android.content.Context;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by redstripe509 on 7/29/14.
 */
public class readerSplayTree {

    public SimpleST.SplayBST readFile()throws IOException {
        String content;
        SimpleST.SplayBST<String, String> list = new SimpleST.SplayBST<String, String>();
        Context c = App.getAppContext();
        Scanner sc = new Scanner(c.getResources().openRawResource(R.raw.dict));
        while (sc.hasNextLine()){
            content = sc.nextLine();
            list.put(content, content);
        }
        sc.close();

        return list;
    }
}
