package com.imaisolutions.cursos.ols2.holamundoconrecursos;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class ejemplorotacion extends Activity {
	Button btn;
	ImageView imgview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.ejemplo);
		// Instancia del Bot�n
		btn=(Button)this.findViewById(R.id.btnrotacion);
		imgview=(ImageView)this.findViewById(R.id.imgarotar);
		Log.i("MIAPP","ESTO ES UN EJEMPLO DE GRABAR EN LOG");
		// Definimos el evento

        // CAMBIOS DE HOY.. (PRUEBA)

		btn.setOnClickListener(
				new OnClickListener(){

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
					      
						Animation rotacion = AnimationUtils.loadAnimation(
									ejemplorotacion.this, 
									R.anim.anim2);
						
						imgview.startAnimation(rotacion);
					}
				}
		);
	}

}
