package com.ubicoo.shutdown;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;

public class Shutdown extends Activity implements OnErrorListener, DialogInterface.OnKeyListener {

	static final String TAG = Shutdown.class.getSimpleName();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(R.string.really_shutdown).setOnKeyListener(this).setCancelable(true)
				.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int id) {
						Shutdown.this.shutdown();
					}
				}).setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int id) {
						Shutdown.this.forceExit();
					}
				});
		AlertDialog alert = builder.create();
		alert.show();
	}

	private void shutdown() {
		new ShutdownThread(this).start();
	}

	@Override
	public void onNotRoot() {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				showNotRootedDialog();
			}
		});
	}

	@Override
	public void onError(final String msg) {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				showErrorDialog(msg);
			}
		});
	}

	@Override
	public void onError(final Exception exc) {
		final String msg = exc.getClass().getSimpleName() + ": " + exc.getMessage();
		onError(msg);
	}

	private void showErrorDialog(String msg) {
		AlertDialog.Builder builder = buildErrorDialog(msg);
		AlertDialog alert = builder.create();
		alert.show();
	}

	private void showNotRootedDialog() {
		final Uri uri = Uri.parse(getString(R.string.rooting_url));
		AlertDialog.Builder builder = buildErrorDialog(getString(R.string.not_rooted));
		builder.setNegativeButton(R.string.what, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				startActivity(new Intent(Intent.ACTION_VIEW, uri));
				Shutdown.this.forceExit();
			}
		});
		AlertDialog alert = builder.create();
		alert.show();
	}

	private AlertDialog.Builder buildErrorDialog(String msg) {
		return new AlertDialog.Builder(this).setMessage(msg).setOnKeyListener(this).setCancelable(true)
				.setNeutralButton(R.string.ok, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int id) {
						Shutdown.this.forceExit();
					}
				});
	}

	@Override
	public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			dialog.dismiss();
			forceExit();
			return true;
		}
		return false;
	}

	private void forceExit() {
		finish();
		Utils.killMyProcess();
	}

}