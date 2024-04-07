package com.LotusDev.TicTacToe;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class WinnerDialog extends Dialog {
    private final String message ;
    private final TikTakGame mainActivity;
    public WinnerDialog(@NonNull Context context,String message,TikTakGame mainActivity) {
        super(context);
        this.message = message;
        this.mainActivity = mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialogfor_winner);
        final TextView winner = findViewById(R.id.winnerName);
        final Button restart = findViewById(R.id.restartButton);

        winner.setText(message);

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.restartMatch();
                dismiss();
            }
        });

    }
}
