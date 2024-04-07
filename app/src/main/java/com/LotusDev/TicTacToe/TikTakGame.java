package com.LotusDev.TicTacToe;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class TikTakGame extends AppCompatActivity {
    private final List<int[]> combList = new ArrayList<>();
    private int[] position = {0,0,0,0,0,0,0,0,0};

    private int playerTurn = 1;

    private int totalSelectedBox = 1;
     private TextView pl1,pl2;

     private LinearLayout p1L , p2L;
    private ImageView im1 , im2, im3 , im4 , im5, im6 , im7 , im8 , im9 ;

    int x = 0 , o = 0 , draw = 0;

    private Button Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tik_tak_game);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ids();
        data();
        toast();


        combList.add(new int[]{0,1,2});
        combList.add(new int[]{3,4,5});
        combList.add(new int[]{6,7,8});
        combList.add(new int[]{0,3,6});
        combList.add(new int[]{1,4,7});
        combList.add(new int[]{2,5,8});
        combList.add(new int[]{0,4,8});
        combList.add(new int[]{6,4,2});





        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelected(0)){

                    performAction((ImageView) v, 0);
                }

            }
        });


        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelected(1)){
                    performAction((ImageView) v, 1);
                }

            }
        });



        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelected(2)){
                    performAction((ImageView) v, 2);
                }


            }
        });




        im4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelected(3)){
                    performAction((ImageView) v, 3);
                }

            }
        });




        im5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelected(4)){
                    performAction((ImageView) v, 4);
                }

            }
        });




        im6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelected(5)){
                    performAction((ImageView) v, 5);
                }

            }
        });





        im7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelected(6)){
                    performAction((ImageView) v, 6);
                }

            }
        });




        im8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelected(7)){
                    performAction((ImageView) v, 7);
                }

            }
        });





        im9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelected(8)){
                    performAction((ImageView) v, 8);

                }

            }
        });


       /* Result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isFinishing()) {
                    ResultCountDialog rslt = new ResultCountDialog(getApplicationContext(), x, o, draw);
                    rslt.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    rslt.show();
                }
            }
        });*/


    }

    public void ids(){
        im1 = findViewById(R.id.image1);
        im2 = findViewById(R.id.image2);
        im3 = findViewById(R.id.image3);
        im4 = findViewById(R.id.image4);
        im5 = findViewById(R.id.image5);
        im6 = findViewById(R.id.image6);
        im7 = findViewById(R.id.image7);
        im8 = findViewById(R.id.image8);
        im9 = findViewById(R.id.image9);
        p1L = findViewById(R.id.Player1Layout);
        p2L = findViewById(R.id.Player2Layout);
        pl1 = findViewById(R.id.player1);
        pl2 = findViewById(R.id.player2);
        Result = findViewById(R.id.win);
    }
    public void data(){
        String userName1 = getIntent().getStringExtra("Player 1");
        String userName2 = getIntent().getStringExtra("Player 2");
        pl1.setText(userName1);
        pl2.setText(userName2);
    }

    private void performAction(ImageView image , int boxPos){
        position[boxPos] = playerTurn;

        if(playerTurn == 1) {
            image.setImageResource(R.drawable.cross);

            if (checkPlayerWin()) {
                WinnerDialog winnerDialog = new WinnerDialog(this, "Winner is : " + pl1.getText().toString(), TikTakGame.this);
                winnerDialog.setCancelable(false);
                winnerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                winnerDialog.show();
                x++;
            } else if (totalSelectedBox == 9) {
                WinnerDialog winnerDialog = new WinnerDialog(this, "Match is a Draw", TikTakGame.this);
                winnerDialog.setCancelable(false);
                winnerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                winnerDialog.show();
                draw++;
            } else {
                changeTurn(2);
                totalSelectedBox++;
            }
        }
        else{
            image.setImageResource(R.drawable.ovel);
            if(checkPlayerWin()){
                WinnerDialog winnerDialog = new WinnerDialog(this, "Winner is : " + pl2.getText().toString(), TikTakGame.this);
                winnerDialog.setCancelable(false);
                winnerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                winnerDialog.show();
                o++;
            } else if (totalSelectedBox == 9) {
                WinnerDialog winnerDialog = new WinnerDialog(this, "Match is a Draw", TikTakGame.this);
                winnerDialog.setCancelable(false);
                winnerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                winnerDialog.show();
                draw++;
            }
            else {
                changeTurn(1);

                totalSelectedBox++;
            }
        }

    }

        private void changeTurn(int currentPlayerTurn){
        playerTurn = currentPlayerTurn;

        if(playerTurn == 1){
            p1L.setBackgroundResource(R.drawable.inner_background);
            p2L.setBackgroundResource(R.drawable.outer_background);
        }else{
            p1L.setBackgroundResource(R.drawable.outer_background);
            p2L.setBackgroundResource(R.drawable.inner_background);
        }
        }
    private boolean checkPlayerWin(){
        for(int i = 0 ; i<combList.size();i++) {
            final int[] comb = combList.get(i);
            if(position[comb[0]]== playerTurn && position[comb[1]]==playerTurn&&position[comb[2]]==playerTurn){
                return true;
            }
        }
        return false;
    }
    private boolean isBoxSelected (int boxPosition){
        boolean response = false;
        if(position[boxPosition]==0){
            response = true;
        }
        return response;
    }
        public void restartMatch(){
        position = new int[]{0,0,0,0,0,0,0,0,0};
        playerTurn = 1;
        totalSelectedBox = 1;

        im1.setImageResource(R.drawable.backgroundofgame);
            im2.setImageResource(R.drawable.backgroundofgame);
            im3.setImageResource(R.drawable.backgroundofgame);
            im4.setImageResource(R.drawable.backgroundofgame);
            im5.setImageResource(R.drawable.backgroundofgame);
            im6.setImageResource(R.drawable.backgroundofgame);
            im7.setImageResource(R.drawable.backgroundofgame);
            im8.setImageResource(R.drawable.backgroundofgame);
            im9.setImageResource(R.drawable.backgroundofgame);
        }

        public void toast(){
            Toast toast = new Toast(getApplicationContext());
            View view = getLayoutInflater().inflate(R.layout.toast_layout,(ViewGroup) findViewById(R.id.toastCardView));
            toast.setView(view);
            TextView txt = view.findViewById(R.id.toastText);
            ImageView img = view.findViewById(R.id.toastImag);
            txt.setText("Lets Play");
            img.setImageResource(R.drawable.commitment);
            toast.show();
        }
}




/*
winnerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));*/ // for curve dialogbox
