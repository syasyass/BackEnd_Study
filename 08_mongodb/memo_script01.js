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


