package com.r222102526.cuaca;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GpsActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Pastikan Anda memiliki R.layout.activity_gps yang didefinisikan dalam proyek Anda
        setContentView(R.layout.activity_gps);
        webView = findViewById(R.id.wvMain); // Pastikan wvMain adalah ID WebView Anda di activity_gps.xml

        TextView textViewCoordinat = findViewById(R.id.textView_koordinat); // Pastikan ID ini ada

        Bundle param = getIntent().getBundleExtra("param");

        if (param != null) { // Selalu periksa apakah Bundle tidak null
            double latitude = param.getDouble("lat");
            double longitude = param.getDouble("lon");

            textViewCoordinat.setText(latitude + "x" + longitude);

            // URL Google Maps yang Dikoreksi
            String url = "https://www.google.com/maps/search/?api=1&query=" +
                    latitude + "," + longitude;

            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webView.setWebViewClient(new WebViewClient()); // Jaga WebView tetap berada di dalam aplikasi Anda
            webView.loadUrl(url);
        } else {
            // Tangani kasus di mana bundle 'param' null, misal, tampilkan pesan kesalahan
            textViewCoordinat.setText("Koordinat tidak tersedia.");
        }
    }
}