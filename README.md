# Projektmunka-beadand-

# CIV VI

1. Alasz Flórián
2. Lőrincz Máté

### Feladat: Projekt Munka
>Iránygomb játék előre elhatározott vagy véletlenszerű sorrendben lévő irányokkal, Highscore rendszerrel, fiók névhez kötve

### Követelmények

1. Asztali alkalmazások:
    - Adatbázis használata JDBC-vel: Az adatbázis funkciókat külön, erre a célra kialakítottosztályban lesz implementálva. Adatbázishoz való csatlakozás után érdemes rávizsgálni, hogy létezik-e a kívánt adatbázis és táblák. Ha nem létezik, akkor az alkalmazásból létre is tudjuk hozni őket.
    - Elért eredmények mentése
    - Fiókok mentése
    - Kivétel és hibakezelés: Az alkalmazásban minden előforduló kivételt és hibát le kezel, ennek előfordulásakor vissza ad hibaüzenetet piros betűszínnel egy Label-be. Ha nem történt hiba és sikeresen lefutott egy funkció, fekete / zöld betűszínnel egy tájékoztató üzenetet ad vissza ugyanabban a Label-ben.

2. Szoftvertesztelés:
    - Projekt dokumentáció
    - A programban legalább egy saját készítésű kivételt használunk.
    - Readme fájl amiben lépésről lépésre bemutatja az alkalmazás felhasználását.

3. IKT projektmunka
    - Bemutató készítése az elkészített szoftverhez.
    - A bemutató legalább 15 diát fog tartalmazni.
    - Előadás

### Munkamegosztás

- Alasz Flórián: IKT projektmunka, Asztali alkalmazások (Bejelentkezés, adatbázis)

- Lőrincz Máté: Szoftvertesztelés, Asztali alkalmazások (Játék tér, adatbázis)


### Megvalósítás

1. Form készítés
    - Legfelül a pontszám.
    - Középen az előre elrendelt vagy véletlenszerűen létrehozott nyíl kombináció.
    - 3 élet jel oldalt jelezve hogy 3x hibázhatsz.
    - Végén highscore rendszer fiókok neveivel és pontszámaival.
    - Highscore akkor változik ha x névhez nagyobb pont lesz.
2. Adatok tárolása
    - Fiók felhasználoknak
    - Név és pontszám
