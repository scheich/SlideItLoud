package de.mangelow.slideitloud;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class Receiver extends BroadcastReceiver {

	private final String TAG = "SIL";
	private final boolean D = true;

	private Helper mHelper = new Helper();
	
	@Override
	public void onReceive(Context context, Intent intent) {
		if(D)Log.d(TAG, "onReceive()");

		if( "android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {
			if(D)Log.d(TAG, "BOOT_COMPLETED");

			final boolean enabled = mHelper.loadBooleanPref(context, "enabled", mHelper.ENABLED);
			if(enabled) {
				Log.i(TAG, "Enable Service");

				Intent serviceIntent = new Intent(context,Service.class);
				context.startService(serviceIntent);
			}
		}
	}
}
