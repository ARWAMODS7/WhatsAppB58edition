package com.B58works.settings.textmods;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.B58works.B58;
import com.B58works.Privacy;
import com.B58works.settings.About;
import com.whatsapp.Settings;
import com.whatsapp.sn1;


import java.io.File;

import static com.B58works.B58.ctx;
import static com.B58works.B58.getBoolean;
import static com.B58works.B58.getResID;
import static com.B58works.settings.About.setcolor;
import static com.B58works.settings.getDrawable.getbg;

public class newSettings extends Settings {

    ScrollView ll;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        setContentView(getResID("text_settingsl", "layout"));
        findViewById(getResID("tprivacy","id")).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx,Privacy.class));
            }
        });
        findViewById(getResID("thome","id")).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx,Homescreen.class));
            }
        });
        findViewById(getResID("tchat","id")).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx,Chatscreen.class));
            }
        });
        findViewById(getResID("tmedia","id")).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx,Mediamods.class));
            }
        });
        findViewById(getResID("tlog","id")).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx,Logscreen.class));
            }
        });
        findViewById(getResID("tpass","id")).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx,com.B58works.pass.class));
            }
        });
        findViewById(getResID("tchooser","id")).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx,Choosers.class));
            }
        });
        findViewById(getResID("aboutb58","id")).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, About.class));
            }
        });
        ll =findViewById(getResID("vsl","id"));

        /*final File file = new File(Environment.getExternalStorageDirectory()+"/"+"B58wishes"+"/special.jpg");
        if(getBoolean("special"))
        {
            if(file.exists())
                ll.setBackgroundDrawable(getbg());
            else
                ll.setBackgroundResource(getResID("wall","drawable"));
        }
        else
            ll.setBackgroundColor(-1);*/
        ll.setBackgroundColor(sn1.getColor("bgcolor",-1));
        super.setTitle("B58 Text mods");
        setviews();
        TextView t=findViewById(getResID("aboutus","id"));

        t.setText("Hi "+ B58.MaMy_Name2()+",");
    }

    public void onBackPressed() {
        super.onBackPressed();
        Backpress();
    }

    public static void Backpress() {
        Toast.makeText(B58.ctx, "Please Restart WhatsApp for the changes to take place if you have made any.", Toast.LENGTH_LONG).show();
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

    public void onResume()
    {
        super.onResume();
    }

    public void setviews()
    {

        String names[]={"t1","t2","t3","t4","t5","t6","t7","aboutus","aboutus2"};
        for (String name : names) {
            setcolor((TextView) findViewById(getResID(name, "id")));
        }
    }

}
