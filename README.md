Aplikacja cyklicznie pobierane uzytkownikow oraz zadania które mieli do wykonania(todo) z API [jsonplaceholder.typicode.com](https://jsonplaceholder.typicode.com). 
Następnie zapisuje je do pliku lub wypisuje na konsoli.

###Konfiguracja
```
# consolePrinter -> wypisywanie danych na konsole
# filePrinter -> zapis danych do pliku
spring:
  profiles:
    active: consolePrinter
```