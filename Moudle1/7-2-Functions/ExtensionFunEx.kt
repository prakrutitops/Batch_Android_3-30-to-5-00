class MyFirstClass
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
fun MyFirstClass.isscholar(marks: Int):Boolean
{
    return marks>90
}