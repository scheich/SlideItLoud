/***
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package de.mangelow.slideitloud;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;

public class Helper {

	public final boolean ENABLED = false;
	public final boolean AUTOANSWER = false;
	public final boolean AUTOHANGUP = false;
	
	public boolean isMyServiceRunning(Context context) {
		ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
		for (RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
			if ("de.mangelow.slideitloud.Service".equals(service.service.getClassName())) {
				return true;
			}
		}
		return false;
	}
	public boolean isHardwareKeyboardAvailable(Context context) { 
		return context.getResources().getConfiguration().keyboard != Configuration.KEYBOARD_NOKEYS; 
	}
	public void saveBooleanPref(Context context,String prefix, boolean bvalue) {
		SharedPreferences.Editor prefs = context.getSharedPreferences("Prefs", 0).edit();
		prefs.putBoolean(prefix, bvalue);
		prefs.commit();
	}
	public Boolean loadBooleanPref(Context context, String prefix, boolean defaultvalue) {
		SharedPreferences prefs = context.getSharedPreferences("Prefs", 0);
		boolean bpref = prefs.getBoolean(prefix, defaultvalue);
		return bpref;
	}
}
