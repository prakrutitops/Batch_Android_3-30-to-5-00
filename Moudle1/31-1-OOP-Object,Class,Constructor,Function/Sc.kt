class Sc
{
    var num=1
    var sqaure=1
    var cube=1

    fun getdata()
    {
        println("Enter Any Number")
         num = readLine()!!.toInt()
         sqaure = num*num
         cube = num*num*num
    }

    fun display()
    {
        println(sqaure)
        println(cube)
    }




    }
fun main()
{

    var s1 = Sc()
    s1.getdata()
    s1.display()

    var s2 = Sc()
    s2.getdata()
    s2.display()






}