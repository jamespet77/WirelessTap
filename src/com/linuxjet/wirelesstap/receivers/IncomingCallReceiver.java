package com.linuxjet.wirelesstap.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.nfc.Tag;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Created with IntelliJ IDEA.
 * User: jamespet
 * Date: 9/2/12
 * Time: 4:30 PM
 */
public class IncomingCallReceiver extends BroadcastReceiver {
    private static final String TAG = "IncomingCallReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();

        if(null == bundle)
            return;

        Log.i("IncomingCallReceiver",bundle.toString());

        String state = bundle.getString(TelephonyManager.EXTRA_STATE);

        Log.i("IncomingCallReceiver","State: "+ state);

        if(state.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_RINGING))
        {
            String phonenumber = bundle.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);

            Log.i("IncomingCallReceiver","Incoming Number: " + phonenumber);

            //String info = "Detect Calls sample application\nIncoming number: " + phonenumber;

            //Toast.makeText(context, info, Toast.LENGTH_LONG).show();
        }
    }
}
