import json.JsonHandler
import org.scalatest.flatspec.AnyFlatSpec

class JsonHandlerSpec extends AnyFlatSpec {

  "a case class" should "return json" in {

    case class User(username: String,
                    pass: String,
                    age: Int = 30,
                    dob: String = "1985-01-25")

    val json = new JsonHandler().toJson(User("admin", "demo"))
    println(json)

    val lines = json.split("\n")
    assert(lines.length == 6)
  }

  "a case class with a nested case class" should "return json with nested obj" in {

    case class Phone(home: String, office: String)
    case class Contacts(email: String, phone: Phone)
    case class UserWithContact(username: String,
                               pass: String,
                               age: Int,
                               dob: String,
                               contact: Contacts)

    val json = new JsonHandler().toJson(
      UserWithContact(
        "admin",
        "demo",
        30,
        "1985-01-25",
        Contacts("test@yahoo.com", Phone("111-3432432", "222-4353465"))
      )
    )

    println(json)
  }

}
