/**
 * Mocking client-server processing
 */
 const _contacts = []
export default {
    getContacts(cb) {
        this.$axios(`http://localhost:8081/contact/findAll`).then(res => {
          this._contacts = res.data
        })
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
