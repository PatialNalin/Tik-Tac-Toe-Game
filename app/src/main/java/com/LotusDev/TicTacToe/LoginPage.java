package com.LotusDev.TicTacToe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginPage extends AppCompatActivity {
    Button button;
    EditText text1 , text2;
    Intent iNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        button = findViewById(R.id.Entry);
        text1 = findViewById(R.id.Data);
        text2 = findViewById(R.id.Data2);




                button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String p1 = text1.getText().toString();
                final String p2 = text2.getText().toString();

                if(!p1.isEmpty()&&!p2.isEmpty()){
                    iNext = new Intent(LoginPage.this, TikTakGame.class);
                    iNext.putExtra("Player 1", p1);
                    iNext.putExtra("Player 2", p2);
                    startActivity(iNext);

                    // add custom toast

                }else {
                    Toast toast = new Toast(LoginPage.this);
                    View view = getLayoutInflater().inflate(R.layout.toast_layout,(ViewGroup) findViewById(R.id.toastCardView));
                    toast.setView(view);
                    TextView toasttxt = view.findViewById(R.id.toastText);
                    toasttxt.setText("Please Enter Name");
                    toast.show();
                }
            }
        });
    }
}