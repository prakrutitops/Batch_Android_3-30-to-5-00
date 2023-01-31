//Default Constructor
class ChangedValueEx(var n1:Int,var n2:Int)
{

    fun data()
    {
        var n3 = n1+n2
        println(n3)

    }

}

fun main()
{
        var a1 = ChangedValueEx(2,3)
        a1.data()

        var a2 = ChangedValueEx(20,30)
        a2.data()
}