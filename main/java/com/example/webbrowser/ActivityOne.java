package com.example.webbrowser;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class ActivityOne extends AppCompatActivity {
    WebView web1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        web1=findViewById(R.id.web_et);
        if(getIntent()!= null) {
            String info = getIntent().getStringExtra("info");
            WebSettings settings = web1.getSettings();
            settings.setJavaScriptEnabled(true);
            web1.setWebViewClient(new WebViewClient());
            web1.loadUrl(info);
        }
    }

    @Override
    public void onBackPressed() {
        if(web1.canGoBack()){
            web1.goBack();
        }
        else
        {
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setTitle("Attention!!!");
            builder.setMessage("Do you want to exit?");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            builder.create().show();
        }
    }
}
