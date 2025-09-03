# 🏗 Modern Clean Architecture Android Project  

Bu proje, **MVVM + Clean Architecture** prensiplerine göre tasarlanmış, ölçeklenebilir ve sürdürülebilir bir Android uygulama yapısını örneklemektedir.  
Amaç: **UI, veri katmanları ve iş mantığını birbirinden ayırarak** daha temiz, test edilebilir ve tekrar kullanılabilir bir mimari sunmaktır.  

---

## 📂 Proje Klasör Yapısı  

```
data/
│── local/
│   ├── dao/                # Room DAO (Data Access Object)
│   │   └── UserDao.kt
│   ├── database/           # Room Database konfigurasyonu
│   │   └── AppDatabase.kt
│   └── entities/           # Local veri modelleri (Room Entity)
│       └── UserEntity.kt
│
│── remote/
│   ├── models/             # DTO (Data Transfer Objects - API modelleri)
│   │   └── Address.kt, User.kt
│   ├── service/            # Retrofit API servisleri
│       └── ApiService.kt
│
│── repository/             # Local + Remote veri kaynaklarını yöneten katman
│
│── mapper/                 # DTO ↔ Entity ↔ Domain Model dönüşümleri
│
di/                         # Dependency Injection (Hilt Modules)
│   └── AppModule.kt
│
domain/
│── models/                 # Domain (iş mantığına uygun modeller)
│── repository/             # Repository arayüzleri
│── usecase/                # İş mantığı (Use Case)
│
presentation/
│── local/
│   ├── address/            # Address ekranı (View + Screen)
│   ├── users/              # Users ekranı (View + Screen)
│   └── navigation/         # Navigation host
│       └── AppNavHost.kt
```

---

## 🔄 Veri Akış Örneği  

1. **UI (ViewModel)** → `UserRepository.getUsers()` çağrısı yapılır.  
2. **Repository**  
   - API’den veri çeker (`UserApiService`)  
   - DTO → Entity dönüşümü yapılır (`Mapper`)  
   - Veriler Room DB’ye kaydedilir (`UserDao`)  
   - Veriler ViewModel’e döndürülür  
3. **ViewModel** → UI’a güncel veriyi aktarır.  

👉 Böylece **UI katmanı sadece Repository’i bilir**, verinin nereden geldiğiyle ilgilenmez.  

---

## ✨ Avantajlar  

- ✅ Katmanlı yapı sayesinde **bağımlılıkların azaltılması**  
- ✅ **Test edilebilirlik** artışı  
- ✅ **Kod tekrarının önlenmesi** (Mapper & Repository kullanımı)  
- ✅ Hem **offline (Room DB)** hem **online (API)** çalışma desteği  
- ✅ **Clean Architecture** ve **SOLID prensiplerine uygunluk**  

---

📌 Bu yapı küçük projelerden büyük ölçekli uygulamalara kadar rahatlıkla uyarlanabilir.  
