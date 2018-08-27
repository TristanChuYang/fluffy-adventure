// 定义一个函数
function Pet(words) {
    this.words = words
    this.speak = function () {
        console.log(this.words)
    }
}

// 再定义一个函数Dog
function Dog(words) {
    // 通过这种方式实现继承
    // 可以理解为把this上下文指向Pet，来让Dog使用Pet的speak方法
    Pet.call(this, words)
}

var dog = new Dog('wang')

dog.speak()