# ECommerceLoginDemo

Entites katmanında, User classında id,name,lastname,email ve password bulunmaktadır. User classı Entity adında interfaceten implement edilmiştir.

DataAccess katmanında, UserDao adında bir interface bulunmaktadır ve HibernateUserDao bu interfacei implement etmektedir. HibernateUserDao içerisinde, User tipinde bir liste bulunmakta ve register olanlar bu listeye eklenmektedir.

Business katmanında, UserService adında bir interface bulunmaktadır ve UserManager bu interface’yi implement etmektedir. UserManager içerisinde üyelerin(user) register olurken ki şartları (user bilgileri bos olmamalı, şifre en az 6 karakter olmalı, var olan email olmamalı,email içerisinde @ kontrolü-regex- ve ad ve soyad en az 2 karakter olmalı) bulunmaktadır. Ve login olurken email ve şifre boş olmama durum kontrolü bulunmaktadır. Bunun yanında bir tane user doğrulama için UserValidateService adında bir interface bulunmaktadır. Doğrulama yöntemine göre (senaryoda Email ile) bir tane EmailValidateManager class’ı oluşturdum UserValidateService’i implement etmektedir. Register işlemi sırasında UserValidateService’yi de çağırarak doğrulama işlemini simüle etmekte. (ekranda doğrulandı mesajı direkt yazar)

GoogleRegister için(dış servis kullanımı), Core katmanı içerisinde bir tane RegisterService interface’i oluşturup GoogleRegisterAdapter classını bu interfaceden implement ettim. Main içerisinde, RegisterService tipinde bir GoogleRegisterAdapter oluşturarak Google ile register olmayı yaptım. 


![resim_2021-05-07_182411](https://user-images.githubusercontent.com/23154975/117472301-69ffea80-af61-11eb-8896-39caa086a124.png)

