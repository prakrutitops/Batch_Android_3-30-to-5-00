import java.lang.Exception

class CheckData
{
    fun detail()
    {
        //logic
        try
        {
            var num = 25/0
            println(num)
        }
        //error
        catch(e:Exception)
        {
            e.printStackTrace()
        }
        finally
        {
            println("Executed")
        }

    }
}
fun main()
{
    var c = CheckData()
    c.detail()

}