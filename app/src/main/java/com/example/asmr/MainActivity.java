package com.example.asmr;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //bundle 데이터전달
                    Home home = new Home();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", "홍길동");
                    bundle.putInt("age", 20);
                    home.setArguments(bundle);

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content, home)
                            .commit();
                    return true;
                case R.id.navigation_keyboard_voice:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content, new Record())
                            .commit();
                    return true;
                case R.id.navigation_alarm:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content, new Alarm())
                            .commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, new Home())
                .commit();
    }

}
