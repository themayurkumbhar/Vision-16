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


public class ipd extends Fragment implements View.OnClickListener {

    public ipd() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ipd, container, false);

        ImageView imageView1 = (ImageView) rootView.findViewById(R.id.cbimg);
        ImageView imageView2= (ImageView) rootView.findViewById(R.id.ucimg);
        TextView textView1= (TextView) rootView.findViewById(R.id.cb);
        TextView textView2= (TextView) rootView.findViewById(R.id.uk);
        textView1.setOnClickListener(this);
        textView2.setOnClickListener(this);
        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
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
                name = "awake.pdf";
                break;
            case R.id.ucimg:
            case R.id.uk:
                name="gquiz.pdf";
                break;
        }
        PdfReader pdfReader=new PdfReader(getContext());
        pdfReader.CopyReadAssets(name);
        startActivity(pdfReader.getIntet());
    }

}