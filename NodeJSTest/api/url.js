// 所有http请求，路径请求都要用到url
// 引入url模块
const url = require('url')

// 解析出url对象
url.parse('http://baidu.com')

// 解析处的query是一个对象，默认的是一个字符串
url.parse('http://baidu.com', true)

// 不确定是http还是https的情况下这样解析
url.parse('//baidu.com')