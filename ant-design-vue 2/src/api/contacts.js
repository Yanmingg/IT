/**
 * Mocking client-server processing
 */
var _contacts = [
    { "id": 1, "name": "ZhongLi", "organization": "Liyue", "email": "122312@tl.com", "mobile": 1324123, "status": "Star" },
    { "id": 2, "name": "RaiDen", "organization": "Daoqi", "email": "3asfd2@tl.com", "mobile": 1234523, "status": "emergency" },
    { "id": 5, "name": "ToMa", "organization": "Daoqi", "email": "fd2312@dq.com", "mobile": 1354123, "status": "general" },
]
export default {
    getContacts(cb) {
        cb(_contacts)
    },
    createContact(contacts) {
        for (let contact in contacts) {
            _contacts.push(contact)
        }
    },
    deleteContact(ids) {
        for (let id in ids) {
            for (let i in _contacts) {
                if (_contacts[i].id === id) {
                    _contacts.slice(i, 1)
                }
            }
        }
    },
}