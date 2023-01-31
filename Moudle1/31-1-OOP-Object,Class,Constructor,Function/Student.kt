class Student //class
{

    //variable - data member
    var name=""
    var email=""

    //Function
    fun display()
    {
        //print data
        println("Your Name is $name")
        println("Your Email is $email")
        println("========================")
    }


}


fun main()
{
    //object

   var s1 = Student()
    s1.name="Raj"
    s1.email="raj@gmail.com"

    var s2 = Student()
    s2.name="bhagirath"
    s2.email="bhagirath@gmail.com"

    var s3 = Student()
    s3.name="tasmin"
    s3.email="tasmin@gmail.com"

    var s4 = Student()
    s4.name="shruti"
    s4.email="shruti@gmail.com"


    s1.display()

    s2.display()

    s3.display()

    s4.display()
}
