fun main(args: Array<String>) {
    var huga: Huga?
    
    huga = Huga("hoge")
    huga?.let {    
        print("test1 ${huga?.value}\n")
    }
    
    huga = null
    huga?.let {
	    print("test2 ${huga?.value}\n")
    }
}

data class Huga(var value: String)
