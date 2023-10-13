use shop2

db.auth('winner', '1234')

db.getCollection("memo")

db.memo.insertOne({job: 'admin'})

db.memo.find()

db.member.find()