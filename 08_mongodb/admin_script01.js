db.getUsers()

use shop2

db.createUser({
    user: 'winner',
    pwd: '1234',
    roles: ['readWrite', 'dbAdmin']
})

use shop

db.createUser({
    user: 'user',
    pwd: '1234',
    roles: ['readWrite', 'dbAdmin']
})

db.memo.find()

db.memo.findOne({age : 500})

