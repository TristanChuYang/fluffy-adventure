// 定义一个对象，有一个属性，一个函数
var pet = {
    words : '...',
    speak : function(hello) {
        console.log(hello + ' ' + this.words)
    }
}

// 定义一个dog对象，有一个和pet中相同的属性，但是没有speak函数
var dog = {
    words : 'dog'
}

// 通过调用call，来吧this的上下文改变为dog对象
pet.speak.call(dog, 'wang')




