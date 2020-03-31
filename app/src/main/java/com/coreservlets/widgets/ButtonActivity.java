
package com.coreservlets.widgets;

import java.util.ArrayList;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.CheckBox;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ButtonActivity extends Activity {
	
    private String mPlantillaMensajeBoton;
    private String mPlantillaMensajeImageBoton;
    private String mPlantillaMensajeCheck;
    private String mPlantillaMensajeRadio;
    private String mPlantillaMensajeToggleBoton;

    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buttons); 
        mPlantillaMensajeBoton = getString(R.string.plantilla_mensaje_boton);
        mPlantillaMensajeCheck = getString(R.string.plantilla_mensaje_check);
        mPlantillaMensajeRadio = getString(R.string.plantilla_mensaje_radio);
        mPlantillaMensajeImageBoton = getString(R.string.plantilla_mensaje_imagebutton);
        mPlantillaMensajeToggleBoton = getString(R.string.plantilla_mensaje_togglebutton);
        RadioGroup radioGroup = findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(new RadioGroupInfo());
    }
    
    /** Makes a Toast showing the label of the Button, RadioButton, or CheckBox.
     *  ImageButtons do not have text, and are not subclasses of Button, so you
     *  cannot pass an ImageButton to this method.
     *  You need the muestraInfoImageButton method.
     */
    
    public void muestraTextoBoton(View clickedButton) { 
    	if ((clickedButton.getId() == R.id.botonhola) || (clickedButton.getId() == R.id.botonadios) || (clickedButton.getId() == R.id.botonchao)) {
        	Button button = (Button)clickedButton;
        	textoBoton(button);
    	}
    	else if ((clickedButton.getId() == R.id.checkhola) || (clickedButton.getId() == R.id.checkadios) || (clickedButton.getId() == R.id.checkchao)) { 
        	CheckBox check = (CheckBox)clickedButton;
        	textoCheck(check);
    	}
    }
    
    public void textoBoton(Button b) {
    	CharSequence text = b.getText();
        String message = String.format(mPlantillaMensajeBoton, text);
        showToast(message);
    }    
    	
    public void textoCheck(CheckBox check) { 
    	CharSequence text = check.getText();
    	String status;
    	if (check.isChecked())
    		status = "Habilitado";
    	else
    		status = "Deshabilitado";
    	String message = String.format(mPlantillaMensajeCheck, text, status);
    	showToast(message);
    }

     
    public void muestraInfoImageB (View clickedImageButton) {
    	String imageString="";
    	ImageButton imgb = (ImageButton) clickedImageButton;
    	switch (imgb.getId()) {
    	case (R.id.imagebutton1): 
    		imageString = getString(R.string.info_imagebutton_1);
    	    break;
    	case (R.id.imagebutton2):
    		imageString = getString(R.string.info_imagebutton_2);
    		break;
    	case (R.id.imagebutton3):
    		imageString = getString(R.string.info_imagebutton_3);
    		break;
    	case (R.id.imagebutton4):
    		imageString = getString(R.string.info_imagebutton_4);
    		break;
    	case (R.id.imagebutton5):
    		imageString = getString(R.string.info_imagebutton_5);
    		break;
    	case (R.id.imagebutton6):
    		imageString = getString(R.string.info_imagebutton_6);
    	}
        
        String message = String.format(mPlantillaMensajeImageBoton, imageString);
        showToast(message);
    }

    
    /** Makes a Toast showing whether you turned ToggleButton on or off. Also
     *  shows the resultant text (label).
     */
    
    public void muestraInfoToggleBoton(View clickedToggleButton) { 
        ToggleButton toggleButton = (ToggleButton)clickedToggleButton;
        String status;
        if (toggleButton.isChecked()) {
            status = "ON";
        } else {
            status = "OFF";
        }
        CharSequence label = toggleButton.getText();
        String message = String.format(mPlantillaMensajeToggleBoton, status, label);
        showToast(message);
    }
    
    
    private void showToast(String text) {
    	Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

  
    private class RadioGroupInfo implements OnCheckedChangeListener {

        private RadioButton mLastChecked;
        private String mPlantillaMensajeNuevaSeleccion;
        private String mPlantillaMensajeSeleccionCambiada;
        
        public RadioGroupInfo() {
        	mPlantillaMensajeNuevaSeleccion = getString(R.string.plantilla_mensaje_nuevaseleccion);
        	mPlantillaMensajeSeleccionCambiada = getString(R.string.plantilla_mensaje_seleccioncambiada);
        }
        
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            RadioButton newChecked = findViewById(checkedId);
            String message;
            if (mLastChecked == null) {
                message = String.format(mPlantillaMensajeNuevaSeleccion,
                                        newChecked.getText());
            } else {
                message = String.format(mPlantillaMensajeSeleccionCambiada,
                                        newChecked.getText(),
                                        mLastChecked.getText());
            }
            mLastChecked = newChecked;
            showToast(message);
        }
    }
}
