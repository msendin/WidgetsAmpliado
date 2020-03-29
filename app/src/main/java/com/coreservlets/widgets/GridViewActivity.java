package com.coreservlets.widgets;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class GridViewActivity extends Activity {
    private String mPlantillaMensajeItemSelected;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview);
        mPlantillaMensajeItemSelected = getString(R.string.plantilla_mensaje_gridview);
        
        List<String> futureAndroidVendors = getFutureAndroidVendors();
        ArrayAdapter<String> gridAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, futureAndroidVendors);
        //gridAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // encara q és mètode de ArrayAdapter, només té efecte en Spinners. En ListView i GridView només té efecte en pas a) 2.
        GridView gridv = (GridView)findViewById(R.id.gridview);
        gridv.setAdapter(gridAdapter);
        gridv.setOnItemClickListener(new GridViewInfo());
        
    }
    
    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
   

    private List<String> getFutureAndroidVendors() {
        String[] vendorArray = { "Acer", "Dell", "HTC", "Huawei", "Kyocera", "LG", "Motorola", "Nexus", "Samsung", "Sony Ericsson", "T-Mobile", "Neptune" };
        List<String> vendorList = Arrays.asList(vendorArray);
        Collections.shuffle(vendorList);
        return(vendorList);
    }
    
    private class GridViewInfo implements OnItemClickListener {
        
        /** Shows a Toast for the selected item. Ignored the very first time,
         *  which is when the item is selected on initial display, rather than
         *  by user interaction.
         */
        @Override
        public void onItemClick(AdapterView<?> gridv, View selectedView, 
                                   int selectedIndex, long id) {
                String selection = gridv.getItemAtPosition(selectedIndex).toString();
                String message =
                        String.format(mPlantillaMensajeItemSelected, selection);
                showToast(message);
            }
    }
}