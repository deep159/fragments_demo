package com.sts.fragmentdemoandroid;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button mChatBuuton,mCallButton,mContactButton;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager=getSupportFragmentManager();

        mCallButton= (Button) findViewById(R.id.call_button);
        mChatBuuton= (Button) findViewById(R.id.chat_button);
        mContactButton= (Button) findViewById(R.id.concats_button);

        mCallButton.setOnClickListener(this);
        mChatBuuton.setOnClickListener(this);
        mContactButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.call_button)
        {
            manager.beginTransaction().replace(R.id.container,new FragmentCall()).addToBackStack("one").commit();
        }
        if(view.getId()==R.id.chat_button)
        {
            manager.beginTransaction().replace(R.id.container,new FragmentChat()).addToBackStack("two").commit();
        }
        if(view.getId()==R.id.concats_button)
        {
            manager.beginTransaction().replace(R.id.container,new FragmentContacts()).addToBackStack("").commit();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        if(manager.getBackStackEntryCount()==0)
        {
            finish();
        }

    }








}
