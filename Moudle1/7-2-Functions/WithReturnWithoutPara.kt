fun addition3() :Int
{
    println("Enter value for a: ")
    var a= readLine()!!.toInt()
    println("Enter value for b: ")
    var b = readLine()!!.toInt()
    var c=a+b
    return  c
}

fun main()
{

    println(addition3())

}