import kotlin.concurrent.thread
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

fun main(args: Array<String>) {
    val startTime = System.currentTimeMillis()

    val threadNum = 5
    val lock = ReentrantLock()
    val arrayData = Array<Int>(1000) {i -> i}
    var threadFlagList = Array<Boolean>(threadNum) {i -> false}
    val valueByThread = arrayData.count() / threadNum
    
    for(i in 0..(threadNum - 1)) {
        val startIndex = i * valueByThread
        val endIndex = ((i + 1) * valueByThread) - 1
        thread {
            (startIndex..endIndex).forEach {
                val srcValue = arrayData[it]
                val dstValue = srcValue * 2
                arrayData[it] = dstValue
            }
            threadFlagList[i] = true
            lock.withLock {
                val count = threadFlagList.filter {
                    it == true
                }.count()
                if (count == threadNum) {
                    val endTime = System.currentTimeMillis()
                    print("startTime ${startTime}\n")
                    print("endTime ${endTime}\n")
                    print("duration ${endTime - startTime}\n")
//                    for(j in arrayData.indices) {
//                        print("${arrayData[j]}\n")
//                    }
                }
            }    
        }
    }
}
