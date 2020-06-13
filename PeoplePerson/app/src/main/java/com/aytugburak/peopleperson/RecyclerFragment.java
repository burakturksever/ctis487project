package com.aytugburak.peopleperson;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
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

    RecyclerView recyclerContacts;
    DatabaseHelper dbHelper;

    public RecyclerFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dbHelper = new DatabaseHelper(getActivity());
        ClassList.data = (ArrayList<Contact>)ContactDB.getAllContacts(dbHelper);
        recyclerContacts = (RecyclerView) view.findViewById(R.id.recyclerContacts);
        RVAdapter adapter = new RVAdapter(getActivity());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerContacts.setLayoutManager(layoutManager);
        recyclerContacts.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recycler, container, false);
    }
}