package com.mayur.kumbhar.vision;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class technozian extends Fragment implements View.OnClickListener {

    public technozian() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_technozian, container, false);

        ImageView imageView1 = (ImageView) rootView.findViewById(R.id.cbimg);
        ImageView imageView2= (ImageView) rootView.findViewById(R.id.webimg);
        ImageView imageView3 = (ImageView) rootView.findViewById(R.id.ucimg);
        ImageView imageView4 = (ImageView) rootView.findViewById(R.id.wshimg);
        ImageView imageView5= (ImageView) rootView.findViewById(R.id.quzimg);
        TextView textView5= (TextView) rootView.findViewById(R.id.quiz);
        TextView textView1= (TextView) rootView.findViewById(R.id.cb);
        TextView textView2= (TextView) rootView.findViewById(R.id.web);
        TextView textView3= (TextView) rootView.findViewById(R.id.uk);
        TextView textView4= (TextView) rootView.findViewById(R.id.wshp);
        textView5.setOnClickListener(this);
        imageView5.setOnClickListener(this);
        textView1.setOnClickListener(this);
        textView2.setOnClickListener(this);
        textView3.setOnClickListener(this);
        textView4.setOnClickListener(this);
        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
        imageView4.setOnClickListener(this);
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
                name = "cannon.pdf";
                break;
            case R.id.ucimg:
            case R.id.uk:
                name="hydralic.pdf";
                break;
            case R.id.webimg:
            case R.id.web:
                name="tstruct.pdf";
                break;
            case R.id.wshimg:
            case R.id.wshp:
                name="town.pdf";
                break;
            case R.id.quzimg:
            case R.id.quiz:
                name="quiz.pdf";
                break;
        }
        PdfReader pdfReader=new PdfReader(getContext());
        pdfReader.CopyReadAssets(name);
        startActivity(pdfReader.getIntet());
    }

}