import java.util.*
//add,addAll,remove,removeAll,retainAll
class VectorEx
{
    fun exe()
    {
        var v = Vector<String>(5)
        v.addElement("A")
        v.addElement("B")
        v.addElement("C")
        v.addElement("D")
        v.addElement("D")
        v.addElement("D")
        v.addElement("C")
        v.addElement("D")
        v.addElement("D")
        v.addElement("D")
        v.addElement("C")
        v.addElement("D")
        v.addElement("D")
        v.addElement("D")

        println("capacity: "+v.capacity())
        println("size : "+v.size)

        if(v.contains("E"))
        {
            println("YES")
        }
        else
        {
            println("NO")
        }
        println(v.firstElement())
        println(v.lastElement())
    }
}

fun main()
{
    var v = VectorEx()
    v.exe()
}


