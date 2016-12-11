# Purpose
To illustrate how to read from and save properties into a file.

# How
To test drive the app, run:

```
mvn clean install
mvn exec:java -Dexec.mainClass=wua.eg.properties.App
```

# File Format

```
# Default file format changes non Latin-1 characters into \uxxxx for their appropriate unicode hexadecimal value xxxx.
$ cat target/classes/myProperties.txt 
#\u6700\u5F37\u30A2\u30D7\u30EA\u30B1\u30FC\u30B7\u30E7\u30F3\u306E\u8A2D\u5B9A\u30D5\u30A1\u30A4\u30EB
#Mon Dec 12 01:13:15 JST 2016
db.password=\u65E5\u672C\u8A9E\u30D1\u30B9\u30EF\u30FC\u30C9
db.port=123
db.user=root
db.name=employees
db.hostname=xyz

# UTF-8 characters are intact with XML
$ cat test.xml 
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<!DOCTYPE properties SYSTEM "http://java.sun.com/dtd/properties.dtd">
<properties>
<comment>超普通のアプリケーションの設定ファイル</comment>
<entry key="db.password">日本語パスワード</entry>
<entry key="db.user">root</entry>
<entry key="db.port">123</entry>
<entry key="db.name">employees</entry>
<entry key="db.hostname">xyz</entry>
</properties>
```


# Maven Template Used

```
mvn archetype:generate \
 -DgroupId=wua \
 -DartifactId=properties \
 -Dpackage=wua.eg.properties \
 -DarchetypeArtifactId=maven-archetype-quickstart \
 -DinteractiveMode=false
```
