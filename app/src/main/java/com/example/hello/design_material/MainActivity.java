package com.example.hello.design_material;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.example.hello.design_material.domain.BroadcastMsg;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<BroadcastMsg> broadcastMsg = new ArrayList<BroadcastMsg>();
    private BroadCastMsgsAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        broadcastMsg.add (new BroadcastMsg("I am a basketball superstar, wanna play ball together?",
                "2 hours ago",
                "Kevin Garnett",
                "profile"));
        broadcastMsg.add(new BroadcastMsg("i am miss hong kong, i am 25 years old" +
                ", i want to visit new york,where can i go, i am boring, very very boring, new to this nice app",
                "1 hours ago",
                "Lai ik",
                "pic1"));
        broadcastMsg.add(new BroadcastMsg("i want to go for a party",
                "1 hours ago",
                "wong lee",
                "pic2"));
        broadcastMsg.add( new BroadcastMsg("i want to walk around...",
                "30 mins ago",
                "kevin wang",
                "pic3"));
        broadcastMsg.add(new BroadcastMsg("i want to walk around...",
                "30 mins ago",
                "kevin wang",
                "pic3"));
        broadcastMsg.add(new BroadcastMsg("i want to walk around...",
                "30 mins ago",
                "kevin wang",
                "pic3"));
        broadcastMsg.add(new BroadcastMsg("i want to walk around...",
                "30 mins ago",
                "kevin wang",
                "pic3"));
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        recyclerView = (RecyclerView) findViewById(R.id.broadcast_msgs_view);
        adapter = new BroadCastMsgsAdapter(broadcastMsg);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        EditText editText = (EditText) findViewById(R.id.edit_post);
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
                "wong lee",
                "lalee"));
        adapter.notifyItemInserted(0);
        recyclerView.scrollToPosition(0);

        if (this.getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
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
