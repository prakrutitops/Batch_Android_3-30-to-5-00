data class dataclassEx(var id:Int,var name:String)
{

}
fun main()
{
    var d1 = dataclassEx(101,"Tops")
    var d2 = dataclassEx(101,"Tops")
    var d3 = d1.copy()
    println(d1)
    println(d2)

    println(d2.toString())
    println(d1.equals(d2))

    if(d1==d2)
    {
            println("Equal")
    }
    else
    {
        println("Not Equal")
    }
    println(d3)


}