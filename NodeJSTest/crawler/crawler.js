var http = require('http')
// 使用之前通过npm安装cheerio： npm install cheerio
var cheerio = require('cheerio')
var url = 'http://www.imooc.com/learn/348'

function filterChapters(html) {

    // load html
    var $ = cheerio.load(html)
    // 通过cheerio查class是.course-wrap的所有内容
    var chapters = $('.course-wrap')

    var courseData = []

    // 循环所有章节
    chapters.each(function(item) {
        // 把上下文赋值给当前
        var chapter = $(this)
        var chapterTitle = chapter.find('h3').text()
        var videos = chapter.find('.video').children('li')
        var chapterData = {
            chapterTitle: chapterTitle,
            videos: []

        }

        videos.each(function (item) {
            var video = $(this).find('.J-media-item')
            var videoTitle = video.text()
            var id = video.attr('href').split('video/')[1]

            chapterData.videos.push({
                title: videoTitle,
                id: id

            })
        })

        // 创建好的对象push给数组
        courseData.push(chapterData)

    })

    return courseData
}

function printCourseInfo(courseData) {
    courseData.forEach(function(item) {
        var chapterTitle = item.chapterTitle

        console.log(chapterTitle + '\n')
        item.videos.forEach(function(video) {
            console.log('[' + video.id + ']' + chapterTitle)
        })
    })
}

http.get(url, function(res) {

    var html = '';
    // response 注册获取到data时的事件
    res.on('data', function(data) {
        html += data
    })

    // 当response接受结束时的事件
    res.on('end', function() {

        // 通过cheerio解析html
        var courseData = filterChapters(html)
        // 打印
        printCourseInfo(courseData)
    })

// 注册一个error事件
}).on('error', function() {
    console.log('爬虫出错。。。')
})



