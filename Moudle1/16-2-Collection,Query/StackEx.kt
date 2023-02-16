import java.lang.Exception
import java.util.*

class StackEx {


    fun pushdata(s: Stack<Int>, num: Int) {

        s.push(num)

        println(num)
        println(s)


    }

    fun popdata(s: Stack<Int>) {

        var i: Int = s.pop()

        println(i)
        println(s)

    }
}
fun main()
{

    var s1 = Stack<Int>()
    var s2 = StackEx()

    s2.pushdata(s1,10)
    s2.pushdata(s1,20)
    s2.pushdata(s1,30)
    s2.pushdata(s1,40)

    try
    {
        s2.popdata(s1)
        s2.popdata(s1)
        s2.popdata(s1)
        s2.popdata(s1)
        s2.popdata(s1)
        s2.popdata(s1)

    }
    catch(e:Exception)
    {
        println("Empty Stack")
    }
    finally
    {
        println("Executed")
    }




}