package com.ptp.phamtanphat.seekbarracing0208;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageButton imgplay;
    CheckBox checkBoxOne,checkBoxTwo,checkBoxThree;
    SeekBar seekBarOne,seekBarTwo,seekBarThree;
    int valueseekbar1 = 0;
    int valueseekbar2 = 0;
    int valueseekbar3 = 0;
    CountDownTimer countDownTimer;
    Handler handler;
    Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        eventCheckBox();
        eventPlay();
        eventRandomSeekbar();

    }

    private void eventPlay() {
        imgplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBoxOne.isChecked() || checkBoxTwo.isChecked() || checkBoxThree.isChecked()){
                    runnable = new Runnable() {
                        @Override
                        public void run() {
                            final Random random = new Random();
                            valueseekbar1 = random.nextInt(10);
                            valueseekbar2 = random.nextInt(10);
                            valueseekbar3 = random.nextInt(10);
                            if (seekBarOne.getProgress() >= seekBarOne.getMax()){
                                countDownTimer.cancel();
                                Toast.makeText(MainActivity.this, "Ban da chon dung", Toast.LENGTH_SHORT).show();
                            }
                            if (seekBarTwo.getProgress() >= seekBarTwo.getMax()){
                                countDownTimer.cancel();
                                Toast.makeText(MainActivity.this, "Ban da chon dung", Toast.LENGTH_SHORT).show();
                            }
                            if (seekBarThree.getProgress() >= seekBarThree.getMax()){
                                countDownTimer.cancel();
                                Toast.makeText(MainActivity.this, "Ban da chon dung", Toast.LENGTH_SHORT).show();
                            }
                            seekBarOne.setProgress(seekBarOne.getProgress() + valueseekbar1);
                            seekBarTwo.setProgress(seekBarTwo.getProgress() + valueseekbar2);
                            seekBarThree.setProgress(seekBarThree.getProgress() + valueseekbar3);
                        }
                    };
                countDownTimer = new CountDownTimer(60000,500) {
                    @Override
                    public void onTick(long l) {
                        handler.postDelayed(runnable,1);
                    }

                    @Override
                    public void onFinish() {

                    }
                };
                countDownTimer.start();

                }else {
                    Toast.makeText(MainActivity.this, "Ban hay chon check box ", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void eventRandomSeekbar() {
    }

    private void eventCheckBox() {
        checkBoxOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true){
                    checkBoxTwo.setChecked(false);
                    checkBoxThree.setChecked(false);
                }
            }
        });
        checkBoxTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true){
                    checkBoxOne.setChecked(false);
                    checkBoxThree.setChecked(false);
                }
            }
        });
        checkBoxThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true){
                    checkBoxTwo.setChecked(false);
                    checkBoxOne.setChecked(false);
                }
            }
        });
    }

    private void anhxa() {
        imgplay = (ImageButton) findViewById(R.id.imagebuttonplay);
        checkBoxOne = (CheckBox) findViewById(R.id.checkboxOne);
        checkBoxTwo = (CheckBox) findViewById(R.id.checkboxTwo);
        checkBoxThree = (CheckBox) findViewById(R.id.checkboxthree);
        seekBarOne = (SeekBar) findViewById(R.id.seekbarOne);
        seekBarThree = (SeekBar) findViewById(R.id.seekbarThree);
        seekBarTwo = (SeekBar) findViewById(R.id.seekbarTwo);
        handler = new Handler();

    }
}
