package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Main2Activity extends AppCompatActivity {

    WebView wvWebPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        wvWebPage = findViewById(R.id.webView);
        wvWebPage.setWebViewClient(new WebViewClient());

        wvWebPage.getSettings().setJavaScriptEnabled(true);
        wvWebPage.getSettings().setAllowFileAccess(false);
        wvWebPage.getSettings().setBuiltInZoomControls(true);
        Intent intentReceive = getIntent();
        String url = intentReceive.getStringExtra("url");

        wvWebPage.loadUrl(url);
    }
}
