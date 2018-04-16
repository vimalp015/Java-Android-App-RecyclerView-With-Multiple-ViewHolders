# NewsFeedApp
Android app that consumes the provided API and displays a list of news articles to the user in a RecycleView. 

The included API endpoint returns, amongst other data, an array of news stories (assets).

* The list of articles are displayed with the following fields:

-- headline

-- theAbstract

-- byLine

* Displays latest article first in the list, uses article's 'timeStamp'

* If there are related images available for an asset, the smallest image available is displayed for the asset in the cell.

* Images are loaded asynchronously and cached

API Endpoint:

Other Features:
*The architecture is MVP
*Android Studio 3.0.1
*RxJava library for reactive 
*Butterknife for annotation processing
*Dagger2 for dependency injection
*Picasso for image processing
*Retrofit for networking
*Junit and Mockito for unit tests
*I have used Java for coding 
*Kotlin for writing test cases

