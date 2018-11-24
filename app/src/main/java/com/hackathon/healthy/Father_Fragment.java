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
   EditText father_name, mother_name, user_email, user_password, user_cpassword, morada, user_name;

   private OnItemSelectedListener onSendMessege;
    private OnItemSelectedListener listener, messageSendListener;


        public interface OnItemSelectedListener {

            public void onRssItemSelected(String father_name, String mother_name,String user_name, String morada, String user_email, String user_password );

        }

    public Father_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


       View view= inflater.inflate(R.layout.fragment_father_, container, false);
       BSave =view.findViewById(R.id.salvar);

       father_name =view.findViewById(R.id.father_name);
       mother_name = view.findViewById(R.id.mother_name);
       user_email =view.findViewById(R.id.user_email);
       user_name =view.findViewById(R.id.user_name);
       morada =view.findViewById(R.id.morada);
       user_password =view.findViewById(R.id.user_password);
       user_cpassword =view.findViewById(R.id.confirrmarpassoword);
       BSave.setOnClickListener(this);
        return  view;
    }

    @Override
    public void onClick(View v) {

            if(father_name.getText().toString().equals("") || mother_name.getText().toString().equals("") || user_name.getText().toString().equals("") ||
     morada.getText().toString().equals("") ||  user_email.getText().toString().equals("") || user_password.getText().toString().equals("") || user_cpassword.getText().toString().equals(""))
            {
                Toast.makeText(getContext(), "Campos vazios, por favor preencha", Toast.LENGTH_SHORT).show();
            }
            else {
                if(user_password.getText().toString().equals(user_cpassword.getText().toString())) {
                    listener.onRssItemSelected(father_name.getText().toString(), mother_name.getText().toString(), user_name.getText().toString(),
                            morada.getText().toString(), user_email.getText().toString(), user_password.getText().toString());
                }
                else{
                    Toast.makeText(getContext(), "As palavras passes não combinam", Toast.LENGTH_SHORT).show();
                    user_password.setText("");
                    user_cpassword.setText("");
                   }
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

}
