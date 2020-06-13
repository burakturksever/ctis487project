package com.aytugburak.peopleperson;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aytugburak.peopleperson.R;
import com.aytugburak.peopleperson.classes.ClassList;
import com.aytugburak.peopleperson.classes.Contact;
import com.aytugburak.peopleperson.classes.ContactDB;
import com.aytugburak.peopleperson.classes.DatabaseHelper;
import com.aytugburak.peopleperson.classes.RVAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecyclerFragment extends Fragment {

    Context context;

    RecyclerView recyclerContacts;
    SQLiteDatabase db;
    List<Contact> data;
    DatabaseHelper dbHelper;

    public RecyclerFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dbHelper = new DatabaseHelper(this);//sorun çıkabilir
        data = ContactDB.getAllContacts(dbHelper);
        recyclerContacts = (RecyclerView) view.findViewById(R.id.recyclerContacts);

        ClassList.data = (ArrayList<Contact>) data;
        RVAdapter adapter = new RVAdapter(this);//sorun çıkabilir 2
        recyclerContacts.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = container.getContext();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recycler, container, false);
    }
}