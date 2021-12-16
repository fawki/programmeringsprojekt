Tekniske krav til at køre systemet:
Windows styresystem.
Java 16 eller nyere.


JAR-filen er kompileret i OpenJDK 17, og denne version eller nyere foreslås derfor også hvis programmet skal køre.
Programmet er testet og kørt primært i Windows, samt at JavaFX-versionen som er bundlet med i JAR-filen er til Windows.


Til JAR-filen bliver Launcher-klassen kørt som hovedfunktionen, da den ikke ville køre ellers. Denne klasse eksisterer kun til at køre main-metoden i Main-klassen.
Til unit testing bliver TesterRunner-klassen kørt som hovedfunktion.


Brugerguide (også i rapporten):

Brugeren ankommer først til vores home-menu, hvor de kan se en oversigt over alle film og serier. 

Brugeren kan også vælge at søge efter en film eller en serie ved dennes titel. 

Alternativt kan brugeren vælge at sortere filmene eller serierne med kategori. 

Når brugeren har valgt en film eller serie har brugeren nogle muligheder:
Hvis brugeren har valgt en film, kan brugeren se udgivelsesåret, filmens rating, filmens genrer, vælge at ”afspille” filmen og tilføje den til ”Min-liste” 
Hvis brugeren har valgt en serie, kan brugeren se produktionsårene, seriens rating, genrerne, ”afspille” serien og tilføje den til ”Min-liste”	 

Når brugeren er færdig med at bruge vores program, kan det lukkes. 