Teoria kompilacji i kompilatory - Projekty 2017
===============================================

Nowe, lepsze zasady zaliczenia!

Dla wszystkich, których satysfakcjonuje ocena 4, będzie jedno proste zadanie (takie samo dla wszystkich). Na 5 jest zestaw trochę trudniejszych zadań do wykonania w grupach.

Co trzeba zrobić
----------------

  1. Zainstalować VirtualBox-a.
  2. Zainstalować Vagrant-a.
  3. Ściągnąć sobie to repozytorium.
  4. Otworzyć jego katalog w konsoli i wykonać poniższe polecenia:
  5. `vagrant up` - żeby automatycznie ściągnąć, uruchomić i skonfigurować maszynę wirtualną z Ubuntu i zainstalować na nim OpenJDK i GCC.
  6. `vagrant ssh` - żeby zalogować się do maszyny. Dalsze polecenia wykonywane będą na maszynie.
  7. `cd /vagrant` - żeby przejść do katalogu projektu (automatycznie zsynchronizowanego).
  8. `projects/sample/bin/build` - żeby skompilować przykładowy projekt.
  9. `bin/test projects/sample` - żeby wykonać jego testy (patrz niżej).
 10. Założyć repozytorium (swoje lub grupowe), najlepiej w podkatalogu `projects`.
 11. Przejrzeć zadania i odpowiadające im testy i coś sobie wybrać.
 12. Zapisać się na listę (link gdzie indziej) podając:
     * swój adres e-mail w domenie *.agh.edu.pl*,
     * imię, nazwisko, numer indeksu, grupę dziekańską,
     * link do repozytorium Git
     * i wybrane zadanie.
 13. Doprowadzić projekt do postaci, w której będzie przechodził właściwe dla niego testy.
 14. Będąc gotowym lub mając pytania, napisać maila na mój adres e-mail.


Projekty i testy
----------------

Forma projektów jest niemal dowolna, byle tylko działały na dostarczonej maszynie wirtualnej. Jeśli ktoś bardzo chce użyć technologi, której tam nie ma, to proszę dać znać. Wymogiem jest obecność pliku `bin/build`, który powinien przygotować projekt do testów, czyli coś zbudować, skompilować itp. Proponowałbym, żeby taki plik istniał nawet, jeśli nie jest potrzebny. W katalogu `bin` powinny też znaleźć się wszystkie pliki wykonywalne, których będą używać testy (jak przykładowy plik `calc` uruchamiający prosty kalkulator).

Każdy projekt powinien zawierać plik `tests` (w głównym katalogu), w którym będzie lista testów, których się podejmuje. Nazwy testów to nazwy plików w katalogu `tests/` tego repozytorium. Testy to skrypty, które w jakiś sposób używają dostarcznych przez projekt plików wykonywalnych (najczęściej jednego) i sprawdzają, czy dla odpowiedniego wejścia lub argumentów dają odpowiednie wyjście (lub błędy).

Będąc w katalogu tego repozytorium, testy konkretnego projektu można uruchomić poleceniem `bin/test path/to/project`. Można też podać więcej argumentów - nazw testów - by zamiast listy dostarczonej przez projekt przetestować wskazanymi testami, np. `bin/test projects/foo a1 a2 a3 b1`.

Decydując się na projekt na 4, repozytorium powinno nazywać się `db_NRINDEKSU` np. `db_801636`. W przypadku projektu na 5 będzie to `ZADANIE_NRGRUPY` (grupy dziekańskiej). Nazwa projektu to *db* (na 4) lub nazwa zadania (TODO).


Zadanie na 4
------------

Zadanie polega na zmodyfikowaniu przykładowego projektu tak, by przechodził testy `a1` i `b1`. Jeśli ktoś chce, może też zacząć od zera, również w innej technologii.

Przykładowy projekt zawiera interpreter bardzo prostych wyrażeń matematycznych napisany w Javie (klasa `Interpreter` uruchamiana skryptem `calc`). W kodzie nie ma komentarzy ani nie opisuję go dokładniej, bo zrozumienie jego działania to właśnie dydaktyczne sedno tego zadania. Rozumiejąc program dostatecznie dobrze, można dokonać niezbędnych usprawnień.

   * Obsługiwane są tylko liczby jednocyfrowe. Trzeba dodać obsługę liczb wielocyfrowych (obliczenia powinny być na zmiennoprzecinkowych, ale wczytywać wystarczy dodatnie, całkowite).
   * Umożliwić używanie dowolnej ilości spacji między operatorami i liczbami.
   * Poza dodawaniem i mnożeniem obsłużyć odejmowanie i dzielenie.
   * Dodać obsługę nawiasów.


Zadania na 5
------------

(TODO)

Szkic:

  * Podobne zmiany, tylko w kompilatorze (`compiler`).
  * Optymalizacja kompilatora (nie może używać `push` ani `pop`).
  * Obsługa w interpreterze wbudowanych funkcji (np. `sin`, `sqrt`).
  * Obsługa w interpreterze wielu instrukcji i zmiennych (np. `x=1; 2+x;`).
  * Interpreter interaktywny.
  * ...
