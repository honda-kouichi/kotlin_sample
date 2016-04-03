fun main() {
    var user = User("hoge", 10)
    print(user.name)
    print(user.age)
}

data class User(var name: String, var age: Int)
