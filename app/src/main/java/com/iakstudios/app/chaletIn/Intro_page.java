package com.iakstudios.app.chaletIn;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Intro_page extends AppCompatActivity {
    private ViewPager mslide;
    private LinearLayout mDotlayer;
    private Slider_adapter_intro slider;
    private TextView[] mDtos;
    private Button nextbtn,backbtn;
    private int curentPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_page);
        nextbtn=(Button)findViewById(R.id.nexbtn);
        backbtn=(Button)findViewById(R.id.prevbtn);
        mslide=(ViewPager)findViewById(R.id.slidViewPage);
        mDotlayer=(LinearLayout)findViewById(R.id.dotsLayout);
        slider=new Slider_adapter_intro(this);
        mslide.setAdapter(slider);
        addDot(0);
        mslide.addOnPageChangeListener(viewListener);
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(curentPage==0)
                {
                    mslide.setCurrentItem(curentPage+1);
                }
                else if(curentPage==1){
                    mslide.setCurrentItem(curentPage+1);
                }
                else if(nextbtn.getText()=="Finish") {
                    Intent intent=new Intent(Intro_page.this,sigin_page.class);
                    startActivity(intent);
                }


            }
        });
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mslide.setCurrentItem(curentPage-1);
            }
        });


    }
    public void addDot(int postion)
    {
        mDtos=new TextView[3];
        mDotlayer.removeAllViews();
        for (int i=0;i<mDtos.length;i++)
        {
            mDtos[i]=new TextView(this);
            mDtos[i].setText(Html.fromHtml("&#8226"));
            mDtos[i].setTextSize(80);
            mDtos[i].setGravity(Gravity.CENTER_HORIZONTAL);
            mDtos[i].setTextColor(getResources().getColor(R.color.dotco));
            mDotlayer.addView(mDtos[i]);
        }
        if(mDtos.length>0)
        {
            mDtos[postion].setTextColor(getResources().getColor(R.color.dotcolor));
        }
    }
    ViewPager.OnPageChangeListener viewListener= new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDot(position);
            curentPage=position;
            if(position==0)
            {
                nextbtn.setEnabled(true);
                backbtn.setEnabled(false);
                backbtn.setVisibility(View.INVISIBLE);
                nextbtn.setText("Next");
                backbtn.setText("");
            }else if(position==mDtos.length-1)
            {
                nextbtn.setEnabled(true);
                backbtn.setEnabled(true);
                backbtn.setVisibility(View.VISIBLE);
                nextbtn.setText("Finish");
                backbtn.setText("Back");


            }
            else
            {
                nextbtn.setEnabled(true);
                backbtn.setEnabled(true);
                backbtn.setVisibility(View.VISIBLE);
                nextbtn.setText("Next");
                backbtn.setText("Back");
            }


        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
