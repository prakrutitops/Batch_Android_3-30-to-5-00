class Student2 //class
{
    var name=""
    var email=""

    fun getdata()
    {
        println("Enter Your Name")
         name = readLine().toString()

        println("Enter Your Email")
        email = readLine().toString()


    }

    fun display()
    {
        println("Your Name is $name")

        println("Your Email $email")


    }



}


fun main()
{
   var s1 = Student2()
    s1.getdata()


    var s2 = Student2()
    s2.getdata()


    s1.display()
    s2.display()
}
