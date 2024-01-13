# Project-Bookshelf-App
https://developer.android.com/codelabs/basic-android-kotlin-compose-bookshelf

Practice makes a master.   
This main branch is the main directory.   

there are 2 branchs for 1 practice, Compose and SwiftUI.   
   
• [Compose branch](https://github.com/Jaehwa-Noh/Project-Bookshelf-App/tree/compose-bookshelf-app)   
• [SwiftUI branch]   


---

연습이 장인을 만든다.   
이 메인 브랜치는 메인 폴더입니다.

1개의 연습에 컴포즈와 스위프트유아이 2개의 브랜치가 있습니다.   
   
• [컴포즈 브랜치](https://github.com/Jaehwa-Noh/Project-Bookshelf-App/tree/compose-bookshelf-app)   
• [스위프트유아이 브랜치]   


## Bookshelf App (책장 앱)
This app shows books list to user using the Google Books API. (이 앱은 Google Books API를 사용하여 사용자에게 책 목록을 보여주는 앱입니다.)


## UI specifications (UI 명세서)
### Full screen (전체 화면)
<img width="300" alt="Full screen of Bookshelf app (책장 앱 전체 화면)" src="https://github.com/Jaehwa-Noh/Project-Bookshelf-App/assets/48680511/d1cf46e7-104a-4e08-8ff0-e7d1fca52029">

## Network API specifications (네트워크 API 명세서)
### Google Books API v1
URI: https://www.googleapis.com/books/v1/volumes?q=search+terms
#### Response (응답)
```html
200 OK

{
 "kind": "books#volumes",
 "items": [
  {
   "kind": "books#volume",
   "id": "_ojXNuzgHRcC",
   "etag": "OTD2tB19qn4",
   "selfLink": "https://www.googleapis.com/books/v1/volumes/_ojXNuzgHRcC",
   "volumeInfo": {
    "title": "Flowers",
    "authors": [
     "Vijaya Khisty Bodach"
    ],
   ...
  },
  {
   "kind": "books#volume",
   "id": "RJxWIQOvoZUC",
   "etag": "NsxMT6kCCVs",
   "selfLink": "https://www.googleapis.com/books/v1/volumes/RJxWIQOvoZUC",
   "volumeInfo": {
    "title": "Flowers",
    "authors": [
     "Gail Saunders-Smith"
    ],
    ...
  },
  {
   "kind": "books#volume",
   "id": "zaRoX10_UsMC",
   "etag": "pm1sLMgKfMA",
   "selfLink": "https://www.googleapis.com/books/v1/volumes/zaRoX10_UsMC",
   "volumeInfo": {
    "title": "Flowers",
    "authors": [
     "Paul McEvoy"
    ],
    ...
  },
  "totalItems": 3
}
```

