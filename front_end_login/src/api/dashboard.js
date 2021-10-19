/**
 * Mocking client-server processing
 */
var _task = [
    { "id": 1, "name": "ZhongLi", "time": "2021/10/19 19:30:00" },
    { "id": 2, "name": "RaiDen", "time": "2021/10/13 20:30:00" },
    { "id": 3, "name": "ToMa", "time": "2021/10/31 14:55:00" },
]
export default {
    getClosetTask(cb) {
        var index = 0
        var closest = new Date(_task[index].time)
        var time = new Date()
        for (let i in _task) {
            if (time - _task[i] > 0) {
                if (new Date(_task[i].time) - closest > 0) {
                    closest = new Date(_task[i].time)
                    index = i
                }
            }
        }
        cb(_task[index])
    },
}