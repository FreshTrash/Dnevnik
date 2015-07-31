# Dnevnik

Java 8
tomcat8
postgres 9.4.2

Создание базы
sudo -u postgres psql postgres
create database dnevnik;
cd path/to/Dnevnik
sudo -u postgres psql dnevnik < 'sql/create.sql'

В webapp/WEB-INF/classess/application.properties прописать путь, где будут храниться файлы(dnevnik.file.dir)

war
./gradlew dnevnik_war
cp build/dnevnik.war /path/to/tomcat8/webapp

