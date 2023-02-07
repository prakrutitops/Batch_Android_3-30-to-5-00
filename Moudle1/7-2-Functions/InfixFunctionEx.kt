class MyFirstClass2
{
    fun haspassed(marks:Int):Boolean
    {
        return marks>35
    }


}
fun main()
{
    var m1 = MyFirstClass()
    println("Pass Status :"+m1.haspassed(95))
    println("Scholarship Status: "+m1.isscholar(95))
}
//extension function
infix fun MyFirstClass2.isscholar(marks: Int):Boolean
{
    return marks>90
}