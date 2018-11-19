package com.hackathon.healthy;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Father_Fragment extends Fragment  implements View.OnClickListener{

    Button BSave;
   EditText fathername, fatheremail, fatherpass, fathercpass;

    private OnItemSelectedListener listener, messageSendListener;


        public interface OnItemSelectedListener {

            public void onRssItemSelected(int methodo);

            //public void onMessageneSend(String message);
        }


    public Father_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this f ragment
       View view= inflater.inflate(R.layout.fragment_father_, container, false);
       BSave =view.findViewById(R.id.salvar);
       fathername =view.findViewById(R.id.fathername);
       fatheremail=view.findViewById(R.id.fatheremail);
       fatherpass=view.findViewById(R.id.password);
       fathercpass =view.findViewById(R.id.confirrmarpassoword);

       String name=fatheremail.getText().toString();
       String email=fatheremail.getText().toString();
       String password=fathername.getText().toString();
       String cpassword=fathercpass.getText().toString();

       if(!(name.compareToIgnoreCase("") == 0 || email.compareToIgnoreCase("")==0 || password.compareToIgnoreCase("") ==0
               || cpassword.compareToIgnoreCase("")==0) )
        {
            Toast.makeText(getContext(), "Campos vazios", Toast.LENGTH_SHORT).show();
        }
     else

            BSave.setOnClickListener(this);

        return  view;

    }

    @Override
    public void onClick(View v) {

            listener.onRssItemSelected(3);

    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnItemSelectedListener) {
            listener = (OnItemSelectedListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement MyListFragment.OnItemSelectedListener");
        }
    }
}
