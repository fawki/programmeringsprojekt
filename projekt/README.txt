Tekniske krav til at køre systemet:
Windows styresystem.
Java 16 eller nyere.


JAR-filen er kompileret i OpenJDK 17, og denne version eller nyere foreslås derfor også hvis programmet skal køre.
Programmet er testet og kørt primært i Windows, samt at JavaFX-versionen som er bundlet med i JAR-filen er til Windows.


Til JAR-filen bliver Launcher-klassen kørt som hovedfunktionen, da den ikke ville køre ellers. Denne klasse eksisterer kun til at køre main-metoden i Main-klassen.
Til unit testing bliver TesterRunner-klassen kørt som hovedfunktion.


Brugerguide (kan også ses i rapporten med tilhørende billede til forklaring):

Brugeren ankommer først til vores home-menu, hvor de kan se en oversigt over alle film og serier. 
 

Brugeren kan også vælge at søge efter en film eller en serie ved dennes titel. 
 

Alternativt kan brugeren vælge at sortere filmene eller serierne med kategori. 
 

Når brugeren har trykket på en film eller serie, kommer en boks frem med information om mediet. Hvis brugeren har valgt en film, kan brugeren se udgivelsesåret, filmens rating, filmens genrer. Hvis brugeren har valgt en serie, kan brugeren se udgivelsesåret, filmens rating, filmens genrer og filmens sæsoner og deres episoder. Brugeren har herfra følgende muligheder: 

Brugeren kan vælge at afspille mediet. 

Brugen kan enten tilføje mediet til “My List” eller fjerne den fra “My List”, alt efter om den allerede er på deres liste. 

Brugen kan lukke boksen og kommer tilbage til hovedsiden. 

 

Brugeren kan trykke på knappen “My List” for at se sin egen liste. 

 

Brugeren kan skifte til en anden bruger i systemet og vil derefter kun se den anden brugers film og serier når de trykker på “My List”. 

 

Når brugeren er færdig med at bruge programmet, kan det lukkes. 