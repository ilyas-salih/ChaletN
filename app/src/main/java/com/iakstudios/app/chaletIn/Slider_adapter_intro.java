package com.iakstudios.app.chaletIn;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Slider_adapter_intro extends PagerAdapter {
    Context context;

    LayoutInflater layoutInflater;
    public  Integer [] slide_image={R.drawable.intro_1,R.drawable.intro_2,R.drawable.intro_1};
    public Integer[] slide_heading={R.string.intro1_head,R.string.intro2_head,R.string.intro3_head};

    public Slider_adapter_intro (Context context) {
        this.context = context;
    }
    @Override
    public int getCount() {
        return slide_image.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewPager pager = (ViewPager) container;
        View view = layoutInflater.inflate(R.layout.slide_layout,null);


        ImageView slideimage=(ImageView)view.findViewById(R.id.slide_image);
        TextView slidetext=(TextView)view.findViewById(R.id.slide_heading);
        slideimage.setImageResource(slide_image[position]);
        slidetext.setText(slide_heading[position]);

        Typeface myTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/flat.ttf");
        slidetext.setTypeface(myTypeface);

        ViewPager vp=(ViewPager)container;
        vp.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp=(ViewPager)container;
        View view=(View)object;
        vp.removeView(view);
    }
}
