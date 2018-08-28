// 引入emitter（事件发射器）
var EventEmitter = require('events').EventEmitter

// 创建一个事件发射器
var life = new EventEmitter()

// 利用on方法注册多事件
var dont = function (who) {
    console.log('dont do this for ' + who)
}
life.on('please', dont)

life.on('please', function (who) {
    console.log('do this for ' + who)
})


// 通过emit方法调用事件，可以通过返回值得知是否被监听
var hasListenr = life.emit('please', 'me')
console.log(hasListenr)

// 移除监听器要使用具名函数，不可以使用匿名函数
//life.removeListener('please', dont)

// 默认对一个事件不要设置超过10个监听器, 可以通过如下方式修改
//life.setMaxListeners(11)





