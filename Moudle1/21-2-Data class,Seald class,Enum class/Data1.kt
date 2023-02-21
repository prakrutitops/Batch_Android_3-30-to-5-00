 abstract class MyAbstractClass
{
    abstract var str : String
    var name : String = "JAVA"
    abstract  fun a()

        fun b()
        {

        }
}

 class Class2 : MyAbstractClass()
 {
     override var str: String
         get() = println("Tops Tech").toString()
         set(value)
         {
             println("Tops Tech")
         }

     override fun a()
     {
        println("A Called")
     }

 }

fun main()
{
    var a = Class2()
    a.name
    a.str
}