db.getCollection("memo").find({})

db.getCollection("memo").find({'name' : 'hong'})

db.getCollection("memo").find({'name' : 'Didi'})

// 주석
/* 주석 */
db.getCollection("memo").find({'name' : /Di/}) // 정규 표현식 리터럴: /패턴/

db.getCollection("memo").find({name : /di/i}) // 정규 표현식 /i 대소문자 구분 없이 찾기

db.memo.find({}) //컬렉션 명을 바로 줘도 동작함

db.memo.find({}, { name: 1, age: 1 })

db.memo.find({}, { name: 0 }) //이름을 제외하고 보여달라는 뜻

db.memo.find({}, { name: 0, office: 0 })

db.memo.find({}, { name: 1, office: 0 }) // 혼용 불가! 에러남. 이름만 보겠다는 표현인데 office를 굳이 0으로 쓸 필요가...

db.memo.find({}, { name: 1, _id: 0 }) // 하지만 _id는 별도로 0 지정이 가능. 지정해주지 않으면 id는 항상 나오니까...

db.getCollection("memo").find({}).sort({name : 1}) // 1은 오름차순, -1은 내림차순

db.getCollection("memo").find({}).sort({name : -1}) // 1은 오름차순, -1은 내림차순

db.getCollection("memo").find({}).sort({name : 1, age: 1}) // 1은 오름차순, 동률일 때는 2차 기준인 age로 정렬

db.memo.find({}).count()
db.memo.find({office: 'Yombu'})
db.memo.find({office: 'Yombu'}).count()

db.memo.find({}).limit(5).skip(10) // 10개 건너뛰고, 5개 찾아달라 제한

db.memo.find({}).limit(5).skip(10).sort({name: -1}) // 이름을 내림차순 정렬하고, 10개 건너뛰고, 5개 찾아달라 제한
// 명령어 순서는 중요하지 않음. 최적의 쿼리 순서가 정해지고 실행됨

db.memo.find({ $or: [{name:'Garry'}, {age: 10}] })

db.memo.find()
db.memo.find({name:'Garry'})
db.memo.find({name:'garry'})
db.memo.find({name: /garry/i})
db.memo.find({name: /ry/i})
db.memo.find({name: /ry$/i})    // xx$의 의미: 지정한 패턴으로 끝나는 문자열
db.memo.find({name: /^g/i})    // ^xx의 의미: 지정한 패턴으로 시작하는 문자열
db.memo.find({name:{$not: /ry/i}})

db.travel.find({})
db.travel.find({}).sort({region: -1, title: 1}).skip(10).limit(10)
db.travel.find({}).count()

let query1 = { title: /공원/i }
let query2 = { $or: [{ title: /공원/i }, { description: /공원/i }] }
let order = {region:-1, title:1}
let proj = { _id:0, region:1, title:1 }

db.travel.find(query1).sort(order)
db.travel.find(query1).count()

db.travel.find(query2).sort(order)
db.travel.find(query2, proj).sort(order)
db.travel.find(query2).count()

for(let i = 0; i < 10; i++) {
    db.test.insertOne({
        name: 'kim' + i,
        email: `kim${i}@gmail.com`,
        address: `서울시 ${i}번가`
    })
}

db.test.find()
// db.test.remove({})

let user = db.test.findOne({name: 'kim0'})
print(user)

user.address = '경기도 고양시'
print(user)

db.test.findOne({name: 'kim0'})
db.test.updateOne({name: 'kim0'}, {$set:{address: '경기도 고양시', email: 'kim0@test.com'}})

db.test.updateMany({}, {$set:{ age: 10 }})
db.test.find()

db.test.updateOne({}, {$set:{ age: 20 }})

db.test.deleteOne({name: 'kim0'})
db.test.deleteOne({_id: ObjectId('6528a05dad87356db1c2aca7')})

db.test.find({name: /[2468]$/})
db.test.deleteMany({name: /[2468]$/})
db.test.find()

db.test.deleteMany({})     // 전부 삭제

let query3 = { office:'Wordware' }
let proj2 = { _id:0, age:1, phone:1 }
let proj3 = { _id:0, office:1, name:1 }

db.memo2.find({ office:'Wordware' }, proj2)
db.memo2.find({ age: 1 }, proj3).count()
db.memo2.insertOne({ name: 'hong', age: 200, office: `busan`, phone: 011})
db.memo2.find({ name: 'hong' })
db.memo2.find()
db.memo2.updateOne({age: 2}, {$set:{office: 'seoul'}})
db.memo2.find({ age: 2 })
db.memo2.find({ $or: [{age: 2}, {office: 'busan'}] })
db.memo2.deleteOne({age: 3})
db.memo2.find({ age: 3 })
db.memo2.updateOne({name: 'Didi'}, {$set:{office: 'ulsan'}})
db.memo2.find({ name: 'Didi' })
db.memo2.deleteMany({}) 
db.memo2.drop()

db.getCollectionNames()






