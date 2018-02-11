package com.phponacid.lineblockerconcept1;

import android.app.Activity;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.provider.BlockedNumberContract;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void blockFunction(View v) {
        EditText phoneNumberEditText = (EditText) findViewById(R.id.phoneNumberEditText);
        String phoneNumberStr;
        phoneNumberStr = phoneNumberEditText.getText().toString();
        String longFormNumberStr;
        longFormNumberStr = "+1" + phoneNumberStr;

        ContentValues values = new ContentValues();
        values.put(BlockedNumberContract.BlockedNumbers.COLUMN_ORIGINAL_NUMBER, phoneNumberStr);
        values.put(BlockedNumberContract.BlockedNumbers.COLUMN_E164_NUMBER, longFormNumberStr);
        Uri uri = getContentResolver().insert(BlockedNumberContract.BlockedNumbers.CONTENT_URI, values);
    }

    public void unBlockFunction(View v) {
        EditText phoneNumberEditText = (EditText) findViewById(R.id.phoneNumberEditText);
        String phoneNumberStr;
        phoneNumberStr = phoneNumberEditText.getText().toString();
        String longFormNumberStr;
        longFormNumberStr = "+1" + phoneNumberStr;

        ContentValues values = new ContentValues();
        values.put(BlockedNumberContract.BlockedNumbers.COLUMN_ORIGINAL_NUMBER, phoneNumberStr);
        values.put(BlockedNumberContract.BlockedNumbers.COLUMN_E164_NUMBER, longFormNumberStr);
        Uri uri = getContentResolver().insert(BlockedNumberContract.BlockedNumbers.CONTENT_URI, values);
        getContentResolver().delete(uri, null, null);
    }
}
