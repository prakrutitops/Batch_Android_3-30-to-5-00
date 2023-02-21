sealed class Ex2
{
    class A:Ex2() //class
    object b :Ex2() //object



}
fun main()
{
    val input : Ex2 = Ex2.b

   val output =  when(input)
    {
        is Ex2.A-> "Class Called"
        is Ex2.b-> "Object Called"
    }
    println(output)
/*
    val output = when(x)
    {
        is Ex2.A1->"A class"
        is Ex2.c->"object"
    }
    println(output)*/



}
