ÖYKÜ'NÜN KELİMELER DÜNYASI - Android Studio kaynak projesi (V3.0 taslak)

Android Studio'da bu klasörü Open Project ile açın.
Gradle senkronizasyonu için internet gerekebilir.
Build > Build APK(s) menüsünü seçin.
Oluşan APK: app/build/outputs/apk/debug/app-debug.apk

ÖNEMLİ: Bu proje henüz derlenip tablette test edilmedi.
Android'in TextToSpeech motorunu kullanır; Türkçe TTS yoksa ses çıkmayabilir.
Tamamen çevrimdışı ve cihazdan bağımsız Türkçe ses için ayrıca uygulamaya
Türkçe konuşma modeli ve sentezleyici motoru gömmek gerekir.

Mevcut V2.1 HTML arayüzü korunmuştur. Android WebView içindeki veriler,
Chrome'da kaydedilmiş verilerden ayrı tutulur. Chrome'dan JSON yedek alıp
uygulamada içeri aktarın (WebView dosya seçici ayrıca geliştirme gerektirebilir).
