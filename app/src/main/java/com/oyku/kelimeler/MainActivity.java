package com.oyku.kelimeler;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import java.util.Locale;

public class MainActivity extends Activity {
  private WebView web;
  private TextToSpeech tts;
  private boolean ready=false;
  @Override public void onCreate(Bundle state){super.onCreate(state);
    web=new WebView(this); web.getSettings().setJavaScriptEnabled(true);
    web.getSettings().setDomStorageEnabled(true);
    web.setWebViewClient(new WebViewClient());
    web.addJavascriptInterface(new Object(){
      @JavascriptInterface public void speak(String word){runOnUiThread(()->{
        if(!ready){Toast.makeText(MainActivity.this,"Türkçe ses motoru hazır değil. Türkçe ses paketi veya uygulama içi seslendirme gerekir.",Toast.LENGTH_LONG).show();return;}
        tts.speak(word,TextToSpeech.QUEUE_FLUSH,null,"oyku_word");
      });}
    },"OykuAndroid");
    setContentView(web);
    tts=new TextToSpeech(this,status->{if(status==TextToSpeech.SUCCESS){int result=tts.setLanguage(new Locale("tr","TR"));ready=result!=TextToSpeech.LANG_MISSING_DATA&&result!=TextToSpeech.LANG_NOT_SUPPORTED;tts.setSpeechRate(.82f);if(!ready)runOnUiThread(()->Toast.makeText(this,"Türkçe TTS bulunamadı; APK tek başına Türkçe ses eklemez.",Toast.LENGTH_LONG).show());}});
    web.loadUrl("file:///android_asset/index.html");
  }
  @Override protected void onDestroy(){if(tts!=null){tts.stop();tts.shutdown();}web.destroy();super.onDestroy();}
}
