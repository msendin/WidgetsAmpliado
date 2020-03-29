package com.coreservlets.widgets;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;



public class WidgetsInitialActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    
    /** Switches to the ButtonActivity when the associated button is clicked. */
    
    public void muestraBotones (View clickedButton) {
    	Intent in = new Intent(this, ButtonActivity.class);
        startActivity(in);
    }
    
    /** Switches to the SpinnerActivity when the associated button is clicked. */
    
    public void muestraSpinners(View clickedButton) {
    	Intent in = new Intent(this, SpinnerActivity.class);
        startActivity(in);
    }
    
    public void muestraListView(View clickedButton) {
    	Intent in = new Intent(this, ListViewActivity.class);
        startActivity(in);
    }
    
    public void muestraGridView(View clickedButton) {
    	Intent in = new Intent(this, GridViewActivity.class);
    	in.putExtra("contador", 2);   	
    	startActivity(in);
    }
}