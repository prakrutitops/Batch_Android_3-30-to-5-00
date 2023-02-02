open class R1
{
    fun r1()
    {
        println("R1 Executed")
    }
}
interface G1
{
    fun g1()
    {
        println("G1 Executed")
    }

}
open class B1 :R1(),G1
{
    fun b1()
    {
        println("B1 Executed")
    }
}
class T1 :B1()
{
    fun t1()
    {
        println("T1 Executed")
    }
}

fun main()
{
    var t = T1()
    t.t1()
    t.b1()
    t.g1()
    t.r1()

}