package com.coreservlets.widgets;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class ListViewActivity  extends Activity implements OnItemClickListener {
    private String mPlantillaMensajeItemSelected;
    ListView lv;
    ArrayAdapter<String> listAdapter;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.listview);
        lv = (ListView) findViewById(R.id.listview);
        mPlantillaMensajeItemSelected = getString(R.string.plantilla_mensaje_listview);
        //ListView listv = (ListView)findViewById(R.id.listview);
        
        //List<String> futureAndroidVendors = getFutureAndroidVendors();
        //setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, futureAndroidVendors));
        //listadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //listv.setAdapter(listadapter);
        
        List<String> futureAndroidVendors = getFutureAndroidVendors();
        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, futureAndroidVendors);
        //listAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lv.setAdapter(listAdapter);
        lv.setOnItemClickListener(this);
        registerForContextMenu(lv);
        
    }
    
    private List<String> getFutureAndroidVendors() {
        String[] vendorArray = { "RIM", "Palm", "Nokia"};
        List<String> vendorList = Arrays.asList(vendorArray);
        Collections.shuffle(vendorList);
        return(vendorList);
    }
    
    
    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
    
    
    public void onItemClick(AdapterView<?> listv, View selectedView,
                                   int position, long id) {
                String selection = listv.getItemAtPosition(position).toString();
                String message =
                        String.format(mPlantillaMensajeItemSelected, selection);
                showToast(message);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_ctx, menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int position;

        AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()) {
            case R.id.menu_cont_op1:
                position = info.position;
                item.setTitle(item.getTitle().toString().toUpperCase());
                listAdapter.notifyDataSetChanged();
                return true;

            case R.id.menu_cont_op2:
                Toast.makeText(this, "Etiqueta: Opcion Contextual 3 pulsada!: Mostrar Toast", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }


}