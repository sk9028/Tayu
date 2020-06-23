package com.example.tayu;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;

public class SplashActivity extends AppCompatActivity {
    /* 스플래시 화면이 표시되는 시간을 설정(ms) */
    private final int SPLASH_DISPLAY_TIME = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashactivity);

        LottieAnimationView animationView = findViewById(R.id.lottieAnimView);
        setUpAnimation(animationView);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                startActivity(new Intent(getApplication(), MainActivity.class));
                /* 스플래시 액티비티를 스택에서 제거. */
                SplashActivity.this.finish();
            }
        }, SPLASH_DISPLAY_TIME);
    }

    private void setUpAnimation(LottieAnimationView animationView) {
        // 재생할 애니메이션 넣어준다.
        animationView.setAnimation("bike.json");
        // 반복횟수를 무한히 주고 싶을 땐 LottieDrawable.INFINITE or 원하는 횟수
        animationView.setRepeatCount(LottieDrawable.INFINITE);
        // 시작
        animationView.playAnimation();

    }

    @Override
    public void onBackPressed() {
        /* 스플래시 화면에서 뒤로가기 기능 제거. */
    }
}

