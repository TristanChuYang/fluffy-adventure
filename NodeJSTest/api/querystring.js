// 引入queryString模块
const querystring = require('querystring')

// 序列化
querystring.stringify({name:'chuyang',course:['node','react'],from:''})
// 结果-'name=chuyang&course=node&course=react&from='

// 修改连接多个参数以及key和value中间的符号
querystring.stringify({name:'chuyang',course:['node','react'],from:''},',',':')
// 结果-'name:chuyang,course:node,course:react,from:'

// 反序列化
querystring.parse('name=chuyang&course=node&course=react&from=')
// 结果-{ name: 'chuyang', course: [ 'node', 'react' ], from: '' }

// 转义
querystring.escape('哈哈')
// 结果-'%E5%93%88%E5%93%88'

// 反转义
querystring.unescape('%E5%93%88%E5%93%88');
// 结果-'哈哈'
