# Enoca-Project-Test-Case

# Proje Adı - MVC Uygulama Dokümantasyonu

Bu doküman, **Enoca-Project-Test-Case** isimli projenin MVC (Model-View-Controller) mimarisine dayalı olarak nasıl çalıştığını ve servislerin nasıl kullanıldığını açıklamaktadır.

## İçindekiler

- [Kurulum](#kurulum)
- [Çalıştırma](#çalıştırma)
- [API Endpoints](#api-endpoints)
- [Swagger Kullanımı](#swagger-kullanımı)

## Kurulum

1. **Bağımlılıklar**: Projenin gereksinim duyduğu bağımlılıklar [pom.xml] dosyasında belirtilmiştir. Maven kullanıyorsanız, gerekli bağımlılıklar otomatik olarak indirilir.
2. **Veritabanı Konfigürasyonu**: Proje veritabanı ayarlarını [application.yaml] dosyasından yapılandırabilirsiniz.

## Çalıştırma

Proje bağımlılıklarını çözdükten sonra aşağıdaki adımları izleyerek projeyi çalıştırabilirsiniz:

1-Uygulamadaki versiyonunuz aynı veya karşlıyorsa direkt çalıştırabilirsiniz.
2-Veri taban da **enoca** isimli bir veri tabanı oluşturunuz.


## API Endpoints

Bu bölümde, projenin sunmuş olduğu API endpoint'lerini bulabilirsiniz. Bu endpoint'ler, MVC yapısına uygun olarak tasarlanmış controller sınıfları tarafından yönetilmektedir.

### Kullanıcılar (Users)

- `GET /users`: Tüm kullanıcıları listeler.
- `POST /users`: Yeni bir kullanıcı oluşturur.
- `GET /users/{userId}`: Belirtilen kullanıcının detaylarını getirir.
- `PUT /users/{userId}`: Belirtilen kullanıcının bilgilerini günceller.
- `DELETE /users/{userId}`: Belirtilen kullanıcıyı siler.

### Şirketler (Companies)

- `GET /companies`: Tüm şirketleri listeler.
- `POST /companies`: Yeni bir şirket oluşturur.
- `GET /companies/{companyId}`: Belirtilen şirketin detaylarını getirir.
- `PUT /companies/{companyId}`: Belirtilen şirketin bilgilerini günceller.
- `DELETE /companies/{companyId}`: Belirtilen şirketi siler.

## Swagger Kullanımı

Bu projede Swagger kullanılarak API endpoint'leri belgelenmiştir. Swagger belgelerine erişmek için aşağıdaki adımları izleyebilirsiniz:

1. Projeyi başlattıktan sonra tarayıcınızda aşağıdaki linke gidin:

          http://localhost:8080/swagger-ui.html

2. Swagger arayüzünde, projenin sunmuş olduğu API endpoint'lerini görsel olarak görebilir ve test edebilirsiniz.


