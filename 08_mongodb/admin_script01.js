db.getUsers()

use shop2

db.createUser({
    user: 'winner',
    pwd: '1234',
    roles: ['readWrite', 'dbAdmin']
})