fun main()
{
   // var a = mapOf<String,Int>("a" to 1,"b" to 2,"c" to 3)
    var a = mutableMapOf<String,Int>()
    a.put("a",1)
    a.put("b",2)
    a.put("c",3)


    println(a.get("b"))


}