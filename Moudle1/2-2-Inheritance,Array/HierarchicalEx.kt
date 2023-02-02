open class Bank
{
    fun bank()
    {
        println("Banking")
    }
}
class Current :Bank()
{
    fun current()
    {
        println("Current")
    }
}
class Save :Bank()
{
    fun save()
    {
        println("Saving")
    }
}

fun main()
{
    var c1 = Current()
    var s1= Save()

    c1.current()
    s1.save()
    s1.bank()
}