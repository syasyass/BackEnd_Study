use admin
db.createUser({user: 'admin', pwd:'1234', roles:['root']})

use shop
db.createUser({user: 'user01', pwd:'1234', roles:['readWrite']})









