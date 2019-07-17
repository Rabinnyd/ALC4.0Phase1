package com.rabinnyaundi.myapplication;

import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class AboutALCActivity extends AppCompatActivity {

    WebView webViewAboutALC;
    ProgressBar mProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);

        webViewAboutALC = findViewById(R.id.webView_AboutALC);
        mProgressBar = findViewById(R.id.progressWebView);

        webViewAboutALC.animate();

        WebSettings webSettings = webViewAboutALC.getSettings();
        webSettings.setDatabaseEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setJavaScriptEnabled(true);

        webViewAboutALC.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }
        });

        webViewAboutALC.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if(newProgress == 100){
                    mProgressBar.setVisibility(WebView.INVISIBLE);
                }else{
                    mProgressBar.setVisibility(WebView.VISIBLE);
                    mProgressBar.setProgress(newProgress);
                }
            }
        });

        webViewAboutALC.loadUrl("https://andela.com/alc");
    }
}
