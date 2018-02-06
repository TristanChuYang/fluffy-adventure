package groovy

//元编程，类似于反射，可以自己编程的写法
class Student implements GroovyInterceptable {

    //提供了如果没有调用属性，也可以正常调用
    protected dynamicProps = [:]

    void setProperty(String pName, val) {
        dynamicProps[pName] = val;
    }

    def getProperty(String pName) {
        dynamicProps[pName]
    }

    //如果调用方法缺失则不会报错
    /*def invokeMethod(String name, Object args) {

        return "called invokeMethod $name $args"
    }*/

    //如果调用方法缺失会打印信息
    def methodMissing(String name, def args) {

        println("Missing Method...")
    }

}

class Example2 {

    static void main(String[] args) {

        Student student = new Student()
        student.name = "gordon"
        student.age = 18

        println(student.name + ";" + student.age)
        student.addMarks()
    }

}

def sayHello() {

    return "Hello World from Groovy!!!!"

}







