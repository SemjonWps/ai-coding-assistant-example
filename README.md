# Meetup

## Interaktionsmöglichkeiten aka Features

- Autovervollständigung --> Cursorposition, offene Tabs
  - Kommentare machen
- Inline-Chat
  - nicht markieren
  - Code markieren
- Chat
  - ChatGPT
  - code markieren
  - #files, #selection, #terminalSelection, …
  - /fix, /doc, /test, ...
  - @workspace
- kleine, nette Spezialfeatures (Commit-Message, Renaming, ... )

## Use-Cases

- Boilerplat-Code schreiben
  - Mapper schreiben
  - DTOs schreiben
  - Listen fortführen
  - ...
- Transformieren
  - Code aus Tabellen
  - Code aus JSON
  - ...
- Fehler erklären lassen, Lösungen vorschlagen
- Fragen an die Codebase
  - Wo werden die Services instanziiert
  - Verwendet dieses Projekt Domain Driven Design
  - ...
- Code dokumentieren lassen
- Code aus Vorgaben generieren lassen
  - Chat, Kommentare im Code
  - Tests aus Testnamen, Funktionsname
  - Mocks aus Calls im Produktivcode
  - SQL
  - Regex
  - Datenstrukturen
  - Beispiele generieren lassen
  - ...
- Renaming
- Inline-Hilfe in der Console
- Git-Commitmessages generieren
- Komplexen Code erklären lassen (unbekannte Sprachfeatures)
- Mit komplexen Codekonstruktionen umgehen, "Code glätten"
- Tests schreiben (Test sind oft simpel und ähnlich)
- Dokumentation erstellen
- Mit Libraries umgehen (Konfiguration, Schnittstellensprache, Fehlersuche)
- Statische Codeanalyse
  - Code auf Fehler untersuchen lassen --> SQL-Beispiel
  - Verständlichkeit erhöhen
  - Vereinfachen
  - ...
- Ersatz für Google/Stackoverflow
  - wenn ich x habe, geht dann y (die für Google zu lang/komplex wären)
- ...
- Vorgehensplan entwerfen

- Sonstiges
  - Exclusions:
  - Denkt sehr in eine vorgegebene Richtung
  - Hat zu lange Antworten
  - Viel Kontext hilft viel
  - Falscher Vorschlag: falscher Code?
    Geht gerade nicht: kein VPN?, Update notwendig?, kein Internet?

## Add a table

Prompt: It should have the four rows. The columns have the following names Gang Name, Gang Slogan, Gang Meeting Point,
Founding Year
fill every cell with funny examples. All gangs consist of Disney erows.

| Gang Name            | Gang Slogan                        | Gang Meeting Point    | Founding Year |
|----------------------|------------------------------------|-----------------------|---------------|
| The Mickey Marauders | "Oh boy, let's conquer!"           | The Magic Castle      | 1928          |
| Donald's Ducklings   | "Quack up the world!"              | Duckburg Pond         | 1934          |
| Goofy's Gaggle       | "Gawrsh, let's get goofy!"         | Goofy's Gadget Garage | 1932          |
| The Lightning Racers | "Kachow! Speeding through dreams!" | Radiator Springs      | 2006          |

Promt: create a markdown table which defines the data structure of this table. Give every data field a name, a data
type, a max
length of 100 and if it is optional or not (only the meeting point should be optional)

| Field Name         | Data Type | Max Length | Optional |
|--------------------|-----------|------------|----------|
| Gang Name          | String    | 100        | No       |
| Gang Slogan        | String    | 100        | No       |
| Gang Meeting Point | String    | 100        | Yes      |
| Founding Year      | Integer   | -          | No       |

Promt: make the data type of Founding year a LocalDate

| Field Name         | Data Type | Max Length | Optional |
|--------------------|-----------|------------|----------|
| Gang Name          | String    | 100        | No       |
| Gang Slogan        | String    | 100        | No       |
| Gang Meeting Point | String    | 100        | Yes      |
| Founding Year      | LocalDate | -          | No       |

THE END