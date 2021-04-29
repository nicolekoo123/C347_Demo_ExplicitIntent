package sg.edu.rp.c346.id19047433.demoexplicitintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int requestCodeForSupermanStats = 1;
    int requestCodeForBatmanStats = 2;
    TextView tvSuperman, tvBatman;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvSuperman = (TextView) findViewById(R.id.textViewSuperman);
        tvBatman = (TextView) findViewById(R.id.textViewBatman);

        //Set OnclickListener to handle the clicking of Superman textView
        tvSuperman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create Hero object of strength 100 & technical 60
                Hero superman = new Hero("Superman", 100, 60);
                Intent intent = new Intent(MainActivity.this, HeroStatsActivity.class);
                //Put the Hero Object into the Intent
                intent.putExtra("hero", superman);
                //Start activity with requestCodeForSupermanStats to identify it was started by clicking on superman
                startActivityForResult(intent, requestCodeForSupermanStats);
            }
        });
        //Set OnclickListener to handle the clicking of Batman textView
        tvBatman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create Hero object of strength 60 & technical 60
                Hero batman = new Hero("Batman", 60, 60);
                Intent intent = new Intent(MainActivity.this, HeroStatsActivity.class);
                //Put the Hero Object into the Intent
                intent.putExtra("hero", batman);
                //Start activity with requestCodeForBatmanStats to identify it was started by clicking on Batman
                startActivityForResult(intent, requestCodeForBatmanStats);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //only handle when 2nd activity closed normally and data contains something
        if (resultCode == RESULT_OK) {
            if (data != null) {
                //Get data passed back from 2nd activity
                String like = data.getStringExtra("like");
                String statement = "";
                // If it is activity started by clicking Superman, create corresponding String
                if(requestCode == requestCodeForSupermanStats){
                    statement = "You " + like + " Superman";
                }
                // If 2nd activity started by clicking Batman, create a corresponding String
                if(requestCode == requestCodeForBatmanStats){
                    statement = "You " + like + " Batman";
                }
                Toast.makeText(MainActivity.this, statement, Toast.LENGTH_SHORT).show();
            }
        }
    }
}