package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView curView = null;
    private int countPair = 0;
    final int[] drawable = new int[]{
            R.drawable.bullbasaur, R.drawable.charmander, R.drawable.jigglypuff,
            R.drawable.pikachu, R.drawable.psyduck, R.drawable.snorlax};
    int[] pos = {0,1,2,3,4,5,0,1,2,3,4,5};
    int currentPos = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView)findViewById(R.id.gridView);
        ImageAdapter imageAdapter = new ImageAdapter(this);
        gridView.setAdapter(imageAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if(currentPos <0){
                    currentPos = position;
                    curView = (ImageView)view;
                    ((ImageView)view).setImageResource(drawable[pos[position]]);
                }
                else{
                    if(currentPos == position){
                        ((ImageView)view).setImageResource(R.drawable.pokeball);
                    }
                    else if(pos[currentPos] != pos[position]){
                        curView.setImageResource(R.drawable.pokeball);
                        Toast.makeText(getApplicationContext(),"Not Match", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        ((ImageView)view).setImageResource(drawable[pos[position]]);
                        countPair++;

                        if(countPair == 0){
                            Toast.makeText(getApplicationContext(),"You win", Toast.LENGTH_SHORT).show();
                        }
                    }

                    currentPos = -1;
                }
            }
        });
    }
}
