package com.appsforchange.taxi;

// Jamie Smith (Apps for Change(dubyajaysmith@gmail.com))
// (^_^) Have a great one! (^_^)

// Set up imageButton (done)
//Set up onClickListener (done)
//set up Google query & set to string (done... for the most part)
// TODO: find number in query & set to string
// TODO: dial that number aka string

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
//import android.content.DialogInterface;
//import android.view.WindowManager;
//import android.view.Window;


public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


// set up imageButton
        ImageButton taxiButton = (ImageButton) findViewById(R.id.imageButton);
//set up listener
        taxiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // What happens when imageButton is clicked
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                //String query;
                intent.putExtra(SearchManager.QUERY, (getString(R.string.query)));
                startActivity(intent);
                //set query results as a String named queryString
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

//setContentView(R.layout.activity_main);
//String toast = (getString(R.string.query));
//Toast toast2 = Toast.makeText(new String(R.string.toast1);
