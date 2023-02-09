import java.io.FileOutputStream

fun main()
{
    var mydata = "Hello From Tops"
    var fout = FileOutputStream("E://tops1234.txt")
    fout.write(mydata.toByteArray())
    println("Success")
}