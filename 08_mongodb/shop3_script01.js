db

use shop3 // 데이터베이스를 바꾸겠다는 뜻. 만든 적 없는 DB여도 mongoDB는 만들어 줌

show collections                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 ions

db.createCollection('member')
db.getCollection("member").stats()
db.bbs.insert({'title' : 'win', 'content' : 'fun'})
db.bbs.insert({'title' : 'win2', hearts : 5, 'content' : 'fun2'})
db.bbs.find({})
    
show databases

db.bbs.drop()

show collections

db.dropDatabase()

show databases

use shop3

db.member.insert({
    id: 'hong',
    pw: '1234',
    name: 'hong',
    tel: '011'
})

db.member.insertOne({
    id: 'kim',
    pw: '1234',
    name: 'kim',
    tel: '011'
})

db.member.find({})

db.member.insertMany([
    {    id: 'lee',    pw: '1234',    name: 'lee',    tel: '010'    },
    {    id: 'park', pw: '1234',    name: 'park',    tel: '010'    },
    {    id: 'choi', pw: '1234',    name: 'choi',    tel: '017'    },
])

db.member.find({})

use shop5

show databases

show collections

db.createCollection('member')

db.member.insertOne({
    id: 'hong',
    pw: '1234',
    name: 'honggildong',
    tel: '011'
})

db.member.find({})

db.member.insertMany([
    {    id: 'kim',    pw: '1234',    name: 'kimdong',    tel: '012'    },
    {    id: 'park', pw: '1234',    name: 'parkdong',    tel: '013'    },
])

db.member.drop()

db.dropDatabase()

show databases

use shop3

for(i=1; i <= 10; i++) {
    let user = {
        name: 'kim' + i,
        pw: '1234',
        email: 'kim' + i + '@gmail.com'
    }
    print(user)
    db.member.insert(user) // db에 넣어주기
}

db.member.find({ name : 'kim' })

db.member.find({})

db.member.findOne({ _id: ObjectId('6527763eebce2299f91fae85') }) //_id로 검색 방법 잘 알아두기

db.member.find({}, { name: 1, pw : 1 })

let result = db.member.find({})

for(let i = 0; i < result.length; i++) {
    print(result[i]);
}

db.member.find({
    name: 'kim1',
    pw: '1234'
})

db.member.find({
    name: 'kim', pw: '1234'
})

db.member.find({$and: [
    {name: 'kim'}, {pw: '1234'}
]})

db.member.find({$or: [
    {name: 'kim'}, {pw: '1234'}
]})

let obj = db.member.find({_id: ObjectId('6527772debce2299f91fae87')})
print(obj)

use shop

db.memo.find()

// age 필드의 값이 3 이하
db.memo.find({age: {$lte : 3}}) // age <= 3

db.memo.find({age: {$in : [10, 20, 30]}})

// age 3 초과, 8 미만 검색 ==> and
db.memo.find({$and: [ 
    {age: {$gt : 3}}, 
    {age: {$lt : 8}} 
]})




