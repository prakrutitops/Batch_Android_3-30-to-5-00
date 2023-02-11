class T22 : Runnable
{
    override fun run()
    {
        for(i in 1..10)
        {
            println("Thread A: $i")
        }
    }

}
class T33 :Runnable
{
    override fun run()
    {
        for(i in 1..10)
        {
            println("Thread B: $i")
        }
    }

}
fun main()
{

    var t1 = Thread(T22())
    var t2 = Thread(T33())

    t1.start()
    t2.start()

}