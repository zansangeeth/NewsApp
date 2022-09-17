# News App - Arimac
 
Sangeeth Amirthanathan

**XYZ Rest** is an native android app user can view restaurants, view detail pages and view branch location on map view

Time spent: **3** days spent in total

## Android MVVM Architecture

MVVM stands for Model, View, ViewModel.

* [ ] Model: This holds the data of the application. It cannot directly talk to the View. Generally, it’s recommended to expose the data to the ViewModel through Observables.

* [ ] View: It represents the UI of the application devoid of any Application Logic. It observes the ViewModel.

* [ ] ViewModel: It acts as a link between the Model and the View. It’s responsible for transforming the data from the Model. It provides data streams to the View. It also uses hooks or callbacks to update the View. It’ll ask for the data from the Model.

The following flow illustrates the core MVVM Pattern.

![android-mvvm-pattern](https://user-images.githubusercontent.com/42418189/186920956-39430cc6-9eab-4b5a-86fc-c9cba4b72e3b.png)

## Functionality 

The following **required** functionality is completed:

* [ ] Activities
* [ ] Fragments
* [ ] View Holder
* [ ] Lifecycle
* [ ] Activity Navigations
* [ ] Fragment Navigations
* [ ] Data tranfer within Activities
* [ ] Retrofit
* [ ] Recycler View

The following **extensions** are implemented:

* [ ] User can view breaking news on recylcer view horizontal view
* [ ] User can view breaking news on recylcer view vertical view
* [ ] User can view the details of the specific news
* [ ] imlemented custom bottom navigation bar
* [ ] imlemented custom shapes
* [ ] imlemented MVVM pattern
* [ ] implemented shared preference for user login and save user credentials on local storage


The following **extensions** are not implemented:

* [ ] favourites
* [ ] Logout screen
* [ ] search results

## Image Walkthrough

Here's a walkthrough of implemented user stories:

# Screenshots
Screen | #1 | #2 |
--- | --- | --- |
Imaages | ![Screenshot_20220917_214006](https://user-images.githubusercontent.com/42418189/190866601-2a4ed719-5f01-422e-89a8-bbb8bdcbc6ff.png) | ![Screenshot_20220917_214024](https://user-images.githubusercontent.com/42418189/190866619-e5f21079-1087-46d8-8c15-b4b6311c56d4.png) |


## Notes

Describe any challenges encountered while building the app.

* [ ] Navigating Activities
* [ ] Navigating Fragments
* [ ] Passing data between Activities
* [ ] Dealing with build.gradle
* [ ] Designing Application in XML
* [ ] Design UI
* [ ] Deal with retrofit
* [ ] Deal with data classed and JSON objects classes
* [ ] imlemented shared preferences
* [ ] imlemented bottom nav bar 
* [ ] imlemented data binding


## License

    Copyright 2022 Sangeeth Amirthanathan

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
