package com.linuxjet.wirelesstap.receivers;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;

/**
 * Created with IntelliJ IDEA.
 * User: jamespet
 * Date: 9/3/12
 * Time: 7:58 PM
 */
public class OutgoingCallReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();

        if(null == bundle)
            return;

        String phonenumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
        ContentResolver resolver = context.getContentResolver();
        Uri uri = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(phonenumber));
        Cursor cursor = resolver.query(uri, new String[]{ContactsContract.PhoneLookup.DISPLAY_NAME, ContactsContract.PhoneLookup._ID}, null, null, null);

        cursor.moveToFirst();
        Log.i("OutgoingCallReceiver", phonenumber);
        Log.i("OutgoingCallReceiver", bundle.toString());
        Log.i("OutgoingCallReceiver", cursor.getString(cursor.getColumnIndex(ContactsContract.PhoneLookup.DISPLAY_NAME)));

        //String info = "Detect Calls sample application\nOutgoing number: " + phonenumber;

        //Toast.makeText(context, info, Toast.LENGTH_LONG).show();
    }
}