package sg.edu.rp.c346.id19047433.demoexplicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HeroStatsActivity extends AppCompatActivity {
    TextView tvName, tvStrength, tvTechicalProwess;
    Button btnLike, btnDislike;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_stats);
        // get the intent
        Intent intent = getIntent();
        //get the hero object from first activity
        Hero hero = (Hero) intent.getSerializableExtra("hero");

        tvName = (TextView) findViewById(R.id.textViewName);
        tvStrength = (TextView) findViewById(R.id.textViewStrength);
        tvTechicalProwess = (TextView) findViewById(R.id.textViewTechnicalProwess);
        btnLike = findViewById(R.id.buttonLike);
        btnDislike = findViewById(R.id.buttonDislike);

        //use the getter of Hero object to get the attributes
        tvName.setText(hero.getName());
        tvStrength.setText("Strength: " + hero.getStrength());
        tvTechicalProwess.setText("Technical: " + hero.getTechnicalProwess());

        // When button Like is clicked, set the results accordingly and finish() to close this act.
        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create intent & pass in String data
                Intent i = new Intent();
                i.putExtra("like", "like");
                // Set result to RESULT_OK to indicate normal			// response and pass in the intent containing the 		// like
                setResult(RESULT_OK, i);
                finish();
            }
        });
        btnDislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create intent & pass in String data
                Intent i = new Intent();
                i.putExtra("like", "Dislike");
                // Set result to RESULT_OK to indicate normal			// response and pass in the intent containing the 		// like
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}