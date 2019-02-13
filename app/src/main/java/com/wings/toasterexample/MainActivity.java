package com.wings.toasterexample;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.wings.toasterlibrary.ToasterMessage;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToasterMessage toasterMessage = new ToasterMessage(MainActivity.this);
        toasterMessage.showToast("Hello", Toast.LENGTH_SHORT);

        toasterMessage.showCustomToast("Custom Toast", Toast.LENGTH_LONG,
                ContextCompat.getColor(MainActivity.this, R.color.colorPrimary),
                getResources().getDrawable(R.drawable.ic_emoji), ToasterMessage.GRAVITY_CENTER_CENTER);
    }
}
