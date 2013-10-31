package com.appsforchange.taxi;

// Google.com/+JamieSmith - Apps for Change - dubyajaysmith@gmail.com - NerdArt.co

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// Set up imageButton
        ImageButton taxiButton = (ImageButton) findViewById(R.id.imageButton);

// Set up click listener
        taxiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

// What happens when imageButton is clicked
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, (getString(R.string.query)));
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_about:
                showAbout();
                return true;
            case R.id.action_settings:
                showSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showSettings() {
        Crouton.makeText(this, R.string.settingText, Style.INFO).show();
    }

    public void showAbout() {
        Crouton.makeText(this, R.string.aboutText, Style.INFO).show();
    }

}