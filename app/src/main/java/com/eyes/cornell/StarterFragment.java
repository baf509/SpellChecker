package com.eyes.cornell;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class StarterFragment extends Fragment {

    Button llCheck;
    EditText llET;
    String llInput;
    TextView llTVR;
    TextView llTVT;
    TextView llrTVT;

    Button stCheck;
    EditText stET;
    String stInput;
    TextView stTVR;
    TextView stTVT;
    TextView strTVT;

    Button htCheck;
    EditText htET;
    String htInput;
    TextView htTVR;
    TextView htTVT;
    TextView htrTVT;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_starter, container, false);

        llTVR = (TextView)v.findViewById(R.id.tvLL);
        llET = (EditText)v.findViewById(R.id.etLL);
        llTVT = (TextView)v.findViewById(R.id.tLL);
        llrTVT = (TextView)v.findViewById(R.id.rLL);

        llCheck = (Button)v.findViewById(R.id.cLL);
        llCheck.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                llInput = llET.getText().toString();
                LL in = new LL();
                in.readLL();
                in.checkLLWord(llInput);
                if(in.callLLResponse()){
                    llTVR.setText("Correct");
                }
                if(!in.callLLResponse()){
                    llTVR.setText("Wrong");
                }
                llTVT.setText(in.getllT() + "");
                llrTVT.setText(in.getLlrT() + "");
                System.out.println("LL Button Registers click");
            }
        });


        stTVR = (TextView)v.findViewById(R.id.tvST);
        stET = (EditText)v.findViewById(R.id.etST);
        stTVT = (TextView)v.findViewById(R.id.tST);
        strTVT = (TextView)v.findViewById(R.id.rST);

        stCheck = (Button)v.findViewById(R.id.cST);
        stCheck.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                stInput = stET.getText().toString();
                ST in = new ST();
                in.readST();
                in.checkSTWord(stInput);
                if(in.callSTResponse()){
                    stTVR.setText("Correct");
                }
                if(!in.callSTResponse()){
                    stTVR.setText("Wrong");
                }
                stTVT.setText(in.getstT() + "");
                strTVT.setText(in.getRtT() + "");
                System.out.println("ST Button Registers click");
            }
        });

        htTVR = (TextView)v.findViewById(R.id.tvHT);
        htET = (EditText)v.findViewById(R.id.etHT);
        htTVT = (TextView)v.findViewById(R.id.tHT);
        htrTVT = (TextView)v.findViewById(R.id.rHT);

        htCheck = (Button)v.findViewById(R.id.cHT);
        htCheck.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                htInput = htET.getText().toString();
                HT in = new HT();
                in.readHT();
                in.checkHTWord(htInput);
                if(in.callHTResponse()){
                    htTVR.setText("Correct");
                }
                if(!in.callHTResponse()){
                    htTVR.setText("Wrong");
                }
                htTVT.setText(in.gethtT() + "");
                htrTVT.setText(in.getHtrT() + "");
                System.out.println("HT Button Registers click");
            }
        });
        return v;
    }
}
