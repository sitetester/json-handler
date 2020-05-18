- Simple class to convert Scala case class (including nested ones) into JSON with proper indentation
- Look into JsonHandlerSpec.scala for example usage


```
val json = JsonWriter.write(
      UserWithContact(
        "admin",
        "demo",
        30,
        "1985-01-25",
        Contacts("test@yahoo.com", Phone("111-3432432", "222-4353465"))
      )
    )

println(json)
 
{
  "username" = "admin"
  "pass" = "demo"
  "age" = 30
  "dob" = "1985-01-25"
  "contact" = {
    "email" = "test@yahoo.com"
    "phone" = {
        "home" = "111-3432432"
        "office" = "222-4353465"
    }
  }
}
```
