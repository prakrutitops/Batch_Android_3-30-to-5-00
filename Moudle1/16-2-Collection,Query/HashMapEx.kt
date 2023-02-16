class HashMapEx
{
    fun exe()
    {
        var map = HashMap<String,Int>()
        map.put("A",101)
        map.put("B",102)
        map.put("C",103)
//set
        for(m:Map.Entry<String,Int> in map.entries)
        {
            //get
            println(m.key)
            println(m.value)
        }


    }
}
fun main()
{
    var m = HashMapEx()
    m.exe()
}