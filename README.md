<h1> Ined test project (Spring boot(Java 11) + Vue Js + PostgreSQL)</h1>

 <ul>
    <li> Инструкция по развертыванию и использованию находится в папке TestSQL </li>
    <li> Небольшое CRUD Rest приложение </li>
    <li> Монолитная инфраструктура сервисов</li>
    <li> Аутентификация и авторизация пользователя с помощью Simple JWT токена, в котором шифруются: логин и роль пользователя, срок службы которого = 1 час</li>
    <li> Просмотр всех товаров, если гость </li>
    <li> Если пользователь аутентифицирован(роль User), то он может добавлять комментарии к любому товару</li>
    <li> Если пользователь имеет роль Admin, то он может добавлять новые книги, новых авторов, новые жанры </li>
 </ul>
 
 
 <h3> Используемые технологии</h3>
 <ul>
    <li><b>Backend:</b></li>
    <ul>
        <li>Spring boot (Core,Security, Data JPA)</li>
        <li>Hibernate</li>
        <li>Maven</li>
        <li>PostgreSQL</li>
    </ul>
   <li><b>Frontend:</b></li>
     <ul>
         <li>Vue.js</li>
         <li>CSS</li>
     </ul>
    
  </ul>
 
 <h3> Архитектура</h3>
  <p>Здесь представлены и кратко описаны модули приложения.</p>
  <h2>Основные модули</h2>
  <ul>
    <li><b>book-api</b></li>
    <ul>
        <li>Является основынм корнем монолита</li>
        <li>Регистрация и авторизация</li>
        <li>Так же сюда приходится полное взаимодейстиве с книжками, авторами и жанрами </li>
  </ul>  
        <li><b>oauth-service </b> - c помощью данного сервиса получается доступ для функций регистрации и авторизации пользователя </li>
    <ul>
        <li>Процесс регистрации</li>
        <li>Процесс авторизации</li>
    </ul>
  </ul> 
  <h2>Вспомогательные модули</h2>
  <ul>
    <li><b>ined-core</b></li>
    <ul>
    <li> содержит набор подмодулей, которые логически сгруппированы и содержат внутри себя набор классов, предназначенных для повторного использования, конфигурационные файлы и сторонние библиотеки, необходимые для интеграции со Spring Framework.</li>
    </ul>
    <li><b>db-tools</b></li>
    <ul>
    <li>содержит набор классов для работы с БД, совместно используемых в модулях </li>
    </ul>
  </ul>
  
 <h2>Схема базы данных</h2>
 
 
![alt text](https://user-images.githubusercontent.com/48677713/98450116-f49a9500-214a-11eb-8141-14aa455ff966.jpg)
