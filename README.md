# Wonder
A test mobile app to show wonderful places around the world

### Screenshots

| Login Screen | Choosing Account |
| ------ | ------ | 
|<img src="https://github.com/KaungMyat-Min/wonder/blob/master/screenshots/screen_shot2.png" width="200">|<img src="https://github.com/KaungMyat-Min/wonder/blob/master/screenshots/screen_shot1.png" width="200">|


### Libraries Used
 - Patterns and framework
    - MVVM (Model-View-ViewModel) using Google's new Architecture components ViewModel and LiveData
- Database
    - Room Persistence Library, part of Google's new Architecture components.
- Remote Call APIs
    - Retrofit 2 to perform HTTP requests.
- Dependency Injection
    - Dagger Android 2 to manage App and Activity-scoped dependencies.
- Communication between app layers
    - RxJava2 and RxAndroid for interacting between ViewModel and local database.
- Packages
    - organize files in a way to modular easily in future, module by feature package by layer type

### Branches
- master
- develop

### Todos
- NetworkBounceResource to merge api request and local database fetching
- DiffUlti for updating recyclerview items
- Differentiating database cache to delete or save
