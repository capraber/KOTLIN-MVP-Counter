# MVPCounter
Simple MVP example

## MVP-Overview:
   MVP is a user interface architectural pattern engineered to facilitate automated unit testing and improve the separation of concerns in presentation logic:
- The model is an interface defining the data to be displayed or otherwise acted upon in the user interface.
- The view is a passive interface that displays data (the model) and routes user commands (events) to the presenter to act upon that data.
- The presenter acts upon the model and the view. It retrieves data from repositories (the model), and formats it for display in the view.
        
   ![alt tag](https://github.com/capraber/KOTLIN-MVP-Counter/blob/master/1.MVP.png)

[MVP - Presenter First](https://docs.google.com/presentation/d/1eLiSih_4EQEjz4hspVXVEGfMrLt7786flZg9me1nbaQ/edit?usp=sharing)

## View Binding:
   View binding is a feature that allows you to more easily write code that interacts with views. Once view binding is enabled in a module, 
   it generates a binding class for each XML layout file present in that module. An instance of a binding class contains direct references 
   to all views that have an ID in the corresponding layout. In most cases, view binding replaces findViewById.
   
   [Learn more about View Binding](https://developer.android.com/topic/libraries/view-binding)

## Example Image
![alt tag](https://github.com/capraber/KOTLIN-MVP-Counter/blob/master/2.CounterImage.png)

## Environment set up
- [Install AS](https://developer.android.com/studio/install.html?hl=es-419)

## Language documentation
- [KOTLIN References](https://kotlinlang.org/docs/reference/)
- [KOTLIN Full documentation](https://kotlinlang.org/docs/kotlin-docs.pdf)
