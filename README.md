# GenshinApp

This app focuses on *Clean Architecture* implementation, *Dynamic Feature* usage, and *Dependecy Injection* which involves Hilt/Dagger and Koin. Ah, and also this app is not actually about Genshin the game, so please don't mind the name.


## Modules
This app has 3 modules, *app* module, *core* module, and *favorite* module. The app module contains presentation and AppModule for the Dependency Injection. The core module contains database and Retrofit configurations also data flows from the core. Finally, favorite module is a dynamic feature presentation of favorite screen using Room as the database.

## Dependency Injection
The finalized app uses *Koin* as its DI. Hilt/Dagger was used earlier but got changed due to monolith behaviour that it has.
