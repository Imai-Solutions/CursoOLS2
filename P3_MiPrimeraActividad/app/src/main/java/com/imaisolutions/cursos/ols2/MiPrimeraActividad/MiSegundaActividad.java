package com.imaisolutions.cursos.ols2.MiPrimeraActividad;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MiSegundaActividad extends Activity {
	private ProgressBar mProgress;
	private TextView lblValue;
	private int mProgressStatus = 0;
	private Handler mHandler = new Handler();

	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.segundaactividad);
		mProgress = (ProgressBar) findViewById(R.id.ProgressBar01);
		lblValue = (TextView) findViewById(R.id.lblValueProgressBar);

		// Inicio de la operaci�n en segundo plano.
		new Thread(new Runnable() {
			public void run() {
				while (mProgressStatus < 100) {
					mProgressStatus = doWork();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					// Actualizar la interfaz.
					// Env�o de ejecuci�n al hilo principal de ejecuci�n.
					mHandler.post(new Runnable() {
						public void run() {
							mProgress.setProgress(mProgressStatus);
							lblValue.setText(String.valueOf(mProgressStatus));
						}
					});
				}

				// Finalizada la tarea.
				// Env�o del mensaje de retorno.
				Intent intent = new Intent();
				setResult(RESULT_OK, intent);
				finish();

			}

			// Este m�todo simplemente incrementa el valor de un contador.
			int i = 0;

			private int doWork() {
				return i++;
			}
		}).start();
	}
}
