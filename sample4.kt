import kotlin.concurrent.thread
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

fun main(args: Array<String>) {
    val startTime = System.currentTimeMillis()
    val arrayData = Array<Int>(1000) {i -> i}
    for(i in arrayData.indices) {
        val srcValue = arrayData[i]
        val dstValue = srcValue * 2
        arrayData[i] = dstValue
//        print("${dstValue} = ${srcValue} * 2\n")
    }
    val endTime = System.currentTimeMillis()
    print("startTime ${startTime}\n")
    print("endTime ${endTime}\n")
    print("duration ${endTime - startTime}\n")
//    for(j in arrayData.indices) {
//        print("${arrayData[j]}\n")
//    }
}
