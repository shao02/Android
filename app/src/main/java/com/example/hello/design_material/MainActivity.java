package com.example.hello.design_material;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hello.design_material.domain.BroadcastMsg;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<BroadcastMsg> broadcastMsg = LoadedData.broadcastMsg;
    private BroadCastMsgsAdapter adapter;
    private RecyclerView recyclerView;
    private int currentMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        recyclerView = (RecyclerView) findViewById(R.id.broadcast_msgs_view);
        adapter = new BroadCastMsgsAdapter(broadcastMsg);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        EditText editText = (EditText) findViewById(R.id.edit_post);
        currentMenu = R.id.chat_latest;
        Log.d("STATE","Hello, this is Shao");
        OnFocusChangeListioner ofcListener = new OnFocusChangeListioner();
        editText.setOnFocusChangeListener(ofcListener);
    }

    public void onPost(View view){
        Log.d("STATE","Hello, this is lalee message");
        EditText content = (EditText) findViewById(R.id.edit_post);
        if(content.getText().toString() == null || content.getText().toString().isEmpty()) return;
        broadcastMsg.add(0,new BroadcastMsg(content.getText().toString(),
                "Now",
                "lee",
                "lalee","M"));
        if(currentMenu == R.id.chat_latest){
            adapter.notifyItemInserted(0);
            recyclerView.scrollToPosition(0);
        }else if(currentMenu == R.id.chat_my){
            adapter.updateList(LoadedData.getMyList());
        }else{
            adapter.updateList(LoadedData.getPopularList());
        }

        if (this.getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

        Context context = getApplicationContext();
        CharSequence text = "Message sent";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        content.setText(null);
    }

    public void chatMenuSwitch(View view){
        if(currentMenu == view.getId()) return;
        currentMenu = view.getId();
        Button latest = (Button) findViewById(R.id.chat_latest);
        Button my = (Button) findViewById(R.id.chat_my);
        Button popular = (Button) findViewById(R.id.chat_popular);
        popular.setTypeface(null, Typeface.NORMAL);
        latest.setTypeface(null, Typeface.NORMAL);
        my.setTypeface(null, Typeface.NORMAL);
        switch(view.getId()) {
            case R.id.chat_latest:
                latest.setTypeface(null, Typeface.BOLD);
                adapter.updateList(LoadedData.broadcastMsg);
                break;
            case R.id.chat_my:
                my.setTypeface(null, Typeface.BOLD);
                adapter.updateList(LoadedData.getMyList());
                break;
            case R.id.chat_popular:
                adapter.updateList(LoadedData.getPopularList());
                popular.setTypeface(null, Typeface.BOLD);
                break;
        }
        adapter.notifyDataSetChanged();
    }

    private class OnFocusChangeListioner implements View.OnFocusChangeListener {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            Log.d("STATE","Hello, this is Shao");
            if(v.getId() == R.id.edit_post && !hasFocus) {
                InputMethodManager imm =  (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
        }
    }
}
