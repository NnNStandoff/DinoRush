package com.example.dinozavr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView , textView2;
    private Button button2 , button3;

    private boolean isMute; // поле включения и выключения звука приложения
    private ImageView volumeOn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window w = getWindow();
        w.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);


        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);



        volumeOn = findViewById(R.id.volumeOn);


        SharedPreferences preferences = getSharedPreferences("game", MODE_PRIVATE);
        // вывод на экран рекордного значения
        textView.setText("Рекорд: " + preferences.getInt("gamer", 0));
        textView2.setText("Прошлая попытка: " + preferences.getInt("qwe", 0));



        isMute = preferences.getBoolean("isMute", false);
        // загрузка иконок на картинку звука
        if (isMute) {
            volumeOn.setImageResource(R.drawable.ic_baseline_volume_off_24);
        } else {
            volumeOn.setImageResource(R.drawable.ic_baseline_volume_up_24);
        }
        volumeOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isMute = !isMute;
                // загрузка иконок на картинку звука
                if (isMute) {
                    volumeOn.setImageResource(R.drawable.ic_baseline_volume_off_24);
                } else {
                    volumeOn.setImageResource(R.drawable.ic_baseline_volume_up_24);
                }
                // внесение данных в настройки приложения
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("isMute", isMute);
                editor.apply();
            }
        });


        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // обработка нажатия на TextView с id play
        findViewById(R.id.play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // переключение активити с помощью намерения
                startActivity(new Intent(MainActivity.this, GameActivity.class));
            }
        });
    }
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext() , Seecond_activity.class);
            startActivities(new Intent[]{intent});
        }
    };
}