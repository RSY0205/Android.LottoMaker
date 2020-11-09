package com.lotto.lotto_maker;

import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import org.w3c.dom.Text;

import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

public class Connect_make extends AppCompatActivity {
    private AdView mAdView;
    ImageView im;
    TextView text;
    EditText max_num, count_num;

    Button b;
    int maxnum,countnum,num,i=0,y;

    int imageArray[]=  {R.id.ball1,R.id.ball2,R.id.ball3,R.id.ball4,R.id.ball5,
                            R.id.ball6,R.id.ball7,R.id.ball8,R.id.ball9,R.id.ball10,
                            R.id.ball11,R.id.ball12,R.id.ball13,R.id.ball14,R.id.ball15,
                            R.id.ball16,R.id.ball17,R.id.ball18,R.id.ball19,R.id.ball20};   //최대 20개의 ImageView 배열

    int [] TextArray =   {R.id.num1,R.id.num2,R.id.num3,R.id.num4,R.id.num5,
                        R.id.num6,R.id.num7,R.id.num8,R.id.num9,R.id.num10,
                        R.id.num11,R.id.num12,R.id.num13,R.id.num14,R.id.num15,
                        R.id.num16,R.id.num17,R.id.num18,R.id.num19,R.id.num20};           //최대 20개의 TextView 배열

    int[] img={R.drawable.ball_red,R.drawable.ball_orange,R.drawable.ball_yellow,R.drawable.ball_green,
                R.drawable.ball_blue,R.drawable.ball_navy,R.drawable.ball_violet};      //최대 7개의 그림 배열

    int[] result= new int[20];



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_make);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView=findViewById(R.id.adView);
        AdRequest adRequest=new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //광고 출력

        b=(Button)findViewById(R.id.back);

        Random ran1= new Random();
        Random ran2= new Random();
        //랜덤 함수 생셩


    for(i=0;i<Utill.countnum;i++)
    {
     result[i]=ran1.nextInt(Utill.maxnum)+1;
     for(int j=0;j<i;j++)
     {
         if(result[i]==result[j])
         {
             i--;
         }
     }
    }
    //번호 추첨,중복 삭제

        for(i=0;i<Utill.countnum;i++)
        {
            num=ran2.nextInt(img.length);
            im=(ImageView) findViewById(imageArray[i]);
            text=(TextView)findViewById(TextArray[i]);

            String to= Integer.toString(result[i]);
            text.setText(to);
            im.setBackgroundResource(img[num]);

        }
        //그림 랜덤 생성후, 번호와 함께 출력

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
}



