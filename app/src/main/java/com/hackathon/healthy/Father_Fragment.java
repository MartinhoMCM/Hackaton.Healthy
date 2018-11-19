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

   private OnItemSelectedListener onSendMessege;
    private OnItemSelectedListener listener, messageSendListener;


        public interface OnItemSelectedListener {

            public void onRssItemSelected(String fathername, String fatheremail, String fatherpass);

        }


    public Father_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


       View view= inflater.inflate(R.layout.fragment_father_, container, false);
       BSave =view.findViewById(R.id.salvar);
       fathername =view.findViewById(R.id.fathername);
       fatheremail=view.findViewById(R.id.fatheremail);
       fatherpass=view.findViewById(R.id.password);
       fathercpass =view.findViewById(R.id.confirrmarpassoword);

       BSave.setOnClickListener(this);
        return  view;
    }

    @Override
    public void onClick(View v) {


            if(!(fathername.getText().toString().compareToIgnoreCase("")==0 || fatheremail.getText().toString().compareToIgnoreCase("")==0 ||
                    fatherpass.getText().toString().compareToIgnoreCase("")==0 || fatherpass.getText().toString().compareToIgnoreCase("")==0))
            {
              if(fatherpass.getText().toString().equals(fathercpass.getText().toString()))
              {
                  listener.onRssItemSelected(fathername.getText().toString(), fatheremail.getText().toString(), fatherpass.getText().toString());
              }
              else
              {
                  Toast.makeText(getContext(), "As palavras passe não combinam", Toast.LENGTH_SHORT).show();
              }
            }
            else
            {
                Toast.makeText(getContext(), "Por favor, preencha os campos vazios", Toast.LENGTH_SHORT).show();
            }
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

    @Override
    public void onResume() {
        super.onResume();
        fathername.setText("");
        fatheremail.setText("");
        fatherpass.setText("");
        fathercpass.setText("");
    }
}
