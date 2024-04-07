package com.LotusDev.TicTacToe;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class ResultCountDialog extends Dialog {

    int x = 0, o = 0, draw = 0;

    public ResultCountDialog(@NonNull Context context, int x, int o, int draw) {
        super(context);
        this.x = x;
        this.o = o;
        this.draw = draw;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialogfor_result);
        TextView xCount = findViewById(R.id.x);
        TextView oCount = findViewById(R.id.o);
        TextView drawCount = findViewById(R.id.draw);

        xCount.setText(String.valueOf(x));
        oCount.setText(String.valueOf(o));
        drawCount.setText(String.valueOf(draw));
    }
}
