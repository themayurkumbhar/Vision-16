package com.mayur.kumbhar.vision;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class ExpotechFragment extends Fragment implements View.OnClickListener {
 
    public ExpotechFragment() {
        // Required empty public constructor
    }
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 
    }
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.expotech, container, false);
        ImageView imageView1 = (ImageView) rootView.findViewById(R.id.cbimg);
        ImageView imageView2= (ImageView) rootView.findViewById(R.id.webimg);
        ImageView imageView3 = (ImageView) rootView.findViewById(R.id.ucimg);
        TextView textView1= (TextView) rootView.findViewById(R.id.cb);
        TextView textView2= (TextView) rootView.findViewById(R.id.web);
        TextView textView3= (TextView) rootView.findViewById(R.id.uk);

        textView1.setOnClickListener(this);
        textView2.setOnClickListener(this);
        textView3.setOnClickListener(this);
        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);


        // Inflate the layout for this fragment
        return rootView;
    }
 
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }
 
    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View view) {
        String name = "";
        switch (view.getId()) {
            case R.id.cbimg:
            case R.id.cb:
                name = "amortecedor.pdf";
                break;
            case R.id.ucimg:
            case R.id.uk:
                name="commerciante.pdf";
                break;
            case R.id.webimg:
            case R.id.web:
                name="technokreis.pdf";
                break;
        }
        PdfReader pdfReader=new PdfReader(getContext());
        pdfReader.CopyReadAssets(name);
        startActivity(pdfReader.getIntet());
    }
}