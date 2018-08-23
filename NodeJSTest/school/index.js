var klass = require('./klass')

klass.add('Scott',['gordon', 'tristan'])

exports.add = function(klasses) {
    klasses.forEach(function (item, index) {
        var _klass = item
        var teacherName = item.teacherName
        var students = item.students

        klasses.add(teacherName, students)
    })

}