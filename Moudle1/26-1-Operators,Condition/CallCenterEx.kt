fun main() {

    println("Enter Your Choice:")
    var num = readLine()!!.toInt()

    when (num)
    {
        1->
        {
           println("Your Selected Language is Gujarati")
        }
        2->
        {
            println("Your Selected Language is Hindi")
        }
        3->
        {
            println("Your Selected Language is English")
        }
    }


}