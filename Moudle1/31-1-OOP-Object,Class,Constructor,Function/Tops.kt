//constructor
class Tops(var name:String,var email:String)
{



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

    var s1 = Tops("raj","raj@gmail.com")
    var s2 = Tops("bhagirath","bhagirath@gmail.com")

    s1.display()
    s2.display()



}
