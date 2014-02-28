package com.imaisolutions.cursos.ols2.MiPrimeraActividad;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class DlgSalirAplicacion {

	public static String _msg="¿Quieres salir?";
	
	public static Activity sender;
	private static AlertDialog builder(Context context, String l_msg) {
		// El diálogo recupera la referencia de la Actividad origen.
		sender=(Activity)context;
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setMessage(l_msg)      
			.setCancelable(false)       
			.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			   	public void onClick(DialogInterface dialog, int id) {                
			   		DlgSalirAplicacion.sender.finish();           }       })
			.setNegativeButton("No", new DialogInterface.OnClickListener() {           
			   	public void onClick(DialogInterface dialog, int id) {               
			   		dialog.cancel(); 
			   	}
			});
		return builder.create();
	}
	
	public static AlertDialog create(Context context){
		return builder(context,_msg);
	}
	
	public static AlertDialog create(Context context, String msg)
	{
		return builder(context,msg);
	}
	
}
	
