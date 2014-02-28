package com.imaisolutions.cursos.ols2.holamundoconrecursos;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

	Button btn;
	TextView lblMensaje;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lblMensaje=(TextView)findViewById(R.id.textView1);
		btn=(Button)this.findViewById(R.id.button1);
		btn.setOnClickListener(
				new OnClickListener(){

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Resources res=arg0.getResources();
						lblMensaje.setText(res.getText(R.string.mensaje_recurso));
						lblMensaje.setBackgroundResource(R.color.color_mensaje);
					}
				}
		);

	}
	
	public void iniciarAnimacion(View arg){
		Animation hyperspaceJump = AnimationUtils.loadAnimation
													(this, 
													R.anim.saltoalhiperespacio);
		arg.startAnimation(hyperspaceJump);
	
		ImageView img=(ImageView)this.findViewById(R.id.imageView1);
		Animation rotacion = AnimationUtils.loadAnimation
				(this, 
				R.anim.anim2);
		img.startAnimation(rotacion);

	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
