open class P
{
    fun p1()
    {
        println("P Executed")
    }
}
open class Q :P()
{
    fun q1()
    {
        println("Q Executed")
    }
}
open class R : Q()
{
    fun r1()
    {
        println("R Executed")
    }
}
class S :R()
{
    fun s1()
    {
        println("S Executed")
    }
}


fun main()
{
    var mysdetail= S()
    mysdetail.p1()
    mysdetail.q1()
    mysdetail.r1()
    mysdetail.s1()
}