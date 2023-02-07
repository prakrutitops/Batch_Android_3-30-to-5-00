fun addition4()
{
    println("Enter value for a: ")
    var a= readLine()!!.toInt()
    println("Enter value for b: ")
    var b = readLine()!!.toInt()
    var c=a+b
    println(c)
}

fun main()
{

    for(i in 1..5)
    {
        addition4()
    }

}