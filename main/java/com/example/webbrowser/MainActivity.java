package com.example.webbrowser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    //ImageView test;
    GridLayout mainGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Log.d("MainActivity","oncreate: started");
//        test=findViewById(R.id.test);
//        test.setImageResource(R.drawable.google);
        mainGrid = (GridLayout) findViewById(R.id.mainGrid);

        setSingleEvent(mainGrid);
    }
    private void setSingleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(MainActivity.this,ActivityOne.class);
                    if(finalI==0)
                    {
                        intent.putExtra("info","https://www.google.com/");
                    }
                    if(finalI==1)
                    {
                        intent.putExtra("info","https://www.youtube.com/");
                    }
                    if(finalI==2)
                    {
                        intent.putExtra("info","https://www.facebook.com/");
                    }
                    if(finalI==3)
                    {
                        intent.putExtra("info","https://www.instagram.com/");
                    }
                    if(finalI==4)
                    {
                        intent.putExtra("info","https://www.flipkart.com/");
                    }
                    if(finalI==5)
                    {
                        intent.putExtra("info","https://www.amazon.com/");
                    }

                    startActivity(intent);

                }
            });
        }
    }
}