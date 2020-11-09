package com.lotto.lotto_maker;

import android.content.DialogInterface;
import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.ads.AdRequest;



public class MainActivity extends AppCompatActivity {
    ImageButton make_b;
    Button check_b;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView=findViewById(R.id.adView);
        AdRequest adRequest=new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //광고

        make_b=(ImageButton) findViewById(R.id.make_b);

        make_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Utill.e1=(EditText)findViewById(R.id.max_num);
                Utill.e2=(EditText)findViewById(R.id.count_num);

                if(Utill.e1.getText().toString().length()==0)
                {
                    Utill.e1.setText("0");
                }
                if(Utill.e2.getText().toString().length()==0)
                {
                    Utill.e2.setText("0");
                }
                String getE1=Utill.e1.getText().toString();
                String getE2=Utill.e2.getText().toString();

                Utill.maxnum=Integer.parseInt(Utill.e1.getText().toString());
                Utill.countnum=Integer.parseInt(Utill.e2.getText().toString());
                //EditText 숫자로 형 변환

               if(Utill.maxnum>101||Utill.maxnum<0||Utill.countnum>21||Utill.countnum<0||Utill.maxnum<Utill.countnum) {
                    Toast.makeText(MainActivity.this, "Range exceeded. Please check value.", Toast.LENGTH_SHORT).show();
                }

                else {
                    Intent intent = new Intent(getApplicationContext(), Connect_make.class);
                    startActivity(intent);
                }
                //오류 처리
            }
        });





    }
}
