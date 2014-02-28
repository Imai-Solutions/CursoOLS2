package com.imaisolutions.cursos.ols2.MiPrimeraActividad;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MiPrimeraActividad extends Activity {

	public Button btnLanzarDlg;
	public Button btnLanzarActividad;
	public ListView lstView;
	private ArrayAdapter<String> _data;
	final String INFO = "[CURSO OLS2 - PRÁCTICA 3]";
	final int DOWORK_REQUEST = 1; // REALIZAR TAREA X

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initializeComponents();
		Log.i(INFO, "On Create");
	}

	private void initializeComponents() {
		btnLanzarDlg = (Button) findViewById(R.id.btnLanzarDlg);
		btnLanzarActividad = (Button) findViewById(R.id.btnAbrirActividad);
		lstView = (ListView) findViewById(R.id.lstEstados);
		this.btnLanzarDlg.setOnClickListener(this.OnClickbtnLanzarDlg);
		this.btnLanzarActividad
				.setOnClickListener(this.OnClickbtnLanzarActividad);
		_data = new ArrayAdapter<String>(this, R.layout.item, R.id.itemName);
		_data.add("INICIO DE ACTIVIDAD...");
		lstView.setAdapter(_data);
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == DOWORK_REQUEST) {
			if (resultCode == RESULT_OK) {
				Log.i(INFO, "RESULTADO DEVUELTO SEGUNDA ACTIVIDAD");
				_data.add("DEVOLUCIÓN SEGUNDA ACTIVIDAD");
			}
		}
	}

	// Evento Lanzar Diálogo al pulsar el botón.
	private OnClickListener OnClickbtnLanzarDlg = new OnClickListener() {
		public void onClick(View v) {
			AlertDialog dlg = (AlertDialog) DlgSalirAplicacion
					.create(MiPrimeraActividad.this);
			dlg.show();
			_data.add("LANZADO DIÁLOGO");
		}
	};

	// Evento Lanzar Actividad al pulsar el botón.
	private OnClickListener OnClickbtnLanzarActividad = new OnClickListener() {
		public void onClick(View v) {
			Intent myIntent = new Intent(v.getContext(),
					MiSegundaActividad.class);
			startActivityForResult(myIntent, DOWORK_REQUEST);
			_data.add("LANZADA ACTIVIDAD");
		}
	};
	
	@Override
	public void onResume() {
		Log.i(INFO, "On Resume");
		super.onResume();

	}

	@Override
	public void onRestart() {
		Log.i(INFO, "On Restart");
		super.onRestart();
	}

	@Override
	protected void onPause() {
		Log.i(INFO, "On Pause");
		super.onPause();
	}

	@Override
	protected void onStop() {
		Log.i(INFO, "On Stop");
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		Log.i(INFO, "On Destroy");
		super.onDestroy();
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		Log.i(INFO, "On Start");
		super.onStart();
	}

}