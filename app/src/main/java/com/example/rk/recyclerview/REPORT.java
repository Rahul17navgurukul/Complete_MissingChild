package com.example.rk.recyclerview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class REPORT extends Fragment {

    private DatabaseReference mCmmentData;
    private TextView comment_box;


    public REPORT() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_report, container, false);
        mCmmentData = FirebaseDatabase.getInstance().getReference().child("Comment");

        comment_box = view.findViewById(R.id.commet_show);

        mCmmentData.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    String child = ds.getClass(mCmmentData.getClass());
                    Log.d("TAG", child);

                    comment_box.setText(child);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

//       String data = mCmmentData.getRef().getRoot();
//       comment_box.setText(data);
//
//
        return view;

    }

}
