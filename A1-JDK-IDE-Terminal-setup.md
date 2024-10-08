# Aufgabe A1 - JDK, IDE und Terminal Setup
`5 Punkte`


## 1. JDK

Sie sollten ein *Java Development Kit (JDK)*, Version 21 (LTS - Long-term support Version)
oder höher auf Ihrem Laptop installiert haben.
Im Gegensatz zum *Java JRE* (Java Runtime Environment) enthält das *JDK* nicht
nur die Java Virtual Machine (Java VM) zur Ausführung von Java Programmen,
sondern auch alle Werkzeuge für Bau und Dokumentation.

Das JDK enthält:

- `java` - die Java Virtual Machine (Java VM) zur Ausführung von Java Programmen,

- `javac` - der Java Compiler zur Übersetzung von Java-Quellcode (`*.java`-Files)
    in portablen, auf der Java VM ausführbaren Code (`*.class`-Files),

- `jar` - der Java Archiver zum Paketieren ausführbaren Codes (`*.class`-Files)
    in ein auslieferbares Endprodukt als `.jar`-Datei.

- `javadoc` - der Compiler für [*Javadoc*](https://en.wikipedia.org/wiki/Javadoc).

Haben Sie kein JDK (kein Java oder nur der JRE), installieren Sie bitte das JDK
von
[Oracle JDK](https://www.oracle.com/java/technologies/downloads/)
oder
[OpenJDK](https://openjdk.org/).
Wählen Sie die entsprechende Variante für Ihren Laptop aus.


## 2. IDE

Ein *Integrated Development Environment (IDE)* ist ein Werkzeug, das die
Software-Entwicklung unterstützt mit Funktionen zum *Editieren*, *Debuggen*,
*Kommentieren* von Quellcode.

Ältere IDE (u.a. [NetBeans](https://netbeans.apache.org/front/main/index.html),
[*eclipse*](https://www.eclipse.org/), [*IntelliJ*](https://www.jetbrains.com/idea/))
unterstützen oft nur eine Programmiersprache.

Moderne IDE (z.B. [*VSCode*](https://code.visualstudio.com/)) unterstützen
viele Programmiersprachen (*polyglott*), moderne Editier- und Terminal-Funktionen
sowie umfangreiche Erweiterungen
([*Extensions*](https://marketplace.visualstudio.com/vscode)), welche heute
in der Software-Entwicklung unabdingbar sind (moderne Editier-Funktionen sind
u.a. Multi-Cursor Edits).

Für ambitionierte Studenten ist *VS Code* empfohlen. Diese IDE entspricht heutigen
Standards, erfordert jedoch die Installation und Konfiguration von Erweiterungen,
u.a. für das
[*Extension Pack for Java*](https://code.visualstudio.com/docs/java/java-tutorial).

Wenn Sie den Aufwand sparen möchten, bieten
[*eclipse*](https://www.eclipse.org/) oder [*IntelliJ*](https://www.jetbrains.com/idea/)
immer noch geeignetet IDE, die *"out-of-the-box"* benutzbar sind.

Wählen Sie eine IDE (Integrated Development Environment). Empfohlen ist *VS Code*,
    Sie können aber auch *eclipse* weiter verwenden oder *IntelliJ*.


## 3. Terminal

Eine Terminalsoftware erlaubt die Interaktion mit Programmen über die Eingabe von
Kommandos und der Ausgabe von Text in Zeilenform.

- *Mac* und *Linux* Laptops haben geeignete Terminalsoftware vorinstalliert.

- Für *Windows* Laptops, installieren Sie bitte `cygwin` (Unix-Emulator).
    Folgen Sie den Schritten in
    [setup_cygwin](https://github.com/sgra64/markup/blob/main/setup_cygwin/README.md).

Die Verwendung von Terminalsoftware erfordert ein Grundverständnis der
Funktionsweise. In den Übungen werden wir die
[Punkte](https://github.com/sgra64/markup/tree/main/terminal)
durcharbeiten zu den Themen:

- [*"Terminal and Shell"*](https://github.com/sgra64/markup/blob/main/terminal/01-terminal-and-shell.md).

- [*"Filesystem and $HOME directory"*](https://github.com/sgra64/markup/blob/main/terminal/02-filesystem-and-home.md).

- [*"Processes and Environment Variables"*](https://github.com/sgra64/markup/blob/main/terminal/03-processes-and-environment.md).

- [*"Dotfiles"*](https://github.com/sgra64/markup/blob/main/terminal/04-dotfiles.md).

- [*"Aliases and Functions"*](https://github.com/sgra64/markup/blob/main/terminal/05-aliases-and-functions.md).

Die Verwaltung der Dotfiles ist wesentlich für die Funktion der Software
auf einem System (u.a. auch für die Colorierung und Prompts in Terminals).
Man sollte Dotfiles daher professionell in *git* verwalten,
siehe Prof. Graupner's [*dotfiles*](https://github.com/sgra64/dotfiles).
Jeder sollte die einzelnen Files grob einordnen können.

Ambitionierte Studenten können die Struktur oder Teile aus den Dotfiles
für ihre Systeme nachempfinden, insbesondere zu
[*.profile*](https://github.com/sgra64/dotfiles/blob/main/.profile),
[*.bashrc*](https://github.com/sgra64/dotfiles/blob/main/.bashrc),
[*.paths*](https://github.com/sgra64/dotfiles/blob/main/.paths).


&nbsp;

## Finaler Test

Öffnen Sie ein Terminal und zeigen Sie, dass alle Werkzeuge korrekt installiert
sind und aufgerufen werden können.

    ```
    java --version
    ```
    Antwort: Java-JDK, Version 21 (Oracle)
    ```
    java 21 2023-09-19 LTS
    Java(TM) SE Runtime Environment (build 21+35-LTS-2513)
    Java HotSpot(TM) 64-Bit Server VM (build 21+35-LTS-2513, mixed mode, sharing)
    ```

    ```
    javac --version
    javac 21
    ```

    ```
    javadoc --version
    javadoc 21
    ```

    ```
    jar --version
    jar 21
    ```

    ```
    git --version
    git version 2.38.0.windows.1
    ```

<img src="img/tools.png" width="600"/>

