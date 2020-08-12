package com.example.symbols;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    SymbolAdapter adapter;
    ArrayList<Symbol>mData=new ArrayList<>();
    LinearLayoutManager layoutManager;
    EditText search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        search=findViewById(R.id.search_et);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(search.getText().toString());
            }
        });
        //init data
        mData.add(new Symbol("AP","خارق للدروع"));
        mData.add(new Symbol("AP-T","خارق للدروع خطاط"));
        mData.add(new Symbol("API-T","حارق خارق للدروع-خطاط"));
        mData.add(new Symbol("APERS","ضد الافراد"));
        mData.add(new Symbol("CP","خارق للخرسانة مضاد للملاجئ"));
        mData.add(new Symbol("HE","شديد الانفجار"));
        mData.add(new Symbol("HEAT","مضاد للدببابات شديد الانفجار"));
        mData.add(new Symbol("BD","صاعق خلفي"));
        mData.add(new Symbol("MT","مؤقت ميكانيكي"));
        mData.add(new Symbol("MTSQ","مؤقت ميكانيكي سريع جدا"));
        mData.add(new Symbol("PD","انفجار لحظي"));
        mData.add(new Symbol("PDSD","افجار على الصدمة مع تدمير ذاتي"));
        mData.add(new Symbol("PIBD","بادئ من المقدمة منفجر من القاعدة"));
        mData.add(new Symbol("SQ","لحظي سريع جدا"));
        mData.add(new Symbol("VT","تقاربي"));
        //recyclerview process
        recyclerView =  findViewById(R.id.recycler_view_all_vocabs);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new SymbolAdapter(mData,this);
        recyclerView.setAdapter(adapter);

    }
    private void filter(String text) {
        ArrayList<Symbol> filteredList = new ArrayList<>();
        for (Symbol item : mData) {
            if (item.symbol.trim().toLowerCase().contains(text.trim().toLowerCase())) {
                filteredList.add(item);
            }
        }
        adapter.filterList(filteredList);
    }
}