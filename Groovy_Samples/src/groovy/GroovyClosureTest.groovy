package groovy

//groovy闭包

class Example {

    //不需要写public，默认就是public
    static void main(String[] args) {
        //{}就是为闭包准备的
        def closure = {println "Hello World!!!"}
        closure.call()

        //闭包也可以带参数
        def closure2 = {param -> println "Hello $param!!!!"}
        closure.call()

        //以闭包的形式去迭代集合中的数据，it是默认的每一个值得变量
        def list = [1,3,5,7,9]
        list.each {println it}


    }
}



