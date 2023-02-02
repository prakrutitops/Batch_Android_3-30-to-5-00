 interface M
{
    fun m1()
    {
        println("M Executed")
    }
}
 interface N
{
    fun n1()
    {
        println("N Executed")
    }
}
class Y : M,N
{
    fun y1()
    {
        println("Y Executed")
    }
}
fun main()
{
    var y = Y()
    y.m1()
    y.n1()
    y.y1()



}