package com.avium.extrasum;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.error_message)
    TextView errorMessage;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.statusbar));

        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);


    }

    @Override
    protected void onStart() {
        super.onStart();

        final VideoView videoview = (VideoView) findViewById(R.id.videoview);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.loginbgvideo);
        videoview.setVideoURI(uri);

        videoview.requestFocus();
        videoview.start();
        videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {

                videoview.start();

            }
        });
        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

    }

    @OnClick(R.id.login)
    public void onViewClicked() {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        String emails = email.getText().toString();
        String passwords = password.getText().toString();
        if (emails.equals("") || passwords.equals("")) {
            email.setBackgroundDrawable(getApplicationContext().getResources().getDrawable(R.drawable.erroredittext));
            password.setBackgroundDrawable(getApplicationContext().getResources().getDrawable(R.drawable.erroredittext));
            errorMessage.setVisibility(View.VISIBLE);
            Toast.makeText(getApplicationContext(), "You have missed email address or password", Toast.LENGTH_SHORT).show();
        } else if (!emails.matches(emailPattern)) {
            email.setBackgroundDrawable(getApplicationContext().getResources().getDrawable(R.drawable.erroredittext));
            password.setBackgroundDrawable(getApplicationContext().getResources().getDrawable(R.drawable.erroredittext));
            errorMessage.setVisibility(View.VISIBLE);
            Toast.makeText(getApplicationContext(), "Invalid email address", Toast.LENGTH_SHORT).show();
        } else {
            InputMethodManager imm = (InputMethodManager) getApplication().getSystemService(Activity.INPUT_METHOD_SERVICE);
            View view = LoginActivity.this.getCurrentFocus();
            if (view == null) {
                view = new View(getApplicationContext());
            }
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            email.setBackgroundDrawable(getApplicationContext().getResources().getDrawable(R.drawable.login_edit_textback));
            password.setBackgroundDrawable(getApplicationContext().getResources().getDrawable(R.drawable.login_edit_textback));
            errorMessage.setVisibility(View.GONE);

            startActivity(new Intent(getApplicationContext(), Home.class));
        }

    }
}
